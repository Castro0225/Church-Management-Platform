package com.churchflow.backend.dto;

import com.churchflow.backend.entity.enums.MemberStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class MemberRequestDTO {

    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    private String name;

    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "Email inválido.")
    private String email;

    @NotBlank(message = "O telefone é obrigatório.")
    @Size(min = 8, max = 20, message = "O telefone deve ter entre 8 e 20 caracteres.")
    private String phone;

    @NotNull(message = "A data de nascimento é obrigatória.")
    @Past(message = "A data de nascimento deve ser uma data passada.")
    private LocalDate birthDate;

    @NotNull(message = "O campo batizado é obrigatório.")
    private Boolean baptized;

    @NotNull(message = "A data de entrada como membro é obrigatória.")
    private LocalDate memberSince;

    @NotNull(message = "O status é obrigatório.")
    private MemberStatus status;

    public MemberRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getBaptized() {
        return baptized;
    }

    public void setBaptized(Boolean baptized) {
        this.baptized = baptized;
    }

    public LocalDate getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(LocalDate memberSince) {
        this.memberSince = memberSince;
    }

    public MemberStatus getStatus() {
        return status;
    }

    public void setStatus(MemberStatus status) {
        this.status = status;
    }
}