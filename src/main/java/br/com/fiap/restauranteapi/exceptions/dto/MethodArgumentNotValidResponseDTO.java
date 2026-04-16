package br.com.fiap.restauranteapi.exceptions.dto;

import org.springframework.validation.FieldError;

public record MethodArgumentNotValidResponseDTO(

        String field,

        String message

) {
    public MethodArgumentNotValidResponseDTO(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }
}