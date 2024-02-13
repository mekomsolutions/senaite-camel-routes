package com.ozonehis.eip.routes.senaite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.support.DefaultExchange;
import org.apache.camel.test.spring.junit5.MockEndpoints;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestExecutionListeners.MergeMode;

@MockEndpoints
@TestExecutionListeners(mergeMode = MergeMode.REPLACE_DEFAULTS)
public class RetrieveContactNamesRouteITest extends BaseCamelRoutesTest {

    @EndpointInject(value = "mock:authenticateToOpenmrsRoute")
    private MockEndpoint authenticateToOpenmrs;

    @EndpointInject(value = "mock:requesterEndpoint")
    private MockEndpoint requesterEndpoint;

    @BeforeEach
    public void setup() throws Exception {
        loadXmlRoutesInDirectory("camel", "retrieve-orderer-names-from-openmrs-route.xml");

        advise("retrieve-orderer-names-from-openmrs", new AdviceWithRouteBuilder() {
            @Override
            public void configure() {
                weaveByToString("To[direct:authenticate-to-openmrs]").replace().toD("mock:authenticateToOpenmrsRoute");
                weaveByToString(".*/\\$\\{exchangeProperty.requester-reference\\}]")
                        .replace()
                        .toD("mock:requesterEndpoint");
            }
        });

        setupExpectations();
    }

    @AfterEach
    public void reset() throws Exception {
        authenticateToOpenmrs.reset();
        requesterEndpoint.reset();
    }

    @Test
    public void shouldSetFamilyAndGivenRequesterNames() throws Exception {
        // setup
        Exchange exchange = new DefaultExchange(camelContext);
        exchange.setProperty("requester-reference", "Practitioner/d042d719-1d09-11ec-9616-0242ac1a000a");

        // replay
        producerTemplate.send("direct:retrieve-orderer-names-from-openmrs", exchange);

        // verify
        authenticateToOpenmrs.assertExchangeReceived(0);
        requesterEndpoint.assertIsSatisfied();
        assertEquals("Man", exchange.getProperty("requester-family-name"));
        assertEquals("Super", exchange.getProperty("requester-given-name"));
    }

    private void setupExpectations() {
        requesterEndpoint.whenAnyExchangeReceived(
                exchange -> exchange.getIn()
                        .setBody(
                                "{\"resourceType\":\"Practitioner\",\"id\":\"d042d719-1d09-11ec-9616-0242ac1a000a\",\"text\":{\"status\":\"generated\",\"div\":\"<div/>\"},\"identifier\":[{\"system\":\"http://fhir.openmrs.org/ext/provider/identifier\",\"value\":\"superman\"}],\"active\":true,\"name\":[{\"id\":\"d041e155-1d09-11ec-9616-0242ac1a000a\",\"family\":\"Man\",\"given\":[\"Super\"]}],\"gender\":\"male\"}"));
        requesterEndpoint.expectedHeaderReceived(Exchange.HTTP_METHOD, "GET");
        requesterEndpoint.expectedPropertyReceived(
                "requester-reference", "Practitioner/d042d719-1d09-11ec-9616-0242ac1a000a");
    }
}
