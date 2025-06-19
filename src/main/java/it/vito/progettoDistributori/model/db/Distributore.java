package it.vito.progettoDistributori.model.db;

import javax.persistence.*;

@Entity
@Table(name = "distributore")
public class Distributore {

    @Id
    @Column(name = "idImpianto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idImpianto;
    @Column(name = "cod_impianto")
    private Integer codImpianto;

    @Column(name = "gestore")
    private String gestore;
    @Column(name = "bandiera")
    private String bandiera;
    @Column( name = "tipo_impianto")
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

    public Distributore() {
    }

    public Distributore(Integer idImpianto, Integer codImpianto, String gestore, String bandiera, String tipoImpianto, String nomeImpianto, String indirizzo, Comune comune, Double latitudine, Double longitudine) {
        this.idImpianto = idImpianto;
        this.codImpianto = codImpianto;
        this.gestore = gestore;
        this.bandiera = bandiera;
        this.tipoImpianto = tipoImpianto;
        this.nomeImpianto = nomeImpianto;
        this.indirizzo = indirizzo;
        this.comune = comune;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }

    public Integer getIdImpianto() {
        return idImpianto;
    }

    public void setIdImpianto(Integer idImpianto) {
        this.idImpianto = idImpianto;
    }

    public Integer getCodImpianto() {
        return codImpianto;
    }

    public void setCodImpianto(Integer codImpianto) {
        this.codImpianto = codImpianto;
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

    public Comune getComune() {
        return comune;
    }

    public void setComune(Comune comune) {
        this.comune = comune;
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

    @Override
    public String toString() {
        return "Distributore{" +
                "idImpianto=" + idImpianto +
                ", codImpianto=" + codImpianto +
                ", gestore='" + gestore + '\'' +
                ", bandiera='" + bandiera + '\'' +
                ", tipoImpianto='" + tipoImpianto + '\'' +
                ", nomeImpianto='" + nomeImpianto + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", comune=" + comune +
                ", latitudine=" + latitudine +
                ", longitudine=" + longitudine +
                '}';
    }
}

