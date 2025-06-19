package it.vito.distributori.model;

import java.util.List;

public class DistributoreDTO {

    private Integer idImpianto;
    private String gestore;
    private String bandiera;
    private String tipoImpianto;
    private String nomeImpianto;
    private String indirizzo;
    private String comune;
    private  String provincia;
    private Double latitudine;
    private Double longitudine;

    private Double distanza;

    private List<PrezzoDTO> prezzi;

    public DistributoreDTO() {
    }

    public DistributoreDTO(Integer idImpianto, String gestore, String bandiera, String tipoImpianto, String nomeImpianto, String indirizzo, String comune, String provincia, Double latitudine, Double longitudine, Double distanza, List<PrezzoDTO> prezzi) {
        this.idImpianto = idImpianto;
        this.gestore = gestore;
        this.bandiera = bandiera;
        this.tipoImpianto = tipoImpianto;
        this.nomeImpianto = nomeImpianto;
        this.indirizzo = indirizzo;
        this.comune = comune;
        this.provincia = provincia;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.distanza = distanza;
        this.prezzi = prezzi;
    }

    public Integer getIdImpianto() {
        return idImpianto;
    }

    public void setIdImpianto(Integer idImpianto) {
        this.idImpianto = idImpianto;
    }

    public String getGestore() {
        return gestore;
    }

    public void setGestore(String gestore) {
        this.gestore = gestore;
    }

    public String getBandiera() {
        return bandiera;
    }

    public void setBandiera(String bandiera) {
        this.bandiera = bandiera;
    }

    public String getTipoImpianto() {
        return tipoImpianto;
    }

    public void setTipoImpianto(String tipoImpianto) {
        this.tipoImpianto = tipoImpianto;
    }

    public String getNomeImpianto() {
        return nomeImpianto;
    }

    public void setNomeImpianto(String nomeImpianto) {
        this.nomeImpianto = nomeImpianto;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Double getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(Double latitudine) {
        this.latitudine = latitudine;
    }

    public Double getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(Double longitudine) {
        this.longitudine = longitudine;
    }

    public Double getDistanza() {
        return distanza;
    }

    public void setDistanza(Double distanza) {
        this.distanza = distanza;
    }

    public List<PrezzoDTO> getPrezzi() {
        return prezzi;
    }

    public void setPrezzi(List<PrezzoDTO> prezzi) {
        this.prezzi = prezzi;
    }
}
