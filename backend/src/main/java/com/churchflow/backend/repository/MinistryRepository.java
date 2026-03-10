package com.churchflow.backend.repository;

import com.churchflow.backend.entity.Ministry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinistryRepository extends JpaRepository<Ministry, Long> {

    boolean existsByName(String name);
}