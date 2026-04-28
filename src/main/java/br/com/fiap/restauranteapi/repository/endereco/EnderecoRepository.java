package br.com.fiap.restauranteapi.repository.endereco;

import br.com.fiap.restauranteapi.model.entity.endereco.Endereco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    @Query("""
                SELECT e
                FROM Endereco e
                JOIN FETCH e.usuario
            """)
    Page<Endereco> findAllFetchUsuario(Pageable pageable);

}