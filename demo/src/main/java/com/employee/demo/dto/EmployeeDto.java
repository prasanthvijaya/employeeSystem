package com.employee.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class EmployeeDto {

    @Valid

    private Long empId;

    @NotBlank(message = "Staff code must be given")
    private String staffCode;

    @NotBlank(message = "Employee name must be given")
    private String name;

    @NotNull(message = "Date of birth must be given")
    private LocalDate dob;

    @NotBlank(message = "Address must be given")
    private String address;

    @NotBlank(message = "Employee Roll must be given")
    private String roll;

    @NotBlank(message = "Password must be given")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*()_+=<>?{}\\[\\]~-])(?=.{8,}).*$",
            message = "Password must be at least 8 characters, contain at least one number and one special character"
    )
    private String passWord;
}
