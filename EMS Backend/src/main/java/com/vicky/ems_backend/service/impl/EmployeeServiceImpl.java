package com.vicky.ems_backend.service.impl;

import com.vicky.ems_backend.dto.EmployeeDto;
import com.vicky.ems_backend.entity.Employee;
import com.vicky.ems_backend.exception.ResourceNotFoundException;
import com.vicky.ems_backend.mapper.EmployeeMapper;
import com.vicky.ems_backend.repository.EmployeeRepository;
import com.vicky.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeebyId(Long employeeID) {
        Employee employee = employeeRepository.findById(employeeID).
                orElseThrow(() -> new ResourceNotFoundException("Employee Not found with employee Id :"+employeeID));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeID, EmployeeDto updatedEmployeeDto) {
        Employee employee = employeeRepository.findById(employeeID).
                orElseThrow(() -> new ResourceNotFoundException("Employee Not found with employee Id :"+employeeID));

        employee.setFirstName(updatedEmployeeDto.getFirstName());
        employee.setLastName(updatedEmployeeDto.getLastName());
        employee.setEmail(updatedEmployeeDto.getEmail());
        employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public void deleteEmployee(Long employeeID) {
        Employee employee = employeeRepository.findById(employeeID).
                orElseThrow(() -> new ResourceNotFoundException("Employee Not found with employee Id :"+employeeID));
        employeeRepository.delete(employee);
    }

    @Override
    public EmployeeDto partialUpdate(Long employeeID, Map<String, String> fields) {
        Employee employee = employeeRepository.findById(employeeID).
                orElseThrow(() -> new ResourceNotFoundException("Employee Not found with employee Id : "+employeeID));

       fields.forEach((key, value)->{
           Field field = ReflectionUtils.findField(Employee.class, key);
           assert field != null;
           field.setAccessible(true);
           ReflectionUtils.setField(field, employee, value);

       });
       employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
