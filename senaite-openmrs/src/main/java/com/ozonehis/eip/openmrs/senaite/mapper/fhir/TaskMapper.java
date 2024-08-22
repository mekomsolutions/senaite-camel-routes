/*
 * Copyright © 2021, Ozone HIS <info@ozone-his.com>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.ozonehis.eip.openmrs.senaite.mapper.fhir;

import com.ozonehis.eip.openmrs.senaite.mapper.ToFhirMapping;
import com.ozonehis.eip.openmrs.senaite.model.analysisRequest.AnalysisRequestDAO;
import org.hl7.fhir.r4.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper implements ToFhirMapping<Task, AnalysisRequestDAO> {

    @Override
    public Task toFhir(AnalysisRequestDAO analysisRequestDAO) {
        Task task = new Task();
        task.setIntent(Task.TaskIntent.ORDER);
        task.addBasedOn().setReference(analysisRequestDAO.getClientSampleID()).setType("ServiceRequest");
        return task;
    }
}
