package br.com.fiap.restauranteapi.controller.auth;

import br.com.fiap.restauranteapi.model.request.auth.AlterarSenhaRequest;
import br.com.fiap.restauranteapi.model.request.auth.LoginRequest;
import br.com.fiap.restauranteapi.model.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class AuthController implements AuthDocs {

    private final AuthService authService;

    @Override
    public ResponseEntity<MensagemSucessoResponse> login(@RequestBody @Valid LoginRequest pLoginRequest) {
        return ResponseEntity.ok(authService.autenticarUsuario(pLoginRequest));
    }

    @Override
    public ResponseEntity<MensagemSucessoResponse> alterarSenha(@RequestBody @Valid AlterarSenhaRequest pAlterarSenhaRequest) {
        return ResponseEntity.ok(authService.alterarSenha(pAlterarSenhaRequest));
    }
}