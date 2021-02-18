package net.mekomsolutions.senaite.integration;

import static org.junit.Assert.assertNotNull;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.model.ModelCamelContext;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.reifier.RouteReifier;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.eip.component.entity.Event;
import org.springframework.beans.factory.annotation.Value;


public class TestApplicationPropertiesPresentITest extends BaseCamelContextSensitiveTest {  
    
    @Value("${${bahmni.test.orderType.uuid}")
    private String bahmniTestOrderTypeUuid;
    
    @Value("${db-event.destinations}") 
    private String dbEventDestination;
    
    @Value("${openmrs.username}") 
    private String openmrsUsername;
    
    @Value("${openmrs.password}") 
    private String openmrsPassword;
    
    @Value("${openmrs.baseUrl}") 
    private String openmrsBaseUrl;
    
    @Value("${openmrs.db.host}") 
    private String openmrsDbHost;
    
    @Value("${openmrs.db.port}") 
    private String openmrsDbPort;
    
    @Value("${openmrs.db.name}") 
    private String openmrsDbName;
    
    @Value("${results.encounterType.uuid}") 
    private String resultsEncounterTypeUuid;
    
    @Value("${unknown.encounter.role}") 
    private String unknownEncounterRole;
    
    @Value("${bahmni.test.orderType.uuid}") 
    private String bahmniOestOrderTypeUuid;
    
    @Value("${spring.openmrs-datasource.driverClassName}") 
    private String springOpenmrsDatasourceDriverClassName;
    
    @Value("${spring.openmrs-datasource.jdbcUrl}") 
    private String springOpenmrsDatasourceJdbcUrl;
    
    @Value("${spring.openmrs-datasource.username}") 
    private String springOpenmrsDatasourceUsername;
    
    @Value("${spring.openmrs-datasource.password}") 
    private String springOpenmrsDatasourcePassword;
    
    @Value("${debezium.db.serverId}") 
    private String debeziumDbServerId;
    
    @Value("${debezium.db.serverName}") 
    private String debeziumDbServerName;
    
    @Value("${debezium.db.user}") 
    private String debeziumDbUser;
    
    @Value("${debezium.db.password}") 
    private String debeziumDbPassword;
    
    @Value("${debezium.offsetFilename}") 
    private String debeziumOffsetFilename;
    
    @Value("${debezium.historyFilename}") 
    private String debeziumHistoryFilename;
    
    @Value("${senaite.baseUrl}") 
    private String senaiteBaseUrl;
    
    @Value("${senaite.username}") 
    private String senaiteUsername;
    
    @Value("${senaite.password}") 
    private String senaitePassword;
    
    @Value("${logging.level.root}") 
    private String loggingLevelRoot;
    
    @Value("${openmrs.eip.log.level}") 
    private String openmrsEipLogLevel;
    
    @Value("${logging.level.outbound-lims}") 
    private String loggingLevelOutboundLims;
    
    @Value("${db-event.retry.interval}") 
    private String dbEventRetryInterval;
    
    @Value("${db-event.retry.initial.delay}") 
    private String dbEventRetryInitialDelay;
    
    @Value("${serviceRequest-task-status.update.interval}") 
    private String serviceRequestTaskStatusUpdateInterval;
    
    @Value("${serviceRequest-task-status.update.initial.delay}") 
    private String serviceRequestTaskStatusUpdateInitialDelay;
    
    

    @Test
    public void shouldLoadApplicationProperties() throws Exception {
    	// setup
    	
    	// replay
    	
    	// verify
    	assertNotNull(bahmniTestOrderTypeUuid);
    	assertNotNull(dbEventDestination);
    	assertNotNull(openmrsUsername);
    	assertNotNull(openmrsPassword);
    	assertNotNull(openmrsBaseUrl);
    	assertNotNull(openmrsDbHost);
    	assertNotNull(openmrsDbPort);
    	assertNotNull(openmrsDbName);
    	assertNotNull(resultsEncounterTypeUuid);
    	assertNotNull(unknownEncounterRole);
    	assertNotNull(bahmniOestOrderTypeUuid);
    	assertNotNull(springOpenmrsDatasourceDriverClassName);
    	assertNotNull(springOpenmrsDatasourceJdbcUrl);
    	assertNotNull(springOpenmrsDatasourceUsername);
    	assertNotNull(springOpenmrsDatasourcePassword);
    	assertNotNull(debeziumDbServerId);
    	assertNotNull(debeziumDbServerName);
    	assertNotNull(debeziumDbUser);
    	assertNotNull(debeziumDbPassword);
    	assertNotNull(debeziumOffsetFilename);
    	assertNotNull(debeziumHistoryFilename);
    	assertNotNull(senaiteBaseUrl);
    	assertNotNull(senaiteUsername);
    	assertNotNull(senaitePassword);
    	assertNotNull(loggingLevelRoot);
    	assertNotNull(openmrsEipLogLevel);
    	assertNotNull(loggingLevelOutboundLims);
    	assertNotNull(dbEventRetryInterval);
    	assertNotNull(dbEventRetryInitialDelay);
    	assertNotNull(serviceRequestTaskStatusUpdateInterval);
    	assertNotNull(serviceRequestTaskStatusUpdateInitialDelay);
    	
    	
    }

}