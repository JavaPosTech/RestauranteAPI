package br.com.fiap.restauranteapi.service.usuario;

import br.com.fiap.restauranteapi.exceptions.UsuarioNotFoundException;
import br.com.fiap.restauranteapi.model.dto.usuario.UsuarioDTO;
import br.com.fiap.restauranteapi.model.entity.usuario.Usuario;
import br.com.fiap.restauranteapi.model.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.repository.situacaocadastro.SituacaoCadastroRepository;
import br.com.fiap.restauranteapi.repository.tipousuario.TipoUsuarioRepository;
import br.com.fiap.restauranteapi.repository.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final SituacaoCadastroRepository situacaoCadastroRepository;
    private final TipoUsuarioRepository tipoUsuarioRepository;

    public Usuario getUsuarioByLogin(String pLogin) {
        return usuarioRepository.findByLogin(pLogin).orElseThrow(() -> new UsuarioNotFoundException("O Usuário com o login informado não foi encontrado!"));
    }

    @Transactional(readOnly = true)
    public UsuarioDTO getUsuarioById(Integer pId) {
        var usuario = usuarioRepository.getReferenceById(pId);

        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTipoUsuario().getDescricao(),
                usuario.getSituacaoCadastro().getDescricao(),
                usuario.getDataAlteracao(),
                usuario.getLogin(),
                usuario.getSenha()
        );
    }

    @Transactional(readOnly = true)
    public UsuarioDTO getUsuarioByNome(String pNome) {
        var usuario = usuarioRepository.findByNome(pNome).orElseThrow(() -> new UsuarioNotFoundException("O Usuário com o nome informado não foi encontrado!"));

        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTipoUsuario().getDescricao(),
                usuario.getSituacaoCadastro().getDescricao(),
                usuario.getDataAlteracao(),
                usuario.getLogin(),
                usuario.getSenha()
                );
    }

    @Transactional
    public MensagemSucessoResponse createUser(UsuarioDTO usuarioDTO) {
        if (usuarioRepository.existsByEmailIgnoreCase(usuarioDTO.email())) {
            throw new IllegalArgumentException("E-mail já cadastrado no sistema!");
        }

        if (usuarioRepository.existsByLoginIgnoreCase(usuarioDTO.login())) {
            throw new IllegalArgumentException("Login já cadastrado no sistema!");
        }

        var tipoUsuario = tipoUsuarioRepository.findByDescricaoIgnoreCase(usuarioDTO.tipoUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de usuário inválido!"));

        var situacaoCadastro = situacaoCadastroRepository.findByDescricaoIgnoreCase(usuarioDTO.situacaoCadastro())
                .orElseThrow(() -> new IllegalArgumentException("Situação de cadastro inválida!"));

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.nome());
        usuario.setLogin(usuarioDTO.login());
        usuario.setSenha(passwordEncoder.encode(usuarioDTO.senha()));
        usuario.setEmail(usuarioDTO.email());
        usuario.setTipoUsuario(tipoUsuario);
        usuario.setSituacaoCadastro(situacaoCadastro);
        usuario.setDataAlteracao(LocalDate.now());

        usuarioRepository.save(usuario);

        return new MensagemSucessoResponse(HttpStatus.CREATED.value(), "Usuário cadastrado com sucesso!");
    }
}