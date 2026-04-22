package br.com.fiap.restauranteapi.service.TipoUsuario;

import br.com.fiap.restauranteapi.model.entity.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.repository.tipoUsuario.TipoUsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoUsuarioService {

    private final TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioService(TipoUsuarioRepository tipoUsuarioRepository) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    public TipoUsuario getTipoUsuarioById(Integer id) {
        return tipoUsuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de Usuário não encontrado com o ID: " + id));
    }
}
