package com.employee.demo.controllers;

import com.employee.demo.dto.EmployeeDto;
import com.employee.demo.entity.Employee;
import com.employee.demo.mapper.EmployeeMapper;
import com.employee.demo.repository.EmployeeRepository;
import com.employee.demo.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employeeSystem")
public class EmployeeController {

    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;

    @PostMapping("employee")
    public ResponseEntity<?> createNewEmployee(@Valid @RequestBody EmployeeDto empDto) {
        Employee employee = EmployeeMapper.toEntity(empDto);
        employeeService.saveEmployee(employee);

        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }
}
