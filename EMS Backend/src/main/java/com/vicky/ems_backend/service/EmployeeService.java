package com.vicky.ems_backend.service;

import com.vicky.ems_backend.dto.EmployeeDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeebyId(Long employeeID);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeID, EmployeeDto updatedEmployeeDto);

    void deleteEmployee(Long employeeID);

    EmployeeDto partialUpdate(Long employeeID, Map<String,String> fields);
}
