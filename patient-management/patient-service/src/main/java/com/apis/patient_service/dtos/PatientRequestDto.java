package com.apis.patient_service.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
@Data
public class PatientRequestDto {
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Can not exceed 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Address is required")
    private String address;

    private LocalDate dateOfBirth;

    private LocalDate registeredDate;


}
