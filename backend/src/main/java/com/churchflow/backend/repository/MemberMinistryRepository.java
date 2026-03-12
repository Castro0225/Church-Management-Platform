package com.churchflow.backend.repository;

import com.churchflow.backend.entity.MemberMinistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMinistryRepository extends JpaRepository<MemberMinistry, Long> {
}