package com.vicky.ems_backend.controller;


import com.vicky.ems_backend.dto.DepartmentDto;
import com.vicky.ems_backend.service.DepartMentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")

public class DepartMentController {

    private DepartMentService departMentService;


    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartMent(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartMentDTO = departMentService.createDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartMentDTO, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentByID(@PathVariable("id") Long deptId){
        DepartmentDto departmentDTO = departMentService.getDepartmentByID(deptId);
        return ResponseEntity.ok(departmentDTO);
    }


    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        List<DepartmentDto> departmentDtoList = departMentService.getAllDepartments();
        return ResponseEntity.ok(departmentDtoList);
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> putDepartment(@PathVariable("id") Long deptId,
                                                       @RequestBody DepartmentDto departmentDto){
        DepartmentDto updatedDepartmentDto = departMentService.updateDepartMent(deptId,departmentDto);
        return ResponseEntity.ok(updatedDepartmentDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartMent(@PathVariable("id") Long deptId){
       departMentService.deleteDepartment(deptId);
        return ResponseEntity.ok("DepartMent deleted Successfully");
    }


    @PatchMapping("{id}")
    public ResponseEntity<DepartmentDto> partialUpdate(@PathVariable("id") Long deptId,
                                                       @RequestBody Map<String, String> fields){
    DepartmentDto departmentDto = departMentService.partialUpdate(deptId,fields);
        return ResponseEntity.ok(departmentDto);
    }
}
