package Model.Model;

public class PuntoInComune {

    private Integer id_Comune;
    private Integer codComune;
    private String nomeComune;
    private Double lantPunto;
    private Double lonPunto;

    public PuntoInComune() {
    }

    public PuntoInComune(Integer id_Comune, Integer codComune, String nomeComune, Double lantPunto, Double lonPunto) {
        this.id_Comune = id_Comune;
        this.codComune = codComune;
        this.nomeComune = nomeComune;
        this.lantPunto = lantPunto;
        this.lonPunto = lonPunto;
    }

    @Override
    public String toString() {
        return "PuntoInComune{" +
                "id_regione=" + id_Comune +
                ", cod_regione=" + codComune +
                ", nome_regione='" + nomeComune + '\'' +
                ", lantPunto=" + lantPunto +
                ", lonPunto=" + lonPunto +
                '}';
    }

    public Integer getId_Comune() {
        return id_Comune;
    }

    public void setId_Comune(Integer id_Comune) {
        this.id_Comune = id_Comune;
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

    public Double getLantPunto() {
        return lantPunto;
    }

    public void setLantPunto(Double lantPunto) {
        this.lantPunto = lantPunto;
    }

    public Double getLonPunto() {
        return lonPunto;
    }

    public void setLonPunto(Double lonPunto) {
        this.lonPunto = lonPunto;
    }
}


