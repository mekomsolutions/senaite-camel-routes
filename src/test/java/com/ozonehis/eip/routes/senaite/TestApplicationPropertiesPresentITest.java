package com.ozonehis.eip.routes.senaite;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.openmrs.eip.mysql.watcher.route.BaseWatcherRouteTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;

@Import({ TestConfiguration.class})
public class TestApplicationPropertiesPresentITest extends BaseWatcherRouteTest {  
    
    @Value("${${bahmni.test.orderType.uuid}")
    private String bahmniTestOrderTypeUuid;
    
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
    
    @Test
    public void shouldLoadApplicationProperties() throws Exception {
    	// setup
    	
    	// replay
    	
    	// verify
    	assertNotNull(bahmniTestOrderTypeUuid);
    	assertNotNull(openmrsUsername);
    	assertNotNull(openmrsPassword);
    	assertNotNull(openmrsBaseUrl);
    	assertNotNull(openmrsDbHost);
    	assertNotNull(openmrsDbPort);
    	assertNotNull(openmrsDbName);
    	assertNotNull(resultsEncounterTypeUuid);
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
    	
    }

}
