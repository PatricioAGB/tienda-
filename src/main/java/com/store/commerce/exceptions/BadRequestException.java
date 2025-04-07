package com.store.commerce.exceptions;

import com.store.commerce.modules.fielderror.FieldErrorDTO;

import java.util.List;

public class BadRequestException extends RuntimeException {
    private List<FieldErrorDTO> errors;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(List<FieldErrorDTO> errors) {
        super("Errores en la solicitud.");
        this.errors = errors;
    }

    public List<FieldErrorDTO> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldErrorDTO> errors) {
        this.errors = errors;
    }
}
