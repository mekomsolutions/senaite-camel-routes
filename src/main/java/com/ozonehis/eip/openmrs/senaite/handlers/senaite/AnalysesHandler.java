package com.ozonehis.eip.openmrs.senaite.handlers.senaite;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ozonehis.eip.openmrs.senaite.model.analyses.Analyses;
import com.ozonehis.eip.openmrs.senaite.model.analyses.AnalysesResponse;
import java.util.Map;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Setter
@Component
public class AnalysesHandler {

    public Analyses getAnalyses(ProducerTemplate producerTemplate, Map<String, Object> headers)
            throws JsonProcessingException {
        String response = producerTemplate.requestBodyAndHeaders(
                "direct:senaite-get-analyses-route", null, headers, String.class);
        log.error("getAnalyses response {}", response);
        ObjectMapper objectMapper = new ObjectMapper();
        AnalysesResponse analysisRequestResponse = objectMapper.readValue(response, AnalysesResponse.class);
        log.error("getAnalyses {}", analysisRequestResponse);
        return analysisRequestResponse.analysesResponseToAnalyses(analysisRequestResponse);
    }
}
