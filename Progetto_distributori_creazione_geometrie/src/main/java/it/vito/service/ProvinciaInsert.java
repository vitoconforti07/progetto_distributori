package it.vito.service;

import it.vito.model.Provincia;
import it.vito.model.Regione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvinciaInsert {

    private static final String INSERT_USERS_SQL = "INSERT INTO provincia" + "  (cod_provincia, nome_provincia,sigla_provincia,cod_regione_fk, geometria) VALUES " + " (?,?,?, ?, ?);";

    public void insertRecordProv(Provincia provincia, Connection connection) {
//        System.out.println(INSERT_USERS_SQL);

        try {

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            {
                Regione regione = getRegione(provincia.getCodRegione(), connection);
                preparedStatement.setInt(1, provincia.getCodProvincia());
                preparedStatement.setString(2, provincia.getNomeProvincia());
                preparedStatement.setString(3, provincia.getSiglaProvincia());
                preparedStatement.setInt(4,regione.getIdRegione());
                preparedStatement.setString(5, provincia.getGeometria());

//                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                preparedStatement.executeUpdate();
                System.out.println("inserimento della provincia " + provincia.getNomeProvincia() + " eseguito  " + provincia.getIdProvincia());
            }

            // Step 4: try-with-resource statement will auto close the connection.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    private Regione getRegione(Integer codRegione, Connection connection) throws SQLException {

        List<Regione> regioneList = new ArrayList<>();
        String sqlgetRegioneFromProv = "SELECT id_regione, cod_regione, nome_regione FROM Regione where cod_regione=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sqlgetRegioneFromProv);
        preparedStatement.setInt(1, codRegione);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {

            regioneList.add(new Regione(resultSet.getInt("id_regione"), resultSet.getInt("cod_regione"), resultSet.getString("nome_regione"), null));
        }
        if(regioneList.size() != 1){
            throw new RuntimeException("Errore");
        }else {
            return regioneList.get(0);
        }

    }
}
