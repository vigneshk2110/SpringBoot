package com.vicky.ems_backend.repository;

import com.vicky.ems_backend.entity.DepartMents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartMentRepository extends JpaRepository<DepartMents, Long>{
}