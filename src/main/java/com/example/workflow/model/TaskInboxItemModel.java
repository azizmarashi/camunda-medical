package com.example.workflow.model;

import lombok.*;
import java.util.Map;

@Getter
@Setter
public class TaskInboxItemModel {

    private final String processInstanceId;
    private final String taskId;
    private final String taskName;
    private final MedicalProcessModel medicalProcessModel;

    public TaskInboxItemModel(String processInstanceId, String taskId, String taskName, Map<String, Object> values) {
        this.processInstanceId = processInstanceId;
        this.taskId = taskId;
        this.taskName = taskName;
        this.medicalProcessModel = MedicalProcessModel.fromMap(values);
    }

}