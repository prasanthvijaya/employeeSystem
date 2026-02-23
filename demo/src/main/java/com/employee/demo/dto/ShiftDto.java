package com.employee.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalTime;

@Data
@Getter
@Setter
public class ShiftDto {

    @Valid

    private Long shiftId;

    @NotBlank(message = "shift name must be given")
    private String name;

    @NotNull(message = "Shift Check-in-time must be given")
    private LocalTime shiftCheckinTime;

    @NotNull(message = "Shift Check-out-time must be given")
    private LocalTime shiftCheckoutTime;
}
