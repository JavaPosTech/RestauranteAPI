package br.com.fiap.restauranteapi.controller.tipousuario;

import br.com.fiap.restauranteapi.model.dto.tipousuario.TipoUsuarioDTO;
import br.com.fiap.restauranteapi.service.tipousuario.TipoUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/tipousuario")
public class TipoUsuarioController implements TipoUsuarioDocs {

    private final TipoUsuarioService tipoUsuarioService;

    @Override
    public ResponseEntity<List<TipoUsuarioDTO>> getAll() {
        return ResponseEntity.ok(tipoUsuarioService.findAll());
    }
}