package it.vito.model;

public class Regione {

    private Integer idRegione;
    private Integer codRegione;
    private String nomeRegione;
    private String geometria;


    public Regione() {
        this.idRegione = null;
        this.codRegione = null;
        this.nomeRegione = null;
        this.geometria = null;
    }

    public Regione(Integer idRegione, Integer codRegione, String nomeRegione, String geometria) {
        this.idRegione = idRegione;
        this.codRegione = codRegione;
        this.nomeRegione = nomeRegione;
        this.geometria = geometria;
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

    public static final class RegioneBuilder {
        private Integer idRegione;
        private Integer codRegione;
        private String nomeRegione;
        private String geometria;

        public RegioneBuilder() {
        }

        public static RegioneBuilder aRegione() {
            return new RegioneBuilder();
        }

        public RegioneBuilder idRegione(Integer idRegione) {
            this.idRegione = idRegione;
            return this;
        }

        public RegioneBuilder codRegione(Integer codRegione) {
            this.codRegione = codRegione;
            return this;
        }

        public RegioneBuilder nomeRegione(String nomeRegione) {
            this.nomeRegione = nomeRegione;
            return this;
        }

        public RegioneBuilder geometria(String geometria) {
            this.geometria = geometria;
            return this;
        }

        public Regione build() {
            Regione regione = new Regione();
            regione.setIdRegione(idRegione);
            regione.setCodRegione(codRegione);
            regione.setNomeRegione(nomeRegione);
            regione.setGeometria(geometria);
            return regione;
        }
    }
}
