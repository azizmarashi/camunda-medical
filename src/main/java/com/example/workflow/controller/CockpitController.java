//package com.example.workflow.controller;
//
//import com.example.workflow.model.MedicalProcessModel;
//import com.example.workflow.service.impl.CockpitServiceImpl;
//import lombok.SneakyThrows;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping("/cockpit")
//public class CockpitController {
//
//    @Autowired
//    private CockpitServiceImpl cockpitServiceImpl;
//
//    @PostMapping(value = "/deploy-bpmn-file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<Void> deployBpmnFile(@RequestParam("bpmnFile") File bpmnFile){
//        cockpitServiceImpl.deployBpmnFileFromFile(bpmnFile);
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping(value = "/deploy-bpmn-multipartFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<Void> deployBpmnMultipartFile(@RequestParam("bpmnFile") MultipartFile multipartFile){
//        cockpitServiceImpl.deployBpmnFileFromMultipartFile(multipartFile);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/deployed-process")
//    public ResponseEntity<List<String>> deployedProcess() {
//        return ResponseEntity.ok(cockpitServiceImpl.deployedProcesses());
//    }
//
//    @PostMapping("/start-process/{processName}")
//    public ResponseEntity<Void> startProcess(@RequestBody MedicalProcessModel model, @PathVariable String processName) {
//        cockpitServiceImpl.startProcessInstance(model, processName);
//        return ResponseEntity.ok().build();
//    }
//
//
//    @DeleteMapping("/delete-process/{definitionKey}")
//    public ResponseEntity<Void> deleteProcess(@PathVariable String definitionKey) {
//        cockpitServiceImpl.deleteProcess(definitionKey);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/get-bpmn/{processInstanceId}")
//    public ResponseEntity<String> getModel(@PathVariable String processInstanceId){
//        return ResponseEntity.ok(cockpitServiceImpl.getBpmnModel(processInstanceId));
//    }
//
//}