package com.jadevirek.patientservice.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid patient data")
public class InvalidPatientException extends RuntimeException {
    private Long patientId;
    private String errorMessage;

    public InvalidPatientException(Long patientId, String errorMessage) {
        this.patientId = patientId;
        this.errorMessage = errorMessage;
    }

    public Long getPatientId() {
        return patientId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
