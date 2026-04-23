package br.com.fiap.restauranteapi.model.request.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Request para solicitação de alteração de senha")
public record AlterarSenhaRequest(

        @NotBlank(message = "O campo 'login' é obrigatório!")
        @Schema(description = "Login do Usuário", example = "usuario123")
        String login,

        @NotBlank(message = "O campo 'senhaAntiga' é obrigatório!")
        @Schema(description = "Senha atual do Usuário", example = "senhaAntiga123")
        String senhaAntiga,

        @NotBlank(message = "A campo 'senhaNova' é obrigatório!")
        @Size(min = 10, message = "A nova senha deve ter no mínimo 10 caracteres!")
        @Schema(description = "Nova senha do Usuário", example = "novaSenha@123", minLength = 10)
        String senhaNova

) {}