import Model.Model.Oggetto;
import Model.Model.Point;
import Model.Model.PuntoInComune;
import Model.Model.db.Comune;
import com.google.gson.Gson;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProgettoDistributoriTestApplication {


    public static void main(String[] args) throws IOException {
        String pathFile = "C:\\Users\\V.Conforti\\Desktop\\Progetto_distributori\\punti_comuni.csv";
        List<Oggetto> booleanList = new ArrayList<>();

        try {


            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(List.of(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<String>(headers);


            List<PuntoInComune> puntoInComuneSet = extracPuntoInComuni(pathFile);
            for (PuntoInComune puntoInComune : puntoInComuneSet) {
                Point point = new Point(puntoInComune.getLantPunto(), puntoInComune.getLonPunto());

                String url = "http://localhost:8080/distributori/getComune?lon=" + point.getY() + "&lant=" + point.getX();
                ResponseEntity<Comune> response = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<Comune>() {
                });
                Comune comuneFromResponse = response.getBody();
//                comuneFromResponse.setIdComune(comuneFromResponse.getIdComune() == null ? comuneFromResponse.getIdComune() : 0);

                Oggetto confronto = new Oggetto(comuneFromResponse, puntoInComune, comuneFromResponse.getIdComune().equals(puntoInComune.getId_Comune()));
//                Object[] confronto = {comuneFromResponse, puntoInComune, comuneFromResponse.getIdComune().equals(puntoInComune.getId_regione())};

                booleanList.add(confronto);
//                if (booleanList.size() == 1000){
//                    break;
//                }
            }
            boolean b = booleanList.stream().allMatch(oggetto -> oggetto.getFlag());
            List<String> oggetti = booleanList.stream().
                    filter(oggetto -> !oggetto.getFlag()).
                    map(oggetto -> oggetto.getComune().getIdComune().toString() + ","
                            + oggetto.getComune().getCodComune().toString() + ","
                            + oggetto.getComune().getNomeComune() + ","
                            + oggetto.getPuntoInComune().getId_Comune().toString() + ","
                            + oggetto.getPuntoInComune().getCodComune().toString() + ","
                            + oggetto.getPuntoInComune().getNomeComune() + ","
                            + oggetto.getPuntoInComune().getLonPunto().toString() + ","
                            + oggetto.getPuntoInComune().getLantPunto().toString() + "\n").collect(Collectors.toList());
            Gson gson = new Gson();
            String json = gson.toJson(oggetti);
            String comuneString = Arrays.stream(Comune.class.getDeclaredFields()).map(field -> field.getName()).collect(Collectors.joining(","));
            String puntoInComuneString = Arrays.stream(PuntoInComune.class.getDeclaredFields()).map(field -> field.getName()).collect(Collectors.joining(","));
            String csv = oggetti.stream().map(riga -> riga.toString()).reduce("", String::concat);
            csv = comuneString +"," + puntoInComuneString +"\n" +csv;
//            String line = oggetti.stream().map(objects -> String.valueOf(objects[1])).collect(Collectors.joining("\n"));
            Path path = Paths.get("C:\\Users\\V.Conforti\\Desktop\\punto_non_buoni.csv");
            Files.writeString(path, csv, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("ok");
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("ok");

        }
    }


    private static List<PuntoInComune> extracPuntoInComuni(String pathFile) throws IOException {

        Path path = Paths.get(pathFile);
        List<PuntoInComune> puntoInComuneSet = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line = null;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",");

                PuntoInComune puntoInComune = new PuntoInComune();
                puntoInComune.setId_Comune(Integer.valueOf(split[0]));
                puntoInComune.setCodComune(Integer.valueOf(split[1]));
                puntoInComune.setNomeComune(String.valueOf(split[2]));
                puntoInComune.setLantPunto(Double.valueOf(split[3]));
                puntoInComune.setLonPunto(Double.valueOf(split[4]));
                puntoInComuneSet.add(puntoInComune);
            }
            return puntoInComuneSet;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
