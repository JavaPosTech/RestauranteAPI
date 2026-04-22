package br.com.fiap.restauranteapi.service.situacaoCadastro;

import br.com.fiap.restauranteapi.model.entity.situacao.SituacaoCadastro;
import br.com.fiap.restauranteapi.repository.situacaoCadastro.SituacaoCadastroRepository;
import org.springframework.stereotype.Service;

@Service
public class SituacaoCadastroService {

    private final SituacaoCadastroRepository situacaoCadastroRepository;

    public SituacaoCadastroService(SituacaoCadastroRepository situacaoCadastroRepository) {
        this.situacaoCadastroRepository = situacaoCadastroRepository;
    }
    public SituacaoCadastro getSituacaoCadastroById(Integer id) {
        return situacaoCadastroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Situação de Cadastro não encontrada com o ID: " + id));
    }
}
