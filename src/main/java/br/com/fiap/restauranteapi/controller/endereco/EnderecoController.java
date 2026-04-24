package br.com.fiap.restauranteapi.controller.endereco;

import br.com.fiap.restauranteapi.model.dto.endereco.EnderecoDTO;
import br.com.fiap.restauranteapi.service.endereco.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/endereco")
public class EnderecoController implements EnderecoDocs {

    private final EnderecoService enderecoService;

    @Override
    public ResponseEntity<List<EnderecoDTO>> getAll() {
        return ResponseEntity.ok(enderecoService.findAll());
    }
}