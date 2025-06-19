package it.vito.progetto_distributori_struttura_db.model.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "comune")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comune {

    @Id
    @Column(name = "id_comune")
    private Integer idComune;
    @Column(name = "cod_comune")
    private Integer codComune;
    @Column(name = "nome_comune")
    private String nomeComune;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_provincia_fk")
    private Provincia provincia;
    @Column(name = "geometria")
    private String geometria;
}
