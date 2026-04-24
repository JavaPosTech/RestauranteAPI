package br.com.fiap.restauranteapi.exceptions.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo utilizado para representar erros de validação de campos da requisição")
public record MethodArgumentNotValidResponseDTO(

        @Schema(description = "Campo que causou o erro de validação")
        String field,

        @Schema(description = "Mensagem de erro de validação")
        String message

) {}