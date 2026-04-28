package br.com.fiap.restauranteapi.service.endereco;

import br.com.fiap.restauranteapi.model.dto.endereco.EnderecoDTO;
import br.com.fiap.restauranteapi.model.response.page.PageResponse;
import br.com.fiap.restauranteapi.repository.endereco.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Transactional(readOnly = true)
    public PageResponse<EnderecoDTO> findAll(Pageable pageable) {
        return PageResponse.from(enderecoRepository.findAllFetchUsuario(pageable), EnderecoDTO::new);
    }
}