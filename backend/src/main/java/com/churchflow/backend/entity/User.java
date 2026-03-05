package com.churchflow.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    // Aceita no POST/PUT, mas NÃO aparece no GET/response
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    // Evita loop (User -> Church -> Users -> ...)
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "church_id")
    private Church church;

    public User() {
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

    // Pode manter: mesmo com getter, não vai sair no JSON por causa do WRITE_ONLY
    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public Church getChurch() {
        return church;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setChurch(Church church) {
        this.church = church;
    }
}