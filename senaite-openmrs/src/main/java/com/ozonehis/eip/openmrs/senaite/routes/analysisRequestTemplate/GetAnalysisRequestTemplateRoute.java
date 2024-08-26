/*
 * Copyright © 2021, Ozone HIS <info@ozone-his.com>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.ozonehis.eip.openmrs.senaite.routes.analysisRequestTemplate;

import com.ozonehis.eip.openmrs.senaite.Constants;
import com.ozonehis.eip.openmrs.senaite.config.SenaiteConfig;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAnalysisRequestTemplateRoute extends RouteBuilder {

    @Autowired
    private SenaiteConfig senaiteConfig;

    private static final String GET_ANALYSIS_REQUEST_TEMPLATE_ENDPOINT =
            "/@@API/senaite/v1/ARTemplate?complete=true&catalog=senaite_catalog_setup&Description=";

    @Override
    public void configure() {
        // spotless:off
        from("direct:senaite-get-analysis-request-template-route")
                .log(LoggingLevel.INFO, "Fetching AnalysisRequestTemplate in SENAITE...")
                .routeId("senaite-get-analysis-request-template-route")
                .setHeader(Constants.CAMEL_HTTP_METHOD, constant(Constants.GET))
                .setHeader(Constants.CONTENT_TYPE, constant(Constants.APPLICATION_JSON))
                .setHeader(Constants.AUTHORIZATION, constant(senaiteConfig.authHeader()))
                .toD(senaiteConfig.getSenaiteBaseUrl() + GET_ANALYSIS_REQUEST_TEMPLATE_ENDPOINT + "${header."
                        + Constants.HEADER_DESCRIPTION + "}")
                .end();
        // spotless:on
    }
}
