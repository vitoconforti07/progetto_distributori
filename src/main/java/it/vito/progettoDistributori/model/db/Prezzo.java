package it.vito.progettoDistributori.model.db;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "prezzi_distributore")
public class Prezzo {

    @Id
    @Column(name = "id_prezzo")
    private Integer idPrezzo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_impianto_fk")
    private Distributore distributore;
    @Column(name = "desc_carburante")
    private String descCarburante;
    @Column(name = "prezzo")
    private String prezzo;
    @Column(name = "is_self")
    private Boolean isSelf;
    @Column(name = "data_comunicazione")
    private Timestamp dtComu;

    public Prezzo() {
    }

    public Prezzo(Integer idPrezzo, Distributore distributore, String descCarburante, String prezzo, Boolean isSelf, Timestamp dtComu) {
        this.idPrezzo = idPrezzo;
        this.distributore = distributore;
        this.descCarburante = descCarburante;
        this.prezzo = prezzo;
        this.isSelf = isSelf;
        this.dtComu = dtComu;
    }

    public Integer getIdPrezzo() {
        return idPrezzo;
    }

    public void setIdPrezzo(Integer idPrezzo) {
        this.idPrezzo = idPrezzo;
    }

    public Distributore getDistributore() {
        return distributore;
    }

    public void setDistributore(Distributore distributore) {
        this.distributore = distributore;
    }

    public String getDescCarburante() {
        return descCarburante;
    }

    public void setDescCarburante(String descCarburante) {
        this.descCarburante = descCarburante;
    }

    public String getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }

    public Boolean getSelf() {
        return isSelf;
    }

    public void setSelf(Boolean self) {
        isSelf = self;
    }

    public Timestamp getDtComu() {
        return dtComu;
    }

    public void setDtComu(Timestamp dtComu) {
        this.dtComu = dtComu;
    }
}
