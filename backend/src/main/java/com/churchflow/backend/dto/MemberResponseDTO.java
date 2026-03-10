package com.churchflow.backend.dto;

import com.churchflow.backend.entity.enums.MemberStatus;

import java.time.LocalDate;
import java.util.List;

public class MemberResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private Boolean baptized;
    private LocalDate memberSince;
    private MemberStatus status;
    private List<MinistrySimpleDTO> ministries;

    public MemberResponseDTO() {
    }

    public MemberResponseDTO(Long id, String name, String email, String phone,
                             LocalDate birthDate, Boolean baptized,
                             LocalDate memberSince, MemberStatus status,
                             List<MinistrySimpleDTO> ministries) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.baptized = baptized;
        this.memberSince = memberSince;
        this.status = status;
        this.ministries = ministries;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Boolean getBaptized() {
        return baptized;
    }

    public LocalDate getMemberSince() {
        return memberSince;
    }

    public MemberStatus getStatus() {
        return status;
    }

    public List<MinistrySimpleDTO> getMinistries() {
        return ministries;
    }
}