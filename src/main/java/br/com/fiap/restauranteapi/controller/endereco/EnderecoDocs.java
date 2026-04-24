package br.com.fiap.restauranteapi.controller.endereco;

import br.com.fiap.restauranteapi.model.dto.endereco.EnderecoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Tag(name = "Endereço", description = "Endpoints relacionados aos Endereços dos Usuários")
public interface EnderecoDocs {

    @Operation(summary = "Listar endereços dos usuários")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista de endereços dos usuários retornada com sucesso."
            )
    })
    @GetMapping
    ResponseEntity<List<EnderecoDTO>> getAll();

}