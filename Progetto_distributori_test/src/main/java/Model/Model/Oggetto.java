package Model.Model;

import Model.Model.db.Comune;

public class Oggetto {

    private Comune comune;
    private PuntoInComune puntoInComune;
    private Boolean flag;

    public Oggetto() {
    }

    public Oggetto(Comune comune, PuntoInComune puntoInComune, Boolean flag) {
        this.comune = comune;
        this.puntoInComune = puntoInComune;
        this.flag = flag;
    }

    public Comune getComune() {
        return comune;
    }

    public void setComune(Comune comune) {
        this.comune = comune;
    }

    public PuntoInComune getPuntoInComune() {
        return puntoInComune;
    }

    public void setPuntoInComune(PuntoInComune puntoInComune) {
        this.puntoInComune = puntoInComune;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
