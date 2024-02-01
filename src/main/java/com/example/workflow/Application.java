package com.example.workflow;

import lombok.SneakyThrows;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.instance.Lane;
import org.camunda.bpm.model.bpmn.instance.Task;
import org.camunda.bpm.model.bpmn.instance.UserTask;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application {

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }


  @SneakyThrows
  @Bean
  CommandLineRunner run(RepositoryService repositoryService){
    return args -> {


      List<String> rolesCode = repositoryService.getBpmnModelInstance("medical-in-mili:1:503")
              .getModelElementsByType(UserTask.class)
              .stream()
              .map(UserTask::getCamundaCandidateGroups)
              .collect(Collectors.toList());
      System.out.println(rolesCode);

      BpmnModelInstance modelInstance = repositoryService.getBpmnModelInstance("medical-in-mili:1:503");
      Collection<Lane> lanes = modelInstance.getModelElementsByType(Lane.class);
      List<String> rolesTitle = lanes.stream().map(Lane::getName).collect(Collectors.toList());
      System.out.println(rolesTitle);


    };

  }

}