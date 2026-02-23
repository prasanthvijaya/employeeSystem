package com.employee.demo.mapper;

import com.employee.demo.dto.EmployeeDto;
import com.employee.demo.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto toDTO(Employee employee) {
        if (employee == null) return null;

        EmployeeDto dto = new EmployeeDto();
        dto.setEmpId(employee.getEmpId());
        dto.setStaffCode(employee.getStaffCode());
        dto.setName(employee.getName());
        dto.setDob(employee.getDob());
        dto.setAddress(employee.getAddress());
        dto.setRoll(employee.getRoll());
        dto.setPassWord(employee.getPassWord());

        return dto;
    }

    public static Employee toEntity(EmployeeDto dto) {
        if (dto == null) return null;

        Employee employee = new Employee();
        employee.setStaffCode(dto.getStaffCode());
        employee.setName(dto.getName());
        employee.setDob(dto.getDob());
        employee.setAddress(dto.getAddress());
        employee.setRoll(dto.getRoll());
        employee.setPassWord(dto.getPassWord());
        return employee;
    }

    public static void updateEntity(Employee existingEmployee, EmployeeDto dto) {
        existingEmployee.setStaffCode(dto.getStaffCode());
        existingEmployee.setName(dto.getName());
        existingEmployee.setDob(dto.getDob());
        existingEmployee.setRoll(dto.getRoll());
        existingEmployee.setAddress(dto.getAddress());
        existingEmployee.setPassWord(dto.getPassWord());
    }

}
