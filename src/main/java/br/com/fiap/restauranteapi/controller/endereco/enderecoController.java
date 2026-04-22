package br.com.fiap.restauranteapi.controller.endereco;

import br.com.fiap.restauranteapi.model.entity.endereco.Endereco;
import br.com.fiap.restauranteapi.service.endereco.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/endereco")
public class enderecoController {
    private final EnderecoService enderecoService;

    public enderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarEnderecoPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(enderecoService.getEnderecoById(id));
    }
}

