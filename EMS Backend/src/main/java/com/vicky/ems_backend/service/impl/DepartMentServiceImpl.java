package com.vicky.ems_backend.service.impl;

import com.vicky.ems_backend.dto.DepartmentDto;
import com.vicky.ems_backend.entity.DepartMents;
import com.vicky.ems_backend.exception.ResourceNotFoundException;
import com.vicky.ems_backend.mapper.DepartmentMapper;
import com.vicky.ems_backend.repository.DepartMentRepository;
import com.vicky.ems_backend.service.DepartMentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class DepartMentServiceImpl implements DepartMentService {

    private DepartMentRepository departMentRepository;
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        DepartMents departMents = DepartmentMapper.mapToDepartMent(departmentDto);
        DepartMents savedDepartMents = departMentRepository.save(departMents);
        return DepartmentMapper.mapToDepartmentDto(savedDepartMents);
    }

    @Override
    public DepartmentDto getDepartmentByID(Long deptId) {
        DepartMents departMents = departMentRepository.findById(deptId).
                orElseThrow(()->new ResourceNotFoundException("Department not found with ID: " + deptId));

        return DepartmentMapper.mapToDepartmentDto(departMents);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<DepartMents> deptList = departMentRepository.findAll();
        return deptList.stream().map(DepartmentMapper::mapToDepartmentDto).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartMent(Long deptId, DepartmentDto departmentDto) {
        DepartMents departMents = departMentRepository.findById(deptId).
                orElseThrow(()->new ResourceNotFoundException("Department not found with ID: " + deptId));
        departMents.setDepartmentName(departmentDto.getDepartmentName());
        departMents.setDepartmentEmail(departmentDto.getDepartmentEmail());
        departMentRepository.save(departMents);
        return DepartmentMapper.mapToDepartmentDto(departMents);
    }

    @Override
    public void deleteDepartment(Long deptId) {
       departMentRepository.deleteById(deptId);
    }

    @Override
    public DepartmentDto partialUpdate(Long deptId, Map<String, String> fileds) {
        DepartMents departMents = departMentRepository.findById(deptId).
                orElseThrow(()->new ResourceNotFoundException("Department not found with ID: " + deptId));
        fileds.forEach((key,value)->{
            Field field = ReflectionUtils.findField(DepartMents.class, key);
            assert field != null;
            field.setAccessible(true);
          ReflectionUtils.setField(field,departMents,value);
        });
        departMentRepository.save(departMents);
        return DepartmentMapper.mapToDepartmentDto(departMents);
    }
}

