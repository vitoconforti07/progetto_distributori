package it.vito.progettoDistributori.model.db;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "regione")
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

    public Regione() {
    }

    public Regione(Integer idRegione, Integer codRegione, String nomeRegione, String geometria, List<Provincia> provinciaList) {
        this.idRegione = idRegione;
        this.codRegione = codRegione;
        this.nomeRegione = nomeRegione;
        this.geometria = geometria;
        this.provinciaList = provinciaList;
    }

    public Integer getIdRegione() {
        return idRegione;
    }

    public void setIdRegione(Integer idRegione) {
        this.idRegione = idRegione;
    }

    public Integer getCodRegione() {
        return codRegione;
    }

    public void setCodRegione(Integer codRegione) {
        this.codRegione = codRegione;
    }

    public String getNomeRegione() {
        return nomeRegione;
    }

    public void setNomeRegione(String nomeRegione) {
        this.nomeRegione = nomeRegione;
    }

    public String getGeometria() {
        return geometria;
    }

    public void setGeometria(String geometria) {
        this.geometria = geometria;
    }

    public List<Provincia> getProvinciaList() {
        return provinciaList;
    }

    public void setProvinciaList(List<Provincia> provinciaList) {
        this.provinciaList = provinciaList;
    }
}
