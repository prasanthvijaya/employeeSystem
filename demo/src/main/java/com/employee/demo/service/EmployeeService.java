package com.employee.demo.service;

import com.employee.demo.entity.Employee;
import com.employee.demo.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public  Employee getEmployeeById(Long empId){
        return employeeRepository.findById(empId)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with id " + empId));
    }
}
