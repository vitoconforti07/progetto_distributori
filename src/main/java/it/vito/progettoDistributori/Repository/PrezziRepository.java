package it.vito.progettoDistributori.Repository;

import it.vito.progettoDistributori.model.db.Prezzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrezziRepository extends JpaRepository<Prezzo, Integer> {

    @Query(value = "select * from prezzi_distributore pd where pd.id_impianto_fk in :IdImpianti", nativeQuery = true)
    List<Prezzo> getPrezziFromImpianti(@Param("IdImpianti") List<Integer> IdImpianti);
    @Query(value = "select * from prezzi_distributore pd where pd.id_impianto_fk =:IdImpianto", nativeQuery = true)
    List<Prezzo> getPrezziFromImpianto(@Param("IdImpianto") Integer IdImpianto);

}
