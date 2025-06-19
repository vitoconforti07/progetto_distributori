package it.vito.progettoDistributori.model.db;

import javax.persistence.*;

@Entity
@Table(name = "comune")
public class Comune {

    @Id
    @Column(name = "id_comune")
    private Integer idComune;
    @Column(name = "cod_comune")
    private Integer codComune;
    @Column(name = "nome_comune")
    private String nomeComune;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_provincia_fk")
    private Provincia provincia;
    @Column(name = "geometria")
    private String geometria;

    public Comune() {
    }

    public Comune(Integer idComune, Integer codComune, String nomeComune, Provincia provincia, String geometria) {
        this.idComune = idComune;
        this.codComune = codComune;
        this.nomeComune = nomeComune;
        this.provincia = provincia;
        this.geometria = geometria;
    }

    public Integer getIdComune() {
        return idComune;
    }

    public void setIdComune(Integer idComune) {
        this.idComune = idComune;
    }

    public Integer getCodComune() {
        return codComune;
    }

    public void setCodComune(Integer codComune) {
        this.codComune = codComune;
    }

    public String getNomeComune() {
        return nomeComune;
    }

    public void setNomeComune(String nomeComune) {
        this.nomeComune = nomeComune;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public String getGeometria() {
        return geometria;
    }

    public void setGeometria(String geometria) {
        this.geometria = geometria;
    }


    public static final class ComuneBuilder {
        private Integer idComune;
        private Integer codComune;
        private String nomeComune;
        private Provincia provincia;
        private String geometria;

        private ComuneBuilder() {
        }

        public static ComuneBuilder aComune() {
            return new ComuneBuilder();
        }

        public ComuneBuilder idComune(Integer idComune) {
            this.idComune = idComune;
            return this;
        }

        public ComuneBuilder codComune(Integer codComune) {
            this.codComune = codComune;
            return this;
        }

        public ComuneBuilder nomeComune(String nomeComune) {
            this.nomeComune = nomeComune;
            return this;
        }

        public ComuneBuilder provincia(Provincia provincia) {
            this.provincia = provincia;
            return this;
        }

        public ComuneBuilder geometria(String geometria) {
            this.geometria = geometria;
            return this;
        }

        public Comune build() {
            Comune comune = new Comune();
            comune.setIdComune(idComune);
            comune.setCodComune(codComune);
            comune.setNomeComune(nomeComune);
            comune.setProvincia(provincia);
            comune.setGeometria(geometria);
            return comune;
        }
    }
}
