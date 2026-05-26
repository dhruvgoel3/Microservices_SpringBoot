package com.apis.patient_service.service;

import com.apis.patient_service.dtos.PatientRequestDto;
import com.apis.patient_service.exceptions.EmailAlreadyExistsException;
import com.apis.patient_service.exceptions.PatientNotFoundException;
import com.apis.patient_service.mapper.PatientMapper;
import com.apis.patient_service.model.Patient;
import com.apis.patient_service.dtos.PatientResponseDto;
import com.apis.patient_service.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
        if (patientRepository.existsByEmail(patientRequestDto.getEmail())) {
            throw new EmailAlreadyExistsException("A patient with this mail " + "already exists " + patientRequestDto.getEmail());
        }
        Patient patient = patientRepository.save(PatientMapper.toModel(patientRequestDto));
        return PatientMapper.toDto(patient);
    }

    public PatientResponseDto updatePatient(UUID id , PatientRequestDto patientRequestDto)
    {
       Patient patient =  patientRepository.findById(id).orElseThrow(()-> new PatientNotFoundException("Patient not found with Id: " + id));
       if(patientRepository.existsByEmail(patientRequestDto.getEmail()))
       {
           throw new EmailAlreadyExistsException(
                   "A patient with this email " + " already exists" + patientRequestDto.getEmail());
       }

       patient.setName(patientRequestDto.getName());
       patient.setAddress(patientRequestDto.getAddress());
       patient.setEmail(patientRequestDto.getEmail());
       patient.setDateOfBirth(patientRequestDto.getDateOfBirth());

       Patient updatePatient = patientRepository.save(patient);
       return PatientMapper.toDto(updatePatient);
    }
}
