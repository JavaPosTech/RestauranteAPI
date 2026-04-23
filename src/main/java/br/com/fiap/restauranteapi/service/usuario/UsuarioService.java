package br.com.fiap.restauranteapi.service.usuario;

import br.com.fiap.restauranteapi.exceptions.LoginNotFoundException;
import br.com.fiap.restauranteapi.model.entity.usuario.Usuario;
import br.com.fiap.restauranteapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public Usuario getUsuarioByLogin(String pLogin) {
        return usuarioRepository.findByLogin(pLogin).orElseThrow(LoginNotFoundException::new);
    }
}