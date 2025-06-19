package it.vito.service;


import it.vito.model.Regione;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RegioneService {

    public List<Regione> fromJsonToRegione() throws IOException {
        Path path = Paths.get("C:\\Users\\V.Conforti\\Desktop\\Progetto_distributori\\regioni.json");
        List<Regione> regioneList = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            System.out.println("1");

            JSONObject jsonObject = new JSONObject(reader.lines().collect(Collectors.joining()));
            JSONArray features = jsonObject.getJSONArray("features");

            if (!features.isEmpty()) {
                for (int i = 0; features.length() > i; i++) {
                    JSONObject feature = (JSONObject) features.get(i);
                    JSONObject properties = feature.getJSONObject("properties");
                    Regione regione = new Regione.RegioneBuilder().idRegione(properties.getInt("COD_REG")).codRegione(properties.getInt("COD_REG")).nomeRegione(properties.getString("DEN_REG")).geometria(String.valueOf(feature.getJSONObject("geometry"))).build();

                    regioneList.add(regione);

                }
            }
            System.out.println("ok");
        } catch (IOException ex) {
            ex.printStackTrace();
           throw  ex;

        }

        return regioneList;
    }

}
