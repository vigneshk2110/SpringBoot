package com.vicky.service;

import java.util.List;
import java.util.Map;

import com.vicky.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeebyId(Long employeeId);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployeeDto);	  
	
	void deleteEmployee(Long employeeId);

	EmployeeDto partialUpdate(Long employeeID, Map<String, String> fields);
	  

}
