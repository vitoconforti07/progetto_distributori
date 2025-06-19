package it.vito.progetto_distributori_struttura_db.model.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "distributore")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Distributore {

    @Id
    @Column(name = "idImpianto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idImpianto;
    @Column(name = "cod_impianto")
    private Integer codImpianto;

    @Column(name = "gestore")
    private String gestore;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_bandiera_fk")
    private String bandiera;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_impianto_fk")
    private String tipoImpianto;
    @Column(name = "nome_impianto")
    private String nomeImpianto;
    @Column(name = "indirizzo")
    private String indirizzo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_comune_fk")
    private Comune comune;
    @Column(name = "latitudine")
    private Double latitudine;
    @Column(name = "longitudine")
    private Double longitudine;

}

