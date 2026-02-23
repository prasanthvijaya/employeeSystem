package com.employee.demo.repository;

import com.employee.demo.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepositoty extends JpaRepository<Attendance , Long> {

    Optional<Attendance> findByEmployeeEmpIdAndDate(Long empId, LocalDate date);

    List<Attendance> findByDate(LocalDate date);

}
