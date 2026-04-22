package br.com.fiap.restauranteapi.service.endereco;

import br.com.fiap.restauranteapi.model.entity.endereco.Endereco;
import br.com.fiap.restauranteapi.repository.endereco.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco getEnderecoById(Integer id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado com o ID: " + id));
    }
}
