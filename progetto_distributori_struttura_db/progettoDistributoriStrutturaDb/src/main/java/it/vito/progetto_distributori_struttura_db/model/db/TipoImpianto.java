package it.vito.progetto_distributori_struttura_db.model.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_impianto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoImpianto {

    private Integer id_tipo_impianto;
    private String tipo_impianto;

}
