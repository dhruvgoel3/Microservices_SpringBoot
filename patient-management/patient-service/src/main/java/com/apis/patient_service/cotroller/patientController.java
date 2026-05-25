package com.apis.patient_service.cotroller;

import com.apis.patient_service.dtos.PatientRequestDto;
import com.apis.patient_service.dtos.PatientResponseDto;
import com.apis.patient_service.service.PatientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class patientController {
    private final PatientService patientService;

    @GetMapping("/getPatients")
    public ResponseEntity<List<PatientResponseDto>> getPatients() {
        List<PatientResponseDto> patients = patientService.getPatients();
        return ResponseEntity.ok(patients);
    }

    @PostMapping
    public ResponseEntity<PatientResponseDto> createPatient(@Valid @RequestBody PatientRequestDto patientRequestDto)
    {
        return ResponseEntity.ok(patientService.createPatient(patientRequestDto));

    }


}
