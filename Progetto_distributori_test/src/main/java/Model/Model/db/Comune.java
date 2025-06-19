package Model.Model.db;

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


    public Comune() {
    }

    public Comune(Integer idComune, Integer codComune, String nomeComune) {
        this.idComune = idComune;
        this.codComune = codComune;
        this.nomeComune = nomeComune;

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


    @Override
    public String toString() {
        return "Comune{" +
                "idComune=" + idComune +
                ", codComune=" + codComune +
                ", nomeComune='" + nomeComune + '\'' +
                '}';
    }


}
