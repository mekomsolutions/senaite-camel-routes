/*
 * Copyright © 2021, Ozone HIS <info@ozone-his.com>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.ozonehis.eip.openmrs.senaite.handlers.openmrs;

import ca.uhn.fhir.context.FhirContext;
import java.util.ArrayList;
import java.util.List;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.ProducerTemplate;
import org.hl7.fhir.r4.model.DiagnosticReport;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.ServiceRequest;
import org.springframework.stereotype.Component;

@Slf4j
@Setter
@Component
public class DiagnosticReportHandler {

    public DiagnosticReport sendDiagnosticReport(ProducerTemplate producerTemplate, DiagnosticReport diagnosticReport) {
        String response = producerTemplate.requestBody(
                "direct:openmrs-create-diagnostic-report-route", diagnosticReport, String.class);
        FhirContext ctx = FhirContext.forR4();
        DiagnosticReport savedDiagnosticReport = ctx.newJsonParser().parseResource(DiagnosticReport.class, response);
        return savedDiagnosticReport;
    }

    public DiagnosticReport buildDiagnosticReport(
            ArrayList<String> observationUuids, ServiceRequest serviceRequest, String labResultsEncounterID) {
        DiagnosticReport diagnosticReport = new DiagnosticReport();
        diagnosticReport.setStatus(DiagnosticReport.DiagnosticReportStatus.FINAL);
        diagnosticReport.setCode(serviceRequest.getCode());
        diagnosticReport.setSubject(serviceRequest.getSubject());
        diagnosticReport.setEncounter(new Reference().setReference("Encounter/" + labResultsEncounterID));
        List<Reference> referenceList = new ArrayList<>();
        for (String observationUuid : observationUuids) {
            referenceList.add(new Reference().setReference("Observation/" + observationUuid));
        }
        diagnosticReport.setResult(referenceList);
        return diagnosticReport;
    }
}
