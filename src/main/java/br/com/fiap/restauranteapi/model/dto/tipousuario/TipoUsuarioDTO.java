package br.com.fiap.restauranteapi.model.dto.tipousuario;

import br.com.fiap.restauranteapi.model.entity.tipousuario.TipoUsuario;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de resposta com os dados do Tipo de Usuário")
public record TipoUsuarioDTO(

        @Schema(description = "Identificador único do tipo de usuário")
        Integer id,

        @Schema(description = "Descrição do tipo de usuário")
        String descricao

) {
    public TipoUsuarioDTO(TipoUsuario pTipoUsuario) {
        this(pTipoUsuario.getId(), pTipoUsuario.getDescricao());
    }
}