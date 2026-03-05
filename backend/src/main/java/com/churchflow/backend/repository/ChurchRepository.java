package com.churchflow.backend.repository;

import com.churchflow.backend.entity.Church;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChurchRepository extends JpaRepository<Church, Long> {
}