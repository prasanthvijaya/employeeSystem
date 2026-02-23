package com.employee.demo.controllers;

import com.employee.demo.dto.AttendanceDto;
import com.employee.demo.dto.EmployeeDto;
import com.employee.demo.entity.Attendance;
import com.employee.demo.entity.Employee;
import com.employee.demo.entity.Shift;
import com.employee.demo.exceptions.ResourceNotFoundException;
import com.employee.demo.mapper.AttendanceMapper;
import com.employee.demo.mapper.EmployeeMapper;
import com.employee.demo.repository.AttendanceRepositoty;
import com.employee.demo.repository.EmployeeRepository;
import com.employee.demo.service.AttendanceService;
import com.employee.demo.service.EmployeeService;
import com.employee.demo.service.ShiftService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employeeSystem")
public class AttendanceController {

    private EmployeeService employeeService;
    private ShiftService shiftService;
    private AttendanceRepositoty attendanceRepositoty;
    private AttendanceService attendanceService;

    @PostMapping("attendance")
    public ResponseEntity<?> addAttendance(@Valid @RequestBody AttendanceDto attendanceDto) {
        Employee emp = employeeService.getEmployeeById(attendanceDto.getEmployeeId());
        Shift shift = shiftService.getShiftById(attendanceDto.getShiftId());

        Attendance newAttendance = AttendanceMapper.toEntity(attendanceDto, emp, shift);

        attendanceService.addAttendance(newAttendance);

        return ResponseEntity.status(HttpStatus.CREATED).body(newAttendance);
    }

    @PutMapping("attendance/{employeeId}")
    public ResponseEntity<?> updateAttendance(@Valid @PathVariable Long employeeId,  @RequestBody AttendanceDto attendanceDto){
        Attendance exsistingAttendance =  attendanceService.getAttendanceByDateAndId(attendanceDto);
        Employee emp = employeeService.getEmployeeById(employeeId);

        Attendance updatedAttendance = AttendanceMapper.updateEntity(exsistingAttendance, attendanceDto);
        attendanceService.updateAttendance(updatedAttendance);

        return ResponseEntity.status(HttpStatus.CREATED).body(updatedAttendance);
    }

    @GetMapping("attendanceByDate")
    public ResponseEntity<?> getAttendanceByDate(@Valid @RequestParam LocalDate date){
        List<Attendance> attendanceesFound =  attendanceService.getAttendanceByDate(date);

        return ResponseEntity.status(HttpStatus.CREATED).body(attendanceesFound);
    }

    @GetMapping("attendanceByEmployee")
    public ResponseEntity<?> attendanceByEmployee(@Valid @RequestParam Long empId){
        Attendance attendanceesFound =  attendanceService.getAttendanceById(empId);

        return ResponseEntity.status(HttpStatus.CREATED).body(attendanceesFound);
    }

}
