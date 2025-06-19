package Model.Model;

public class ComuneDTO {

    private Integer codComune;
    private String nomeComune;
    private String NomeProvincia;

    public ComuneDTO() {
    }

    public ComuneDTO(Integer codComune, String nomeComune, String nomeProvincia) {
        this.codComune = codComune;
        this.nomeComune = nomeComune;
        NomeProvincia = nomeProvincia;
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
        return NomeProvincia;
    }

    public void setNomeProvincia(String nomeProvincia) {
        NomeProvincia = nomeProvincia;
    }

    public static final class ComuneDTOBuilder {
        private Integer codComune;
        private String nomeComune;
        private String NomeProvincia;

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

        public ComuneDTOBuilder NomeProvincia(String NomeProvincia) {
            this.NomeProvincia = NomeProvincia;
            return this;
        }

        public ComuneDTO build() {
            ComuneDTO comuneDTO = new ComuneDTO();
            comuneDTO.setCodComune(codComune);
            comuneDTO.setNomeComune(nomeComune);
            comuneDTO.setNomeProvincia(NomeProvincia);
            return comuneDTO;
        }
    }
}
