package br.com.fiap.restauranteapi.service.usuario;

import br.com.fiap.restauranteapi.exceptions.LoginNotFoundException;
import br.com.fiap.restauranteapi.model.entity.usuario.Usuario;
import br.com.fiap.restauranteapi.repository.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario getUsuarioByLogin(String login) {
        return usuarioRepository.findByLogin(login).orElseThrow(LoginNotFoundException::new);
    }

    public Usuario getUsuarioById(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado com o ID: " + id));
    }
}