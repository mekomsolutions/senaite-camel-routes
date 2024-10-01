/*
 * Copyright © 2021, Ozone HIS <info@ozone-his.com>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.ozonehis.eip.openmrs.senaite.handlers.senaite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ozonehis.eip.openmrs.senaite.Constants;
import com.ozonehis.eip.openmrs.senaite.model.SenaiteResponseWrapper;
import com.ozonehis.eip.openmrs.senaite.model.analyses.AnalysesDTO;
import com.ozonehis.eip.openmrs.senaite.model.analyses.AnalysesMapper;
import com.ozonehis.eip.openmrs.senaite.model.analyses.response.AnalysesItem;
import java.util.HashMap;
import java.util.Map;
import org.apache.camel.ProducerTemplate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class AnalysesHandlerTest {

    @Mock
    private ProducerTemplate producerTemplate;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private AnalysesHandler analysesHandler;

    private static AutoCloseable mocksCloser;

    @BeforeEach
    void setup() {
        mocksCloser = openMocks(this);
    }

    @AfterAll
    static void close() throws Exception {
        mocksCloser.close();
    }

    @Test
    void getAnalysesByAnalysesApiUrl() throws JsonProcessingException {
        // Setup
        String analysesApiUrl = "http://test.com/api/analyses";
        String responseBody =
                "{\"count\":1,\"pagesize\":25,\"items\":[{\"Category\":{\"url\":\"http://localhost:8081/bika_setup/bika_analysiscategories/analysiscategory-1\",\"uid\":\"47bcfb01a03a4be8ba778e3274d392f1\",\"api_url\":\"http://localhost:8081/senaite/@@API/senaite/v1/analysiscategory/47bcfb01a03a4be8ba778e3274d392f1\"},\"Uncertainties\":null,\"total_comments\":null,\"SortKey\":null,\"expirationDate\":null,\"Department\":{\"url\":\"http://localhost:8081/bika_setup/bika_departments/department-1\",\"uid\":\"0eefa19ad08f472dba9be2b0d3aef829\",\"api_url\":\"http://localhost:8081/senaite/@@API/senaite/v1/department/0eefa19ad08f472dba9be2b0d3aef829\"},\"RetestOf\":{},\"exclude_from_nav\":null,\"Method\":{},\"effectiveDate\":null,\"last_comment_date\":null,\"ShortTitle\":\"Red blood cells\",\"title\":\"Red blood cells\",\"ProtocolID\":null,\"sync_uid\":null,\"Precision\":2,\"parent_id\":\"BLD-0109-P01\",\"Unit\":null,\"location\":null,\"parent_url\":\"http://localhost:8081/senaite/@@API/senaite/v1/analysisrequest/cbb1d9a225f94f139a8632e81d2d893b\",\"Keyword\":\"LAB-047\",\"start\":null,\"mime_type\":null,\"UpperDetectionLimit\":\"1000000000.0000000\",\"HiddenManually\":true,\"ResultOptions\":null,\"NumberOfRequiredVerifications\":-1,\"portal_type\":\"Analysis\",\"language\":\"en\",\"ExponentialFormatPrecision\":7,\"CommercialID\":null,\"DetectionLimitOperand\":null,\"parent_uid\":\"cbb1d9a225f94f139a8632e81d2d893b\",\"VAT\":\"0.00\",\"parent_path\":\"/senaite/clients/client-33/BLD-0109-P01\",\"rights\":null,\"Calculation\":null,\"AnalysisService\":{\"url\":\"http://localhost:8081/bika_setup/bika_analysisservices/analysisservice-37\",\"uid\":\"7d6d67fac98f461f8dac2ef8339767da\",\"api_url\":\"http://localhost:8081/senaite/@@API/senaite/v1/analysisservice/7d6d67fac98f461f8dac2ef8339767da\"},\"modified\":\"2024-09-30T11:21:55+00:00\",\"InterimFields\":null,\"Analyst\":null,\"allowDiscussion\":null,\"StringResult\":null,\"Hidden\":null,\"Attachment\":{},\"DuplicateVariation\":\"10.00\",\"uid\":\"043bcbb7f3234e99acc99de7f992100c\",\"contributors\":null,\"BulkPrice\":\"0.00\",\"author_name\":null,\"creation_date\":\"2024-09-30T11:20:16+00:00\",\"Instrument\":{},\"ScientificName\":null,\"commentators\":null,\"PointOfCapture\":\"lab\",\"id\":\"LAB-047\",\"ResultsRange\":null,\"ResultCaptureDate\":\"2024-09-30T11:21:36+00:00\",\"end\":null,\"api_url\":\"http://localhost:8081/senaite/@@API/senaite/v1/analysis/043bcbb7f3234e99acc99de7f992100c\",\"analysisRequestTemplates\":null,\"author\":\"admin\",\"is_folderish\":null,\"Price\":\"0.00\",\"ResultOptionsType\":\"select\",\"Remarks\":null,\"getClientID\":null,\"review_state\":null,\"subject\":null,\"PrecisionFromUncertainty\":null,\"AttachmentRequired\":null,\"AllowManualDetectionLimit\":null,\"Uncertainty\":null,\"description\":\"Blood test to measure the number of red blood cells.(679AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA)\",\"Accredited\":null,\"tags\":[],\"expires\":\"2499-12-31T00:00:00+00:00\",\"path\":\"/senaite/clients/client-33/BLD-0109-P01/LAB-047\",\"LowerDetectionLimit\":\"0.0000000\",\"MaxTimeAllowed\":{\"hours\":2,\"minutes\":0,\"days\":0},\"InstrumentEntryOfResults\":null,\"modification_date\":\"2024-09-30T11:21:55+00:00\",\"effective\":\"1000-01-01T00:00:00+00:00\",\"created\":\"2024-09-30T11:20:16+00:00\",\"url\":\"http://localhost:8081/clients/client-33/BLD-0109-P01/LAB-047\",\"ManualEntryOfResults\":true,\"DetectionLimitSelector\":null,\"AllowManualUncertainty\":null,\"Result\":\"4.5\",\"creators\":[\"admin\"],\"in_response_to\":null,\"SelfVerification\":-1}],\"page\":1,\"_runtime\":0.012331008911132812,\"next\":null,\"pages\":1,\"previous\":null}";
        Map<String, Object> headers = new HashMap<>();
        headers.put(Constants.HEADER_ANALYSES_GET_ENDPOINT, analysesApiUrl);

        // Mock
        when(producerTemplate.requestBodyAndHeaders(
                        eq("direct:senaite-get-analyses-route"), isNull(), eq(headers), eq(String.class)))
                .thenReturn(responseBody);

        TypeReference<SenaiteResponseWrapper<AnalysesItem>> typeReference = new TypeReference<>() {};
        SenaiteResponseWrapper<AnalysesItem> responseWrapper = objectMapper.readValue(responseBody, typeReference);

        AnalysesDTO analysesDTO = new AnalysesDTO();
        analysesDTO.setResult("4.5");
        analysesDTO.setResultCaptureDate("2024-09-30T11:21:36+00:00");
        analysesDTO.setDescription(
                "Blood test to measure the number of red blood cells.(679AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA)");
        when(AnalysesMapper.map(responseWrapper)).thenReturn(analysesDTO);

        // Act
        AnalysesDTO result = analysesHandler.getAnalysesByAnalysesApiUrl(producerTemplate, analysesApiUrl);

        // Verify
        assertEquals(analysesDTO, result);
    }
}
