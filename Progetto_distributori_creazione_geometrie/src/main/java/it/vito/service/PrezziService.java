package it.vito.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class PrezziService {


    private static final String INSERT_USERS_SQL = "insert into prezzi_distributore (id_impianto_fk, desc_carburante, prezzo,is_self, data_comunicazione) values (?,?, ?, ?, to_timestamp(?, 'DD/MM/YYYY hh24:mi'));";
    private static final String QUERY = "select d.id_impianto ,d.cod_impianto  from distributore d;";


    public void insertPrezzi(Connection connection) throws SQLException {



        Map<Integer, Integer> distributori = getDistributori(connection);


            Path path = Paths.get("C:\\Users\\V.Conforti\\Desktop\\Progetto_distributori\\prezzo_alle_8.csv");

            try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
                String line = null;
                reader.readLine();
                reader.readLine();
                int numRow = 0;
                while ((line = reader.readLine()) != null) {
                    numRow++;
                    String[] split = line.split(";");

                    PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
                    try {
                        Integer idImpianto = distributori.get(Integer.valueOf(split[0]));
                        preparedStatement.setInt(1, idImpianto);
                        preparedStatement.setString(2, split[1]);
                        preparedStatement.setDouble(3, Double.valueOf(split[2]));
                        preparedStatement.setBoolean(4, Boolean.valueOf(split[3]));
                        preparedStatement.setString(5, split[4]);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                        e.getMessage();
                    }
//
                        preparedStatement.executeUpdate();

                        if (numRow % 2000 == 0 && numRow <= 81100) {
                            System.out.println(numRow);
                        }
//                        else if (numRow > 81100) {
//                            System.out.println(numRow);
//                        }

                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
                ioe.getMessage();

            }

    }

    private Map<Integer, Integer> getDistributori(Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();

        Map<Integer, Integer> map = new HashMap<>();
        ResultSet resultSet = stmt.executeQuery(QUERY);
        while (resultSet.next()) {
            map.put(resultSet.getInt("cod_impianto"), resultSet.getInt("id_impianto"));
        }
        return map;

    }
}



