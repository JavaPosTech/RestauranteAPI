package br.com.fiap.restauranteapi.controller.situacaocadastro;

import br.com.fiap.restauranteapi.model.dto.situacao.SituacaoCadastroDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Tag(name = "Situação Cadastro", description = "Endpoints relacionados às Situações de Cadastro dos Usuários")
public interface SituacaoCadastroDocs {

    @Operation(summary = "Listar situações de cadastro")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista de situações de cadastro retornada com sucesso."
            )
    })
    @GetMapping
    ResponseEntity<List<SituacaoCadastroDTO>> getAll();

}