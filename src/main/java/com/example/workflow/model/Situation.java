package com.example.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Situation {
    ExemptionFromWar("ExemptionFromWar"),
    TemporaryExemption("TemporaryExemption"),
    PermanentExemption("PermanentExemption"),
    ChangeToHealthy("ChangeToHealthy");

    private final String value;
}