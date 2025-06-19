package it.vito.progetto_distributori_struttura_db.model.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "prezzi_distributore")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Prezzo {

    @Id
    @Column(name = "id_prezzo")
    private Integer idPrezzo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_impianto_fk")
    private Distributore distributore;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_carburante_fk")
    private String descCarburante;
    @Column(name = "prezzo")
    private String prezzo;
    @Column(name = "is_self")
    private Boolean isSelf;
    @Column(name = "data_comunicazione")
    private Timestamp dtComu;

}
