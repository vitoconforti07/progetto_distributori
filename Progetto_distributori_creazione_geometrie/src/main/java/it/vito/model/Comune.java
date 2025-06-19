package it.vito.model;

public class Comune {


    private Integer idComune;
    private Integer codComune;
    private String nomeComune;
    private Integer idProvincia;
    private String geometria;

    public Comune() {
    }

    public Comune(Integer idComune, Integer codComune, String nomeComune, Integer idProvincia, String geometria) {
        this.idComune = idComune;
        this.codComune = codComune;
        this.nomeComune = nomeComune;
        this.idProvincia = idProvincia;
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

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
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
        private Integer id_provincia_fk;
        private String geometria;

        public ComuneBuilder() {
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

        public ComuneBuilder idProvincia(Integer idProvincia) {
            this.id_provincia_fk = idProvincia;
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
            comune.setIdProvincia(id_provincia_fk);
            comune.setGeometria(geometria);
            return comune;
        }
    }
}
