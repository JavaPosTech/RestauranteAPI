package br.com.fiap.restauranteapi.model.dto.endereco;

import br.com.fiap.restauranteapi.model.entity.endereco.Endereco;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de resposta com os dados de Endereço do Usuário")
public record EnderecoDTO(

        @Schema(description = "Identificador único do endereço")
        Integer id,

        @Schema(description = "Identificador único do usuário proprietário do endereço")
        Integer usuarioId,

        @Schema(description = "Nome da rua")
        String rua,

        @Schema(description = "Cidade")
        String cidade,

        @Schema(description = "Estado")
        String estado,

        @Schema(description = "Complemento do endereço")
        String complemento,

        @Schema(description = "Ponto de referência")
        String pontoReferencia,

        @Schema(description = "CEP")
        String cep

) {
    public EnderecoDTO(Endereco pEndereco) {
        this(pEndereco.getId(), pEndereco.getUsuario().getId(), pEndereco.getRua(), pEndereco.getCidade(), pEndereco.getEstado(), pEndereco.getComplemento(), pEndereco.getPontoReferencia(), pEndereco.getCep());
    }
}