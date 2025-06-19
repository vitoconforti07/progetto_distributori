package it.vito.progettoDistributori.Repository;

import it.vito.progettoDistributori.model.db.Comune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComuneRepository extends JpaRepository<Comune, Integer> {

    @Query(value = "select c.* from comune c inner join provincia p  on c.id_provincia_fk  = p.id_provincia where p.nome_provincia  =:nomeProvincia", nativeQuery = true)
    List<Comune> getComuneFromProvincia(@Param("nomeProvincia") String nomeProvincia);

}
