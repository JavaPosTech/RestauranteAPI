package br.com.fiap.restauranteapi.service.situacaocadastro;

import br.com.fiap.restauranteapi.model.dto.situacao.SituacaoCadastroDTO;
import br.com.fiap.restauranteapi.repository.situacaocadastro.SituacaoCadastroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SituacaoCadastroService {

    private final SituacaoCadastroRepository situacaoCadastroRepository;

    @Transactional(readOnly = true)
    public List<SituacaoCadastroDTO> findAll() {
        var situacaoCadastro = situacaoCadastroRepository.findAll();

        return situacaoCadastro.stream()
                .map(SituacaoCadastroDTO::new)
                .toList();
    }
}