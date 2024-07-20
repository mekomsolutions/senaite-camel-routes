/*
 * Copyright © 2021, Ozone HIS <info@ozone-his.com>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.ozonehis.eip.openmrs.senaite.routes.openmrsFhirTask;

import com.ozonehis.eip.openmrs.senaite.Constants;
import com.ozonehis.eip.openmrs.senaite.client.OpenmrsFhirClient;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetOpenmrsFhirTaskByStatusRoute extends RouteBuilder {

    @Autowired
    private OpenmrsFhirClient openmrsFhirClient;

    public static final String GET_BY_STATUS_ENDPOINT = "/Task?status=requested,accepted";

    @Override
    public void configure() {
        // spotless:off
        from("direct:openmrs-get-task-by-status-route")
                .log(LoggingLevel.INFO, "Fetching Task by Status in OpenMRS...")
                .routeId("openmrs-get-task-by-status-route")
                .setHeader(Constants.CAMEL_HTTP_METHOD, constant(Constants.GET))
                .setHeader(Constants.CONTENT_TYPE, constant(Constants.APPLICATION_JSON))
                .setHeader(Constants.AUTHORIZATION, constant(openmrsFhirClient.authHeader()))
                .toD(openmrsFhirClient.getOpenmrsFhirBaseUrl() + GET_BY_STATUS_ENDPOINT)
                .end();
        // spotless:on
    }
}
