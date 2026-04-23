package br.com.fiap.restauranteapi.model.request.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Request para autenticação do usuário")
public record LoginRequest(

        @NotBlank(message = "O campo 'login' é obrigatório!")
        @Schema(description = "Login do Usuário", example = "usuario123")
        String login,

        @NotBlank(message = "O campo 'senha' é obrigatório!")
        @Size(min = 10, message = "A senha deve ter no mínimo 10 caracteres!")
        @Schema(description = "Senha do Usuário", example = "senha@1234", minLength = 10)
        String senha

) {
}