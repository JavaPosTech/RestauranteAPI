package br.com.fiap.restauranteapi.service.endereco;

import br.com.fiap.restauranteapi.model.dto.endereco.EnderecoDTO;
import br.com.fiap.restauranteapi.repository.endereco.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Transactional(readOnly = true)
    public List<EnderecoDTO> findAll() {
        var endereco = enderecoRepository.findAll();

        return endereco.stream()
                .map(EnderecoDTO::new)
                .toList();
    }
}