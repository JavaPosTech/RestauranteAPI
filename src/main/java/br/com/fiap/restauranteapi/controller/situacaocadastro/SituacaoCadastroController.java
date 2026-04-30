package br.com.fiap.restauranteapi.controller.situacaocadastro;

import br.com.fiap.restauranteapi.model.dto.situacao.SituacaoCadastroDTO;
import br.com.fiap.restauranteapi.service.situacaocadastro.SituacaoCadastroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/situacaocadastro")
public class SituacaoCadastroController implements SituacaoCadastroDocs {

    private final SituacaoCadastroService situacaoCadastroService;

    @Override
    public ResponseEntity<List<SituacaoCadastroDTO>> getAll() {
        return ResponseEntity.ok(situacaoCadastroService.findAll());
    }
}