package com.apis.patient_service.mapper;

import com.apis.patient_service.dtos.PatientRequestDto;
import com.apis.patient_service.dtos.PatientResponseDto;
import com.apis.patient_service.model.Patient;
import com.apis.patient_service.service.PatientService;

public class PatientMapper {
    public static PatientResponseDto toDto(Patient patient) {
        PatientResponseDto patientDto = new PatientResponseDto();
        patientDto.setId(patient.getId().toString());
        patientDto.setName(patient.getName());
        patientDto.setAddress(patient.getAddress());
        patientDto.setEmail(patient.getEmail());
        patientDto.setDateOfBirth(patient.getDateOfBirth().toString());
        return patientDto;
    }

    public static Patient toModel(PatientRequestDto patientRequestDto) {
        Patient patient = new Patient();
        patient.setName(patientRequestDto.getName());
        patient.setAddress(patientRequestDto.getAddress());
        patient.setEmail(patientRequestDto.getEmail());
        patient.setDateOfBirth(patientRequestDto.getDateOfBirth());
        patient.setDateOfBirth(patientRequestDto.getDateOfBirth());
        patient.setRegisteredDate(patientRequestDto.getRegisteredDate());
        return patient;
    }

}
