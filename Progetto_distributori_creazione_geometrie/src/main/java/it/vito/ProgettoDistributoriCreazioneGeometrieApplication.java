package it.vito;

import it.vito.model.Comune;
import it.vito.model.Provincia;
import it.vito.model.Regione;
import it.vito.service.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProgettoDistributoriCreazioneGeometrieApplication {

    public static void main(String[] args) throws IOException, SQLException {

         String url = "jdbc:postgresql://localhost:5432/Progetto_distributori_V_0.1";
         String user = "Vito";
         String password = "vito";
         String schema = "v_0_1";

        url = url +"?currentSchema="+schema;


//        RegioneService regioneService = new RegioneService();
//        List<Regione> regiones = regioneService.fromJsonToRegione();
//        System.out.println("creazione della lista regione eseguita");
        RegioneInsert regioneInsert = new RegioneInsert();
        Connection connection = regioneInsert.connectionToDatabase(url, user, password);
//        regiones.forEach(regione -> regioneInsert.insertRecordRegione(regione, connection));
//
//
//        ProvinciaService provinciaService = new ProvinciaService();
//        List<Provincia> provincias = provinciaService.fromJsonToProvincia();
//
//        System.out.println("creazione della lista provincia eseguita");
//        ProvinciaInsert provinciaInsert = new ProvinciaInsert();
//        provincias.forEach(provincia -> provinciaInsert.insertRecordProv(provincia, connection));
//
//        ComuneService comuneService = new ComuneService();
//        List<Comune> comuneList = comuneService.fromJsonToProvincia();
//        System.out.println("creazione della lista comuni eseguita");
//
//        ComuneInsert comuneInsert = new ComuneInsert();
//        comuneList.forEach(comune-> comuneInsert.insertRecordComune(comune,connection));


        //INSERT PREZZI

        PrezziService prezziService = new PrezziService();
        prezziService.insertPrezzi(connection);

    }

}
