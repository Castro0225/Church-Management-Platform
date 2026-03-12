package com.churchflow.backend.entity;

import com.churchflow.backend.entity.enums.MinistryRole;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "member_ministries")
public class MemberMinistry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ministry_id", nullable = false)
    private Ministry ministry;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MinistryRole role;

    @Column(nullable = false)
    private Boolean active = true;

    private LocalDate joinedAt;

    public MemberMinistry() {
    }

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Ministry getMinistry() {
        return ministry;
    }

    public void setMinistry(Ministry ministry) {
        this.ministry = ministry;
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