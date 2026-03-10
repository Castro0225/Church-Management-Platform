package com.churchflow.backend.entity;

import com.churchflow.backend.entity.enums.MemberStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String phone;

    private LocalDate birthDate;

    private Boolean baptized;

    private LocalDate memberSince;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @ManyToMany
    @JoinTable(
            name = "member_ministries",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "ministry_id")
    )
    private Set<Ministry> ministries = new HashSet<>();

    public Member() {
    }

    public Long getId() {
        return id;
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

    public Set<Ministry> getMinistries() {
        return ministries;
    }

    public void setMinistries(Set<Ministry> ministries) {
        this.ministries = ministries;
    }

    public void addMinistry(Ministry ministry) {
        this.ministries.add(ministry);
    }

    public void removeMinistry(Ministry ministry) {
        this.ministries.remove(ministry);
    }
}