package br.com.fiap.restauranteapi.repository.tipousuario;

import br.com.fiap.restauranteapi.model.entity.tipousuario.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {

    Optional<TipoUsuario> findByDescricaoIgnoreCase(@Param("descricao") String descricao);

}