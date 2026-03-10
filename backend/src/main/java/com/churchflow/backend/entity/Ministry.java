package com.churchflow.backend.entity;

import com.churchflow.backend.entity.enums.MinistryStatus;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ministries")
public class Ministry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    private String leaderName;

    @Enumerated(EnumType.STRING)
    private MinistryStatus status;

    @ManyToMany(mappedBy = "ministries")
    private Set<Member> members = new HashSet<>();

    public Ministry() {
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

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }
}