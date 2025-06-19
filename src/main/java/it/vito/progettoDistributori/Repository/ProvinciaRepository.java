package it.vito.progettoDistributori.Repository;

import it.vito.progettoDistributori.model.db.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> {

    @Query(value = "select p.* from provincia  p inner join regione r on p.cod_regione_fk  = r.id_regione where r.nome_regione = :nomeRegione", nativeQuery = true)
    List<Provincia> getProvinciaFromRegione(@Param("nomeRegione") String nomeRegione);

}
