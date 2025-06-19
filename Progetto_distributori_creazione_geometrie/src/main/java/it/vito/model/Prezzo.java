package it.vito.model;

import java.sql.Timestamp;

public class Prezzo {

    private String descCarburante;
    private String prezzo;
    private Boolean isSelf;
    private Timestamp dtComu;


    public Prezzo() {
    }

    public Prezzo(String descCarburante, String prezzo, Boolean isSelf, Timestamp dtComu) {
        this.descCarburante = descCarburante;
        this.prezzo = prezzo;
        this.isSelf = isSelf;
        this.dtComu = dtComu;
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
