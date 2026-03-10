package com.churchflow.backend.dto;

public class MinistrySimpleDTO {

    private Long id;
    private String name;

    public MinistrySimpleDTO() {
    }

    public MinistrySimpleDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}