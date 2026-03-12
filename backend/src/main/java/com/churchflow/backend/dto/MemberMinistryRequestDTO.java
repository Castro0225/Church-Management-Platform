package com.churchflow.backend.dto;

import com.churchflow.backend.entity.enums.MinistryRole;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class MemberMinistryRequestDTO {

    @NotNull(message = "O id do membro é obrigatório.")
    private Long memberId;

    @NotNull(message = "O id do ministério é obrigatório.")
    private Long ministryId;

    @NotNull(message = "A função no ministério é obrigatória.")
    private MinistryRole role;

    private Boolean active;
    private LocalDate joinedAt;

    public MemberMinistryRequestDTO() {
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getMinistryId() {
        return ministryId;
    }

    public void setMinistryId(Long ministryId) {
        this.ministryId = ministryId;
    }

    public MinistryRole getRole() {
        return role;
    }

    public void setRole(MinistryRole role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDate getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(LocalDate joinedAt) {
        this.joinedAt = joinedAt;
    }
}