package br.com.fiap.restauranteapi.controller.usuario;

import br.com.fiap.restauranteapi.model.dto.usuario.UsuarioDTO;
import br.com.fiap.restauranteapi.model.entity.usuario.Usuario;
import br.com.fiap.restauranteapi.model.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.service.usuario.UsuarioService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/usuario")
public class UsuarioController implements UsuarioDocs {

    private final UsuarioService usuarioService;

    @Hidden
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable @NotNull Integer id) {
        return ResponseEntity.ok(usuarioService.getUsuarioById(id));
    }

    @Override
    public ResponseEntity<UsuarioDTO> getUsuarioByNome(@RequestParam @NotBlank String nome) {
        return ResponseEntity.ok(usuarioService.getUsuarioByNome(nome));
    }

    @PostMapping
    public MensagemSucessoResponse createUser(@RequestBody @Valid UsuarioDTO usuario) {
        MensagemSucessoResponse response = usuarioService.createUser(usuario);
        return new MensagemSucessoResponse(HttpStatus.OK.value(), "Usuário cadastrado com sucesso.");
    }

}