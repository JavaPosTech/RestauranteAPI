package br.com.fiap.restauranteapi.exceptions.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Estrutura padrão para respostas de erro da API")
public record ErrorResponseDTO(

        @Schema(description = "Código HTTP da resposta", example = "400")
        int status,

        @Schema(description = "Tipo do erro HTTP", example = "Bad Request")
        String error,

        @Schema(description = "Mensagem principal do erro", example = "Dados inválidos na requisição!")
        String message,

        @Schema(description = "Detalhes adicionais do erro", example = "O campo 'email' é obrigatório!")
        String details,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy - HH:mm:ss")
        @Schema(description = "Data e hora em que o erro ocorreu", example = "15/04/2026 - 20:50:00")
        LocalDateTime timestamp

) {
    public ErrorResponseDTO(int pStatus, String pError, String pMessage, String pDetails) {
        this(pStatus, pError, pMessage, pDetails, LocalDateTime.now());
    }
}