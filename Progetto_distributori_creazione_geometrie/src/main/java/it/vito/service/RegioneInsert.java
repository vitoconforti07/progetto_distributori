package it.vito.service;

import it.vito.model.Regione;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegioneInsert {


    private static final String INSERT_USERS_SQL = "INSERT INTO regione" + "  (cod_regione, nome_regione, geometria) VALUES " + " (?, ?, ?);";

    public Connection connectionToDatabase(String url, String user, String password) throws SQLException {

        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public void insertRecordRegione(Regione regione, Connection connection) {
//        System.out.println(INSERT_USERS_SQL);

        try {

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            {
                preparedStatement.setInt(1, regione.getCodRegione());
                preparedStatement.setString(2, regione.getNomeRegione());
                preparedStatement.setString(3, regione.getGeometria());

//                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                preparedStatement.executeUpdate();
                System.out.println("inserimento della regione "+ regione.getNomeRegione()+ " eseguito  "+ regione.getCodRegione() );
            }

            // Step 4: try-with-resource statement will auto close the connection.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

