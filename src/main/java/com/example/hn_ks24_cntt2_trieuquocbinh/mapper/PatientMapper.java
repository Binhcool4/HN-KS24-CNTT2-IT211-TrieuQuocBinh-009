package com.example.hn_ks24_cntt2_trieuquocbinh.mapper;

import com.example.hn_ks24_cntt2_trieuquocbinh.dto.PatientCreateRequest;
import com.example.hn_ks24_cntt2_trieuquocbinh.dto.PatientPatchRequest;
import com.example.hn_ks24_cntt2_trieuquocbinh.dto.PatientResponse;
import com.example.hn_ks24_cntt2_trieuquocbinh.dto.PatientUpdateRequest;
import com.example.hn_ks24_cntt2_trieuquocbinh.entity.Patient;
import com.example.hn_ks24_cntt2_trieuquocbinh.entity.PatientStatus;

public final class PatientMapper {

    private PatientMapper() {
    }

    public static Patient toEntity(PatientCreateRequest request) {
        return Patient.builder()
                .fullName(request.getFullName())
                .disease(request.getDisease())
                .treamentFee(request.getTreamentFee())
                .status(request.getStatus() == null ? PatientStatus.ADMITTED : request.getStatus())
                .deleted(false)
                .build();
    }

    public static void updateEntity(Patient patient, PatientUpdateRequest request) {
        patient.setFullName(request.getFullName());
        patient.setDisease(request.getDisease());
        patient.setTreamentFee(request.getTreamentFee());
        patient.setStatus(request.getStatus() == null ? PatientStatus.ADMITTED : request.getStatus());
    }

    public static void patchEntity(Patient patient, PatientPatchRequest request) {
        if (request.getFullName() != null) {
            patient.setFullName(request.getFullName());
        }
        if (request.getDisease() != null) {
            patient.setDisease(request.getDisease());
        }
        if (request.getTreamentFee() != null) {
            patient.setTreamentFee(request.getTreamentFee());
        }
        if (request.getStatus() != null) {
            patient.setStatus(request.getStatus());
        }
    }

    public static PatientResponse toResponse(Patient patient) {
        return PatientResponse.builder()
                .id(patient.getId())
                .fullName(patient.getFullName())
                .disease(patient.getDisease())
                .treamentFee(patient.getTreamentFee())
                .status(patient.getStatus())
                .build();
    }
}

