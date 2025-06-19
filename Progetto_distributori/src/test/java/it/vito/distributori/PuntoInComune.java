package it.vito.distributori;

public class PuntoInComune {

    private Integer id_regione;
    private Integer cod_regione;
    private String nome_regione;
    private Double lantPunto;
    private Double lonPunto;

    public PuntoInComune() {
    }

    public PuntoInComune(Integer id_regione, Integer cod_regione, String nome_regione, Double lantPunto, Double lonPunto) {
        this.id_regione = id_regione;
        this.cod_regione = cod_regione;
        this.nome_regione = nome_regione;
        this.lantPunto = lantPunto;
        this.lonPunto = lonPunto;
    }

    public Integer getId_regione() {
        return id_regione;
    }

    public void setId_regione(Integer id_regione) {
        this.id_regione = id_regione;
    }

    public Integer getCod_regione() {
        return cod_regione;
    }

    public void setCod_regione(Integer cod_regione) {
        this.cod_regione = cod_regione;
    }

    public String getNome_regione() {
        return nome_regione;
    }

    public void setNome_regione(String nome_regione) {
        this.nome_regione = nome_regione;
    }

    public Double getLantPunto() {
        return lantPunto;
    }

    public void setLantPunto(Double lantPunto) {
        this.lantPunto = lantPunto;
    }

    public Double getLonPunto() {
        return lonPunto;
    }

    public void setLonPunto(Double lonPunto) {
        this.lonPunto = lonPunto;
    }
}
