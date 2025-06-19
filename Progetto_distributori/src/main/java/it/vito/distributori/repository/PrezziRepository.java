package it.vito.distributori.repository;

import it.vito.distributori.model.db.Prezzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrezziRepository extends JpaRepository<Prezzo, Integer> {

    @Query(value = "select * from prezzi_distributore pd where pd.id_impianto_fk in :idImpianti", nativeQuery = true)
    List<Prezzo> getPrezziFromImpianti(@Param("idImpianti") List<Integer> idImpianti);
    @Query(value = "select * from prezzi_distributore pd where pd.id_impianto_fk =:idImpianto", nativeQuery = true)
    List<Prezzo> getPrezziFromImpianto(@Param("idImpianto") Integer idImpianto);

}
