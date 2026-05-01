package br.com.fiap.restauranteapi.repository.situacaocadastro;

import br.com.fiap.restauranteapi.model.entity.situacaocadastro.RegistrationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationStatusRepository extends JpaRepository<RegistrationStatus, Integer> {

}