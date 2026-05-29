package com.example.hn_ks24_cntt2_trieuquocbinh.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PatientStatus {
    ADMITTED("admitted"),
    DISCHARGED("discharged");

    private final String value;

    PatientStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static PatientStatus fromValue(String value) {
        for (PatientStatus status : values()) {
            if (status.value.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Trạng thái không hợp lệ");
    }
}

