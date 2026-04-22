package br.com.fiap.restauranteapi.repository.tipoUsuario;

import br.com.fiap.restauranteapi.model.entity.tipousuario.TipoUsuario;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {
}
