package com.example.hn_ks24_cntt2_trieuquocbinh.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FieldErrorResponse {
    private String field;
    private String message;
}

