package com.churchflow.backend.dto;

import com.churchflow.backend.entity.enums.MinistryStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MinistryRequestDTO {

    @NotBlank(message = "O nome do ministério é obrigatório.")
    @Size(min = 3, max = 100, message = "O nome do ministério deve ter entre 3 e 100 caracteres.")
    private String name;

    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres.")
    private String description;

    @NotBlank(message = "O nome do líder é obrigatório.")
    @Size(min = 3, max = 100, message = "O nome do líder deve ter entre 3 e 100 caracteres.")
    private String leaderName;

    @NotNull(message = "O status é obrigatório.")
    private MinistryStatus status;

    public MinistryRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public MinistryStatus getStatus() {
        return status;
    }

    public void setStatus(MinistryStatus status) {
        this.status = status;
    }
}