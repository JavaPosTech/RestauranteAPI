package br.com.fiap.restauranteapi.model.request.endereco;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Modelo de request para criação de um Endereço")
public record CreateAddressRequest(

        @NotNull(message = "O campo 'usuarioId' é obrigatório!")
        @Min(value = 1, message = "O campo 'usuarioId' deve ser um número inteiro positivo!")
        @Schema(description = "Identificador único do usuário proprietário do endereço", example = "1")
        Integer usuarioId,

        @NotBlank(message = "O campo 'rua' é obrigatório!")
        @Schema(description = "Nome da rua", example = "Rua das Flores")
        String rua,

        @NotBlank(message = "O campo 'cidade' é obrigatório!")
        @Schema(description = "Cidade", example = "São Paulo")
        String cidade,

        @Schema(description = "Estado", example = "SP")
        @NotBlank(message = "O campo 'estado' é obrigatório!")
        @Size(min = 2, max = 2, message = "O campo 'estado' deve conter exatamente 2 caracteres!")
        String estado,

        @Schema(description = "Complemento do endereço", example = "Apartamento 101")
        String complemento,

        @Schema(description = "Ponto de referência", example = "Próximo ao supermercado")
        String pontoReferencia,

        @Size(min = 9, max = 9, message = "O campo 'cep' deve conter exatamente 9 caracteres (formato XXXXX-XXX)!")
        @Schema(description = "CEP", example = "12345-678")
        @NotBlank(message = "O campo 'cep' é obrigatório!")
        String cep

) {}