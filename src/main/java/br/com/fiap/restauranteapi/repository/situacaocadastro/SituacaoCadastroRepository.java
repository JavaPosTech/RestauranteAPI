package br.com.fiap.restauranteapi.repository.situacaocadastro;

import br.com.fiap.restauranteapi.model.entity.situacao.SituacaoCadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SituacaoCadastroRepository extends JpaRepository<SituacaoCadastro, Integer> {

    Optional<SituacaoCadastro> findByDescricaoIgnoreCase(@Param("descricao") String descricao);

}