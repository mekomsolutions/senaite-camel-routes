package com.ozonehis.eip.openmrs.senaite.routes.analyses;

import com.ozonehis.eip.openmrs.senaite.Constants;
import com.ozonehis.eip.openmrs.senaite.client.SenaiteClient;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAnalysesRoute extends RouteBuilder {

    @Autowired
    private SenaiteClient senaiteClient;

    @Override
    public void configure() {
        // spotless:off
        from("direct:senaite-get-analyses-route")
                .log(LoggingLevel.INFO, "Fetching AnalysisRequest in SENAITE...")
                .routeId("senaite-get-analyses-route")
                .setHeader(Constants.CAMEL_HTTP_METHOD, constant(Constants.GET))
                .setHeader(Constants.CONTENT_TYPE, constant(Constants.APPLICATION_JSON))
                .setHeader(Constants.AUTHORIZATION, constant(senaiteClient.authHeader()))
                .toD("${header." + Constants.HEADER_ANALYSES_GET_ENDPOINT + "}")
                .log("Response get-analyses: ${body}")
                .end();
        // spotless:on
    }
}
