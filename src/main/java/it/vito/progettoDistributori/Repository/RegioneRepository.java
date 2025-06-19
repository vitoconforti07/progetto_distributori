package it.vito.progettoDistributori.Repository;

import it.vito.progettoDistributori.model.db.Regione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegioneRepository extends JpaRepository<Regione, Integer> {



}
