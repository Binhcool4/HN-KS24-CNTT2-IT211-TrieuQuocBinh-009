package com.example.hn_ks24_cntt2_trieuquocbinh.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ErrorResponse {
    private String message;
    private List<FieldErrorResponse> errors;
}

