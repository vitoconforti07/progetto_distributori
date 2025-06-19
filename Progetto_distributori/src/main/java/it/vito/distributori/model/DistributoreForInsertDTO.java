package it.vito.distributori.model;

public class DistributoreForInsertDTO {

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

    public DistributoreForInsertDTO() {
    }

    public DistributoreForInsertDTO(Integer idImpianto, String gestore, String bandiera, String tipoImpianto, String nomeImpianto, String indirizzo, String comune, String provincia, Double latitudine, Double longitudine) {
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


    public static final class DistributoreDTOBuilder {
        private Integer idImpianto;
        private String gestore;
        private String bandiera;
        private String tipoImpianto;
        private String nomeImpianto;
        private String indirizzo;
        private String comune;
        private String provincia;
        private Double latitudine;
        private Double longitudine;

        public DistributoreDTOBuilder() {
        }

        public static DistributoreDTOBuilder aDistributoreDTO() {
            return new DistributoreDTOBuilder();
        }

        public DistributoreDTOBuilder idImpianto(Integer idImpianto) {
            this.idImpianto = idImpianto;
            return this;
        }

        public DistributoreDTOBuilder gestore(String gestore) {
            this.gestore = gestore;
            return this;
        }

        public DistributoreDTOBuilder bandiera(String bandiera) {
            this.bandiera = bandiera;
            return this;
        }

        public DistributoreDTOBuilder tipoImpianto(String tipoImpianto) {
            this.tipoImpianto = tipoImpianto;
            return this;
        }

        public DistributoreDTOBuilder nomeImpianto(String nomeImpianto) {
            this.nomeImpianto = nomeImpianto;
            return this;
        }

        public DistributoreDTOBuilder indirizzo(String indirizzo) {
            this.indirizzo = indirizzo;
            return this;
        }

        public DistributoreDTOBuilder comune(String comune) {
            this.comune = comune;
            return this;
        }

        public DistributoreDTOBuilder provincia(String provincia) {
            this.provincia = provincia;
            return this;
        }

        public DistributoreDTOBuilder latitudine(Double latitudine) {
            this.latitudine = latitudine;
            return this;
        }

        public DistributoreDTOBuilder longitudine(Double longitudine) {
            this.longitudine = longitudine;
            return this;
        }

        public DistributoreForInsertDTO build() {
            DistributoreForInsertDTO distributoreForInsertDTO = new DistributoreForInsertDTO();
            distributoreForInsertDTO.setIdImpianto(idImpianto);
            distributoreForInsertDTO.setGestore(gestore);
            distributoreForInsertDTO.setBandiera(bandiera);
            distributoreForInsertDTO.setTipoImpianto(tipoImpianto);
            distributoreForInsertDTO.setNomeImpianto(nomeImpianto);
            distributoreForInsertDTO.setIndirizzo(indirizzo);
            distributoreForInsertDTO.setComune(comune);
            distributoreForInsertDTO.setProvincia(provincia);
            distributoreForInsertDTO.setLatitudine(latitudine);
            distributoreForInsertDTO.setLongitudine(longitudine);
            return distributoreForInsertDTO;
        }
    }

    @Override
    public String toString() {
        return "DistributoreDTO{" +
                "idImpianto=" + idImpianto +
                ", gestore='" + gestore + '\'' +
                ", bandiera='" + bandiera + '\'' +
                ", tipoImpianto='" + tipoImpianto + '\'' +
                ", nomeImpianto='" + nomeImpianto + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", comune='" + comune + '\'' +
                ", provincia='" + provincia + '\'' +
                ", latitudine=" + latitudine +
                ", longitudine=" + longitudine +
                '}';
    }
}
