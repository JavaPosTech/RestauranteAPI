package br.com.fiap.restauranteapi.service.situacaocadastro;

import br.com.fiap.restauranteapi.config.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SituacaoCadastroServiceTest extends AbstractTest {

    @Autowired
    private SituacaoCadastroService situacaoCadastroService;

    @Test
    void findAllTest() {
        var situacaoCadastro = situacaoCadastroService.findAll();
        Assertions.assertNotNull(situacaoCadastro);
    }
}