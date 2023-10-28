package com.vicky.service.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.vicky.dto.EmployeeDto;
import com.vicky.entity.Employee;
import com.vicky.exception.ResourceNotFoundException;
import com.vicky.mapper.EmployeeMapper;
import com.vicky.repository.EmployeeRepository;
import com.vicky.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		// TODO Auto-generated method stub
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeebyId(Long employeeId) {
		Employee employee =	employeeRepository.findById(employeeId).
		orElseThrow(() -> new ResourceNotFoundException("Employee not found with this ID:" + employeeId));
		
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employeeList =	employeeRepository.findAll();
		List<EmployeeDto> employeeDtos = employeeList.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
		return employeeDtos;
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployeeDto) {
		Employee employee =	employeeRepository.findById(employeeId).
				orElseThrow(() -> new ResourceNotFoundException("Employee not found with this ID:" + employeeId));
		employee.setFirstName(updatedEmployeeDto.getFirstName());
		employee.setLastName(updatedEmployeeDto.getLastName());
		employee.setEmail(updatedEmployeeDto.getEmail());
		employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee =	employeeRepository.findById(employeeId).
				orElseThrow(() -> new ResourceNotFoundException("Employee not found with this ID:" + employeeId));
		employeeRepository.delete(employee);
	}

	@Override
	public EmployeeDto partialUpdate(Long employeeId, Map<String, String> fields) {
		Employee employee =	employeeRepository.findById(employeeId).
				orElseThrow(() -> new ResourceNotFoundException("Employee not found with this ID:" + employeeId));
		
		fields.forEach((key,value)->{
		Field field =ReflectionUtils.findField(Employee.class, key);
		assert field != null;
		field.setAccessible(true);
		ReflectionUtils.setField(field, employee, value);
		});
		employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

}
