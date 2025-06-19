package it.vito.progettoDistributori.model.db;

import javax.persistence.*;

@Entity
@Table(name = "provincia", schema = "v_0_1")
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

    public Provincia() {
    }

    public Provincia(Integer idProvincia, Integer codProvincia, String nomeProvincia, String siglaProvincia, Regione regione, String geometria) {
        this.idProvincia = idProvincia;
        this.codProvincia = codProvincia;
        this.nomeProvincia = nomeProvincia;
        this.siglaProvincia = siglaProvincia;
        this.regione = regione;
        this.geometria = geometria;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public Integer getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(Integer codProvincia) {
        this.codProvincia = codProvincia;
    }

    public String getNomeProvincia() {
        return nomeProvincia;
    }

    public void setNomeProvincia(String nomeProvincia) {
        this.nomeProvincia = nomeProvincia;
    }

    public String getSiglaProvincia() {
        return siglaProvincia;
    }

    public void setSiglaProvincia(String siglaProvincia) {
        this.siglaProvincia = siglaProvincia;
    }

    public Regione getRegione() {
        return regione;
    }

    public void setRegione(Regione regione) {
        this.regione = regione;
    }

    public String getGeometria() {
        return geometria;
    }

    public void setGeometria(String geometria) {
        this.geometria = geometria;
    }


    public static final class ProvinciaBuilder {
        private Integer idProvincia;
        private Integer codProvincia;
        private String nomeProvincia;
        private String siglaProvincia;
        private Regione regione;
        private String geometria;

        private ProvinciaBuilder() {
        }

        public static ProvinciaBuilder aProvincia() {
            return new ProvinciaBuilder();
        }

        public ProvinciaBuilder idProvincia(Integer idProvincia) {
            this.idProvincia = idProvincia;
            return this;
        }

        public ProvinciaBuilder codProvincia(Integer codProvincia) {
            this.codProvincia = codProvincia;
            return this;
        }

        public ProvinciaBuilder nomeProvincia(String nomeProvincia) {
            this.nomeProvincia = nomeProvincia;
            return this;
        }

        public ProvinciaBuilder siglaProvincia(String siglaProvincia) {
            this.siglaProvincia = siglaProvincia;
            return this;
        }

        public ProvinciaBuilder regione(Regione regione) {
            this.regione = regione;
            return this;
        }

        public ProvinciaBuilder geometria(String geometria) {
            this.geometria = geometria;
            return this;
        }

        public Provincia build() {
            Provincia provincia = new Provincia();
            provincia.setIdProvincia(idProvincia);
            provincia.setCodProvincia(codProvincia);
            provincia.setNomeProvincia(nomeProvincia);
            provincia.setSiglaProvincia(siglaProvincia);
            provincia.setRegione(regione);
            provincia.setGeometria(geometria);
            return provincia;
        }
    }
}
