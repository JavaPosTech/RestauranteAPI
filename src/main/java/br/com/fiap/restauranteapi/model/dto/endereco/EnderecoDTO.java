package br.com.fiap.restauranteapi.model.dto.endereco;

import br.com.fiap.restauranteapi.model.entity.endereco.Endereco;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de resposta com os dados de Endereço do Usuário")
public record EnderecoDTO(

        @Schema(description = "ID do endereço")
        Integer id,

        @Schema(description = "Nome do usuário proprietário do endereço")
        String nomeUsuario,

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
        this(pEndereco.getId(), pEndereco.getUsuario().getNome(), pEndereco.getRua(), pEndereco.getCidade(), pEndereco.getEstado(), pEndereco.getComplemento(), pEndereco.getPontoReferencia(), pEndereco.getCep());
    }
}