package it.vito.progetto_distributori_struttura_db.model.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "provincia")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Provincia {

    @Id
    @Column(name = "id_provincia")
    private Integer idProvincia;
    @Column(name = "cod_provincia")
    private Integer codProvincia;
    @Column(name = "nome_provincia")
    private String nomeProvincia;
    @Column(name = "sigla_provincia")
    private String siglaProvincia;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_regione_fk")
    private Regione regione;
    @Column(name = "geometria")
    private String geometria;

}
