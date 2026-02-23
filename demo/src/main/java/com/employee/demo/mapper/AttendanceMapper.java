package com.employee.demo.mapper;

import com.employee.demo.dto.AttendanceDto;
import com.employee.demo.entity.Attendance;
import com.employee.demo.entity.Employee;
import com.employee.demo.entity.Shift;

import com.employee.demo.service.EmployeeService;

public class AttendanceMapper {

    private EmployeeService employeeService;

    public static AttendanceDto toDto(Attendance attendance){
        if(attendance == null) return null;

        AttendanceDto dto = new AttendanceDto();

        dto.setDate(attendance.getDate());
        dto.setStatus(attendance.getStatus());
        dto.setCheckinTime(attendance.getCheckinTime());
        dto.setCheckoutTime(attendance.getCheckoutTime());
        dto.setEmployeeId(attendance.getEmployee().getEmpId());

        return dto;
    }

    public static Attendance toEntity(AttendanceDto dto, Employee employee, Shift shift){
        if(dto == null) return null;

        Attendance attendance = new Attendance();

        attendance.setCheckinTime(dto.getCheckinTime());
        attendance.setCheckoutTime(dto.getCheckoutTime());
        attendance.setDate(dto.getDate());
        attendance.setStatus(dto.getStatus());
        attendance.setEmployee(employee);
        attendance.setShift(shift);

        return  attendance;
    }

    public static Attendance updateEntity(Attendance exsistingAttendance, AttendanceDto dto){
        exsistingAttendance.setStatus("Present");
        exsistingAttendance.setCheckoutTime(dto.getCheckoutTime());

        return exsistingAttendance;
    }
}
