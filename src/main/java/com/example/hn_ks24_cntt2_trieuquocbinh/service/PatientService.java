package com.example.hn_ks24_cntt2_trieuquocbinh.service;

import com.example.hn_ks24_cntt2_trieuquocbinh.dto.PatientCreateRequest;
import com.example.hn_ks24_cntt2_trieuquocbinh.dto.PatientPatchRequest;
import com.example.hn_ks24_cntt2_trieuquocbinh.dto.PatientResponse;
import com.example.hn_ks24_cntt2_trieuquocbinh.dto.PatientUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PatientService {
    PatientResponse createPatient(PatientCreateRequest request);

    Page<PatientResponse> getPatients(String keyword, Pageable pageable);

    PatientResponse getPatientById(Long id);

    PatientResponse updatePatient(Long id, PatientUpdateRequest request);

    PatientResponse patchPatient(Long id, PatientPatchRequest request);

    void deletePatient(Long id);
}

