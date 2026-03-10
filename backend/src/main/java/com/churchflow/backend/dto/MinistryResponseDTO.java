package com.churchflow.backend.dto;

import com.churchflow.backend.entity.enums.MinistryStatus;

public class MinistryResponseDTO {

    private Long id;
    private String name;
    private String description;
    private String leaderName;
    private MinistryStatus status;

    public MinistryResponseDTO() {
    }

    public MinistryResponseDTO(Long id, String name, String description, String leaderName, MinistryStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.leaderName = leaderName;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public MinistryStatus getStatus() {
        return status;
    }
}