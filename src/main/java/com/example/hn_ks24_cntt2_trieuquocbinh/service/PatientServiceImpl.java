package com.example.hn_ks24_cntt2_trieuquocbinh.service;

import com.example.hn_ks24_cntt2_trieuquocbinh.dto.PatientCreateRequest;
import com.example.hn_ks24_cntt2_trieuquocbinh.dto.PatientPatchRequest;
import com.example.hn_ks24_cntt2_trieuquocbinh.dto.PatientResponse;
import com.example.hn_ks24_cntt2_trieuquocbinh.dto.PatientUpdateRequest;
import com.example.hn_ks24_cntt2_trieuquocbinh.entity.Patient;
import com.example.hn_ks24_cntt2_trieuquocbinh.exception.ResourceNotFoundException;
import com.example.hn_ks24_cntt2_trieuquocbinh.mapper.PatientMapper;
import com.example.hn_ks24_cntt2_trieuquocbinh.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public PatientResponse createPatient(PatientCreateRequest request) {
        Patient patient = PatientMapper.toEntity(request);
        return PatientMapper.toResponse(patientRepository.save(patient));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PatientResponse> getPatients(String keyword, Pageable pageable) {
        Page<Patient> page = (keyword == null || keyword.isBlank())
                ? patientRepository.findAllByDeletedFalse(pageable)
                : patientRepository.searchActive(keyword, pageable);
        return page.map(PatientMapper::toResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public PatientResponse getPatientById(Long id) {
        Patient patient = patientRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy bệnh nhân"));
        return PatientMapper.toResponse(patient);
    }

    @Override
    public PatientResponse updatePatient(Long id, PatientUpdateRequest request) {
        Patient patient = patientRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy bệnh nhân"));
        PatientMapper.updateEntity(patient, request);
        return PatientMapper.toResponse(patientRepository.save(patient));
    }

    @Override
    public PatientResponse patchPatient(Long id, PatientPatchRequest request) {
        Patient patient = patientRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy bệnh nhân"));
        PatientMapper.patchEntity(patient, request);
        return PatientMapper.toResponse(patientRepository.save(patient));
    }

    @Override
    public void deletePatient(Long id) {
        Patient patient = patientRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy bệnh nhân"));
        patient.setDeleted(true);
        patientRepository.save(patient);
    }
}

