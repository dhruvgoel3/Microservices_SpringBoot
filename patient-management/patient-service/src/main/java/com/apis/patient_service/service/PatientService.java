package com.apis.patient_service.service;

import com.apis.patient_service.dtos.PatientRequestDto;
import com.apis.patient_service.mapper.PatientMapper;
import com.apis.patient_service.model.Patient;
import com.apis.patient_service.dtos.PatientResponseDto;
import com.apis.patient_service.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public List<PatientResponseDto> getPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponseDto> patientResponseDto = patients.stream()
                .map(PatientMapper::toDto).toList();
        return patientResponseDto;

    }

    public PatientResponseDto createPatient(PatientRequestDto patientRequestDto) {
        Patient patient = patientRepository.save(PatientMapper.toModel(patientRequestDto));
        return PatientMapper.toDto(patient);


    }
}
