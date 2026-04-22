package br.com.fiap.restauranteapi.service.TipoUsuario;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TipoUsuarioServiceTest {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

     @Test
        void getTipoUsuarioById() {
            var tipoUsuario = tipoUsuarioService.getTipoUsuarioById(1);
            assertNotNull(tipoUsuario);
            assertEquals(1, tipoUsuario.getId());
        }


}