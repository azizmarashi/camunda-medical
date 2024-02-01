package com.example.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagingSorting {

    private int firstResult;
    private int maxResult;
    private int pageSize;
    private boolean ascending;
    private String sortProperty;
}