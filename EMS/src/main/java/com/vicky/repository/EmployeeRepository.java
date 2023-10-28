package com.vicky.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vicky.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
