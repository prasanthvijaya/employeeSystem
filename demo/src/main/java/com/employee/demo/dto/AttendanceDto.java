package com.employee.demo.dto;

import com.employee.demo.entity.Employee;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Getter
@Setter
public class AttendanceDto {
    @Valid
    private Long id;

    @NotNull(message = "Date must be given")
    private LocalDate date;

    private LocalTime checkinTime;
    private LocalTime checkoutTime;

    private String status;

    @NotNull(message = "Employee id must be given")
    private Long employeeId;

    @NotNull(message = "Shift id must be given")
    private Long shiftId;
}
