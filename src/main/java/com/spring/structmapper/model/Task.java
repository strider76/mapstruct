package com.spring.structmapper.model;

import lombok.Data;

@Data
public class Task {

    private Long id;
    private String name;
    private String details;
    private Boolean active;

}
