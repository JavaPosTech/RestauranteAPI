package br.com.fiap.restauranteapi.repository.usuario;

import br.com.fiap.restauranteapi.config.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest extends AbstractTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByLoginTest() {
        var usuario = Assertions.assertDoesNotThrow(() -> userRepository.findByLogin("joao_user01"));

        Assertions.assertNotNull(usuario);
        Assertions.assertTrue(usuario.isPresent());
        Assertions.assertEquals("joao_user01", usuario.get().getLogin());
    }

    @Test
    void findByNomeTest() {
        var usuario = Assertions.assertDoesNotThrow(() -> userRepository.findByNome("João Silva"));

        Assertions.assertNotNull(usuario);
        Assertions.assertTrue(usuario.isPresent());
        Assertions.assertEquals("João Silva", usuario.get().getNome());
    }

    @Test
    void existsByEmailIgnoreCaseTest() {
        var emailExistente = Assertions.assertDoesNotThrow(() -> userRepository.existsByEmailIgnoreCase("joao@email.com"));
        var emailInexistente = Assertions.assertDoesNotThrow(() -> userRepository.existsByEmailIgnoreCase("inexistente@email.com"));

        Assertions.assertEquals(Boolean.TRUE, emailExistente);
        Assertions.assertNotEquals(Boolean.TRUE, emailInexistente);
    }

    @Test
    void existsByLoginIgnoreCaseTest() {
        var loginExistente = Assertions.assertDoesNotThrow(() -> userRepository.existsByLoginIgnoreCase("joao_user01"));
        var loginInexistente = Assertions.assertDoesNotThrow(() -> userRepository.existsByLoginIgnoreCase("inexistente_user"));

        Assertions.assertEquals(Boolean.TRUE, loginExistente);
        Assertions.assertNotEquals(Boolean.TRUE, loginInexistente);
    }
}