package com.employee.demo.service;

import com.employee.demo.entity.Shift;
import com.employee.demo.repository.ShiftRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShiftService {
    private final ShiftRepository repo;

    public void addShift(Shift newShift){
        repo.save(newShift);
    }

    public Shift getShiftById(Long shiftId){
        return repo.findById(shiftId)
                .orElseThrow(() ->
                        new RuntimeException("Shift not found with id " + shiftId));
    }
}
