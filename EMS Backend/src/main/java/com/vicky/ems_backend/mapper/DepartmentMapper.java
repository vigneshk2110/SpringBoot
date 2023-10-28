package com.vicky.ems_backend.mapper;

import com.vicky.ems_backend.dto.DepartmentDto;
import com.vicky.ems_backend.entity.DepartMents;

public class DepartmentMapper {

    public static DepartmentDto mapToDepartmentDto(DepartMents departMents){
            return  new DepartmentDto(
            departMents.getId(),
            departMents.getDepartmentName(),
            departMents.getDepartmentEmail()
            );
    }

    public static DepartMents mapToDepartMent(DepartmentDto departmentDto){
            return new DepartMents(
            departmentDto.getId(),
            departmentDto.getDepartmentName(),
            departmentDto.getDepartmentEmail()
            );
    }

}
