package it.vito.distributori.repository;

import it.vito.distributori.model.db.Distributore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistributoreRepository extends JpaRepository<Distributore, Integer> {

    @Query(value = "select * from distributore d inner join comune c on d.id_comune_fk = c.id_comune where c.id_comune =:idComune", nativeQuery = true)
    List<Distributore> findDistributoriByIdComune(@Param("idComune") Integer idComune);

}
