package it.vito.distributori.model;

public class ComuneDTO {

    private Integer codComune;
    private String nomeComune;
    private String nomeProvincia;

    public ComuneDTO() {
    }

    public ComuneDTO(Integer codComune, String nomeComune, String nomeProvincia) {
        this.codComune = codComune;
        this.nomeComune = nomeComune;
        this.nomeProvincia = nomeProvincia;
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

    public String getNomeProvincia() {
        return nomeProvincia;
    }

    public void setNomeProvincia(String nomeProvincia) {
        this.nomeProvincia = nomeProvincia;
    }

    public static final class ComuneDTOBuilder {
        private Integer codComune;
        private String nomeComune;
        private String nomeprovincia;

        public ComuneDTOBuilder() {
        }

        public static ComuneDTOBuilder aComuneDTO() {
            return new ComuneDTOBuilder();
        }

        public ComuneDTOBuilder codComune(Integer codComune) {
            this.codComune = codComune;
            return this;
        }

        public ComuneDTOBuilder nomeComune(String nomeComune) {
            this.nomeComune = nomeComune;
            return this;
        }

        public ComuneDTOBuilder nomeProvincia(String nomeProvincia) {
            this.nomeprovincia = nomeProvincia;
            return this;
        }

        public ComuneDTO build() {
            ComuneDTO comuneDTO = new ComuneDTO();
            comuneDTO.setCodComune(codComune);
            comuneDTO.setNomeComune(nomeComune);
            comuneDTO.setNomeProvincia(nomeprovincia);
            return comuneDTO;
        }
    }
}
