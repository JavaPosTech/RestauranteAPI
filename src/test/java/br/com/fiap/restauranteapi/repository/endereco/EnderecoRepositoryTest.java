package br.com.fiap.restauranteapi.repository.endereco;

import br.com.fiap.restauranteapi.config.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
class EnderecoRepositoryTest extends AbstractTest {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Test
    void findAllFetchUsuarioTest() {
        var enderecos = Assertions.assertDoesNotThrow(() -> enderecoRepository.findAllFetchUsuario(Pageable.unpaged()));
        Assertions.assertNotNull(enderecos);
    }
}