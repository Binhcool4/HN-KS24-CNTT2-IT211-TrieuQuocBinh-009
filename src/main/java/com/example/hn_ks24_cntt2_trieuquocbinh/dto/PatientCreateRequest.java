package com.example.hn_ks24_cntt2_trieuquocbinh.dto;

import com.example.hn_ks24_cntt2_trieuquocbinh.entity.PatientStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class PatientCreateRequest {

    @NotBlank(message = "Họ tên không được để trống")
    private String fullName;

    @NotBlank(message = "Bệnh lý không được để trống")
    private String disease;

    @Positive(message = "Viện phí phải lớn hơn 0")
    private BigDecimal treamentFee;

    private PatientStatus status;
}

