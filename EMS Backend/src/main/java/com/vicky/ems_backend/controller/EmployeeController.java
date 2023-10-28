package com.vicky.ems_backend.controller;


import com.vicky.ems_backend.dto.EmployeeDto;
import com.vicky.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

//    Build POST Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //    Build GET Employee REST API
    @GetMapping("{id}")
    public  ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeID){
        EmployeeDto employeeDto = employeeService.getEmployeebyId(employeeID);
        return ResponseEntity.ok(employeeDto);
    }


    //    Build GET ALL Employee REST API
    @GetMapping
    public  ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //    Build UPDATE / PUT ALL Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                     @RequestBody EmployeeDto updatedEmployeeDto){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployeeDto);
        return ResponseEntity.ok(employeeDto);
    }

//    Build DELETE Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Deleted Successfully");
    }

//    Build PATCH Employee REST API
@PatchMapping("{id}")
    public ResponseEntity<EmployeeDto> partialUpdate(@PathVariable("id") Long employeeID,
                                                    @RequestBody Map<String, String> fields){
        EmployeeDto employeeDto = employeeService.partialUpdate(employeeID,fields);
        return ResponseEntity.ok(employeeDto);
    }


}
