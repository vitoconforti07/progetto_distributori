package it.vito.distributori.repository;

import it.vito.distributori.model.db.Regione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegioneRepository extends JpaRepository<Regione, Integer> {



}
