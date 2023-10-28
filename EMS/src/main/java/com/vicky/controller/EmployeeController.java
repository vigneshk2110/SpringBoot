package com.vicky.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vicky.dto.EmployeeDto;
import com.vicky.service.EmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
//	Build POST Employee REST API
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED );
		
	}
	
//	Build GET Employee REST API
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
		EmployeeDto employeeDto = employeeService.getEmployeebyId(employeeId);
		
		return ResponseEntity.ok(employeeDto);
	}
	
//	Build GET ALL Employees REST API
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> employees = employeeService.getAllEmployees();		
		return ResponseEntity.ok(employees);		
	}
	
//	Build UPDATE Employee REST API
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id")  Long employeeId, 
												      @RequestBody EmployeeDto updatedEmployeeDto){
		EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployeeDto);
		return ResponseEntity.ok(employeeDto);
		
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeID){
		employeeService.deleteEmployee(employeeID);
		return ResponseEntity.ok("Employee Deleted Successfully");
	}
	
	@PatchMapping("{id}")
	public ResponseEntity<EmployeeDto> partialUpdate( @PathVariable("id")  Long employeeID,
										@RequestBody	Map<String, String> fields){
		EmployeeDto employeeDto = employeeService.partialUpdate(employeeID, fields);
		return ResponseEntity.ok(employeeDto);
	}
	
	
}
