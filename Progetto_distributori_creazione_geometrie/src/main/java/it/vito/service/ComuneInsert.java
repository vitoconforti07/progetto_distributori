package it.vito.service;

import it.vito.model.Comune;
import it.vito.model.Provincia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComuneInsert {

    private static final String INSERT_USERS_SQL = "INSERT INTO comune" + "  (cod_comune, nome_comune,id_provincia_fk, geometria) VALUES " + " (?,?, ?, ?);";

    public void insertRecordComune(Comune comune, Connection connection) {
//        System.out.println(INSERT_USERS_SQL);

        try {

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            {
                Provincia provincia = getProvincia(comune.getIdProvincia(), connection);
                preparedStatement.setInt(1, comune.getCodComune());
                preparedStatement.setString(2, comune.getNomeComune());
                preparedStatement.setInt(3,provincia.getIdProvincia());
                preparedStatement.setString(4, comune.getGeometria());

//                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                preparedStatement.executeUpdate();
                System.out.println("inserimento della comune " + comune.getNomeComune() + " eseguito  " + comune.getIdComune());
            }

            // Step 4: try-with-resource statement will auto close the connection.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    private Provincia getProvincia(Integer codProvincia, Connection connection) throws SQLException {

        List<Provincia> provinciaList = new ArrayList<>();
        String sqlgetProvFromComune = "SELECT id_provincia, cod_provincia, nome_provincia, sigla_provincia, cod_regione_fk FROM Provincia where cod_provincia=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sqlgetProvFromComune);
        preparedStatement.setInt(1, codProvincia);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {

            provinciaList.add(new Provincia(resultSet.getInt("id_provincia"), resultSet.getInt("cod_provincia"), resultSet.getString("nome_provincia"),resultSet.getString("sigla_provincia"),resultSet.getInt("cod_regione_fk"), null));
        }
        if(provinciaList.size() != 1){
            throw new RuntimeException("Errore");
        }else {
            return provinciaList.get(0);
        }

    }
}
