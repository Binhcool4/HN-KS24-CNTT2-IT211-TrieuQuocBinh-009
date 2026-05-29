package com.example.hn_ks24_cntt2_trieuquocbinh.dto;

import com.example.hn_ks24_cntt2_trieuquocbinh.entity.PatientStatus;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class PatientResponse {
    private Long id;
    private String fullName;
    private String disease;
    private BigDecimal treamentFee;
    private PatientStatus status;
}

