package it.vito.progetto_distributori_struttura_db.model.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "regione")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Regione {
    @Id
    @Column(name = "id_regione")
    private Integer idRegione;

    @Column(name = "cod_regione")
    private Integer codRegione;

    @Column(name = "nome_regione")
    private String nomeRegione;

    @Column(name = "geometria")
    private String geometria;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "regione", cascade = CascadeType.ALL)
    private List<Provincia> provinciaList;

}
