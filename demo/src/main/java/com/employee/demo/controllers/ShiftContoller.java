package com.employee.demo.controllers;

import com.employee.demo.dto.EmployeeDto;
import com.employee.demo.dto.ShiftDto;
import com.employee.demo.entity.Employee;
import com.employee.demo.entity.Shift;
import com.employee.demo.mapper.EmployeeMapper;
import com.employee.demo.mapper.ShiftMapper;
import com.employee.demo.repository.EmployeeRepository;
import com.employee.demo.repository.ShiftRepository;
import com.employee.demo.service.EmployeeService;
import com.employee.demo.service.ShiftService;
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
public class ShiftContoller {
    private ShiftRepository shiftRepository;
    private ShiftService shiftService;

    @PostMapping("shift")
    public ResponseEntity<?> createNewEmployee(@Valid @RequestBody ShiftDto shiftDto) {
        Shift shift = ShiftMapper.toEntity(shiftDto);
        shiftService.addShift(shift);

        return ResponseEntity.status(HttpStatus.CREATED).body(shift);
    }
}
