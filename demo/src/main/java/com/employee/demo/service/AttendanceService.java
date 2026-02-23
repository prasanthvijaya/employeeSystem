package com.employee.demo.service;

import com.employee.demo.dto.AttendanceDto;
import com.employee.demo.entity.Attendance;
import com.employee.demo.exceptions.ResourceNotFoundException;
import com.employee.demo.repository.AttendanceRepositoty;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class AttendanceService {

    private final AttendanceRepositoty repo;

    public void addAttendance(Attendance newAttendance){
        repo.save(newAttendance);
    }

    public Attendance getAttendanceById(Long attendanceId){
        return repo.findById(attendanceId)
                .orElseThrow(() ->
                        new RuntimeException("Attendance not found with id " + attendanceId));
    }

    public Attendance updateAttendance(Attendance updatedAttendance){
        return repo.save(updatedAttendance) ;
    }

    public Attendance getAttendanceByDateAndId(AttendanceDto dto){

        return repo.findByEmployeeEmpIdAndDate(
                dto.getEmployeeId(),
                dto.getDate()
        ).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Attendance not found for employee id "
                                + dto.getEmployeeId()
                                + " on date "
                                + dto.getDate()
                )
        );
    }

    public List<Attendance> getAttendanceByDate(LocalDate date) {

        List<Attendance> list = repo.findByDate(date);

        if (list.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No attendance found for date " + date
            );
        }

        return list;
    }
}
