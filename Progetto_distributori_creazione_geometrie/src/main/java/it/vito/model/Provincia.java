package it.vito.model;

public class Provincia {


    private Integer idProvincia;
    private Integer codProvincia;
    private String nomeProvincia;
    private String siglaProvincia;
    private Integer codRegione;
    private String geometria;

    public Provincia() {
    }

    public Provincia(Integer idProvincia, Integer codProvincia, String nomeProvincia, String siglaProvincia, Integer codRegione, String geometria) {
        this.idProvincia = idProvincia;
        this.codProvincia = codProvincia;
        this.nomeProvincia = nomeProvincia;
        this.siglaProvincia = siglaProvincia;
        this.codRegione = codRegione;
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

    public Integer getCodRegione() {
        return codRegione;
    }

    public void setCodRegione(Integer codRegione) {
        this.codRegione = codRegione;
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
        private Integer codRegione;
        private String geometria;

        public ProvinciaBuilder() {
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

        public ProvinciaBuilder codRegione(Integer codRegione) {
            this.codRegione = codRegione;
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
            provincia.setCodRegione(codRegione);
            provincia.setGeometria(geometria);
            return provincia;
        }
    }
}
