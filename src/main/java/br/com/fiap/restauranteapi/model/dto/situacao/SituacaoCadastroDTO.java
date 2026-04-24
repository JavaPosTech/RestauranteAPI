package br.com.fiap.restauranteapi.model.dto.situacao;

import br.com.fiap.restauranteapi.model.entity.situacao.SituacaoCadastro;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de resposta com os dados de Situação de Cadastro")
public record SituacaoCadastroDTO(

        @Schema(description = "ID da situação de cadastro")
        Integer id,

        @Schema(description = "Descrição da situação de cadastro")
        String descricao

) {
    public SituacaoCadastroDTO(SituacaoCadastro pSituacaoCadastro) {
        this(pSituacaoCadastro.getId(), pSituacaoCadastro.getDescricao());
    }
}