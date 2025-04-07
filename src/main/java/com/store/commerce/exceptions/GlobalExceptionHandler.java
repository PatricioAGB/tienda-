package com.store.commerce.exceptions;

import com.store.commerce.modules.fielderror.FieldErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Metodo para manejar errores de validación
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldErrorDTO> errors = new ArrayList<>();

        // Iteramos sobre los errores y los agregamos al listado
        for (FieldError error : result.getFieldErrors()) {
            FieldErrorDTO fieldErrorDTO = new FieldErrorDTO(error.getField(), error.getDefaultMessage());
            errors.add(fieldErrorDTO);
        }

        return new ResponseEntity<>(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);
    }

    // Clase de respuesta para devolver los errores en el formato esperado
    public static class ErrorResponse {
        private List<FieldErrorDTO> errors;

        public ErrorResponse(List<FieldErrorDTO> errors) {
            this.errors = errors;
        }

        public List<FieldErrorDTO> getErrors() {
            return errors;
        }

        public void setErrors(List<FieldErrorDTO> errors) {
            this.errors = errors;
        }
    }
}
