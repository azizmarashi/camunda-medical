package com.example.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.ReflectionUtils;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicalProcessModel {

    private String folderRequestNumber;
    private boolean haveConflict;
    private boolean less6MonthsService;
    private Situation situation;
    private long countOfExemption;
    private String soldierNationalNumber;

    public static MedicalProcessModel fromMap(Map<String, Object> map) {
        MedicalProcessModel result = new MedicalProcessModel();
        ReflectionUtils.doWithFields(MedicalProcessModel.class, field -> field.set(result, map.get(field.getName())));
        return result;
    }

    public Map<String, Object> createMap() {
        Map<String, Object> result = new HashMap<>();
        ReflectionUtils.doWithFields(MedicalProcessModel.class, field -> result.put(field.getName(), field.get(this)));
        return result;
    }

}