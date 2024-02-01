package com.example.workflow.config;

import com.example.workflow.Application;
import lombok.SneakyThrows;
import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class MyCamundaConfig {

    @Value("${myCamunda.dataSource.username}")
    private String camundaDataSourceUsername;

    @Value("${myCamunda.dataSource.password}")
    private String camundaDataSourcePassword;

    @Value("${myCamunda.dataSource.url}")
    private String camundaDataSourceUrl;

    @Value("${myCamunda.dataSource.driverClassName}")
    private String camundaDriverClassName;

    @SneakyThrows
    private Resource[] bpmnResource(){
        String bpmnFilesFolder = "file:src/main/java/com/example/workflow/myBPMN/*.bpmn";
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        return  resourcePatternResolver.getResources(bpmnFilesFolder);
    }

    private DataSource camundaDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.username(camundaDataSourceUsername);
        dataSourceBuilder.password(camundaDataSourcePassword);
        dataSourceBuilder.url(camundaDataSourceUrl);
        dataSourceBuilder.driverClassName(camundaDriverClassName);
        return dataSourceBuilder.build();
    }

    @Bean
    public PlatformTransactionManager bpmsTransactionManager() {
        return new DataSourceTransactionManager(camundaDataSource());
    }

    @Bean
    public SpringProcessEngineConfiguration processEngineConfiguration() {
        SpringProcessEngineConfiguration config = new SpringProcessEngineConfiguration();
        config.setDataSource(camundaDataSource());
        config.setDatabaseSchemaUpdate("true");
        config.setTransactionManager(bpmsTransactionManager());
        config.setJobExecutorActivate(false);
        config.setDeploymentResources(bpmnResource());

        return config;
    }

}
