package com.example.hn_ks24_cntt2_trieuquocbinh.controller;

import com.example.hn_ks24_cntt2_trieuquocbinh.dto.MessageResponse;
import com.example.hn_ks24_cntt2_trieuquocbinh.dto.PatientCreateRequest;
import com.example.hn_ks24_cntt2_trieuquocbinh.dto.PatientPatchRequest;
import com.example.hn_ks24_cntt2_trieuquocbinh.dto.PatientResponse;
import com.example.hn_ks24_cntt2_trieuquocbinh.dto.PatientUpdateRequest;
import com.example.hn_ks24_cntt2_trieuquocbinh.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientResponse> createPatient(@Valid @RequestBody PatientCreateRequest request) {
        PatientResponse response = patientService.createPatient(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<PatientResponse>> getPatients(
            @RequestParam(required = false) String keyword,
            @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(patientService.getPatients(keyword, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> getPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> updatePatient(
            @PathVariable Long id,
            @Valid @RequestBody PatientUpdateRequest request) {
        return ResponseEntity.ok(patientService.updatePatient(id, request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PatientResponse> patchPatient(
            @PathVariable Long id,
            @Valid @RequestBody PatientPatchRequest request) {
        return ResponseEntity.ok(patientService.patchPatient(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok(new MessageResponse("Xóa bệnh nhân thành công"));
    }
}

