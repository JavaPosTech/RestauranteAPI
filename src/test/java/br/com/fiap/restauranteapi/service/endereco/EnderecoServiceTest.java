package br.com.fiap.restauranteapi.service.endereco;

import br.com.fiap.restauranteapi.config.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EnderecoServiceTest extends AbstractTest {

    @Autowired
    private EnderecoService enderecoService;

    @Test
    void findAllTest() {
        var endereco = enderecoService.findAll();
        Assertions.assertNotNull(endereco);
    }
}