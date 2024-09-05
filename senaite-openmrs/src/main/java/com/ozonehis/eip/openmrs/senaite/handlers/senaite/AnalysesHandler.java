/*
 * Copyright © 2021, Ozone HIS <info@ozone-his.com>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.ozonehis.eip.openmrs.senaite.handlers.senaite;

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
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Setter
@Component
public class AnalysesHandler {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public AnalysesDTO getAnalysesByAnalysesApiUrl(ProducerTemplate producerTemplate, String analysesApiUrl)
            throws JsonProcessingException {
        Map<String, Object> headers = new HashMap<>();
        headers.put(Constants.HEADER_ANALYSES_GET_ENDPOINT, analysesApiUrl);
        String response = producerTemplate.requestBodyAndHeaders(
                "direct:senaite-get-analyses-route", null, headers, String.class);
        TypeReference<SenaiteResponseWrapper<AnalysesItem>> typeReference = new TypeReference<>() {};
        SenaiteResponseWrapper<AnalysesItem> responseWrapper = objectMapper.readValue(response, typeReference);
        return AnalysesMapper.map(responseWrapper);
    }
}
