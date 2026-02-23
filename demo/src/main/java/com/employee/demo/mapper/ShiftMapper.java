package com.employee.demo.mapper;

import com.employee.demo.dto.EmployeeDto;
import com.employee.demo.dto.ShiftDto;
import com.employee.demo.entity.Employee;
import com.employee.demo.entity.Shift;

public class ShiftMapper {

    public static Shift toEntity(ShiftDto dto){
     if(dto == null) return null;

     Shift shiftObj = new Shift();
     shiftObj.setName(dto.getName());
     shiftObj.setShiftCheckoutTime(dto.getShiftCheckoutTime());
     shiftObj.setShiftCheckinTime(dto.getShiftCheckinTime());

     return shiftObj;
    }

    public static ShiftDto toDto(Shift shiftObj){
        if(shiftObj == null) return null;

        ShiftDto dto = new ShiftDto();
        dto.setName(shiftObj.getName());
        dto.setShiftCheckinTime(shiftObj.getShiftCheckinTime());
        dto.setShiftCheckoutTime(shiftObj.getShiftCheckoutTime());

        return dto;
    }

    public static void updateEntity(Shift existingShift, ShiftDto dto) {
        existingShift.setName(dto.getName());
        existingShift.setShiftCheckinTime(dto.getShiftCheckinTime());
        existingShift.setShiftCheckoutTime(dto.getShiftCheckoutTime());
    }
}
