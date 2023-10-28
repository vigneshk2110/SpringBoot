package com.vicky.ems_backend.service;


import com.vicky.ems_backend.dto.DepartmentDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public interface DepartMentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByID(Long deptId);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto updateDepartMent(Long deptId, DepartmentDto departmentDto);

    void deleteDepartment(Long deptId);

    DepartmentDto partialUpdate(Long deptId, Map<String, String> fileds);
}
