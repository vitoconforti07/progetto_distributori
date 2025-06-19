//package it.vito.Progetto_distributori;
//
//import it.vito.Progetto_distributori.Model.Point;
//import it.vito.Progetto_distributori.Model.db.Comune;
//import it.vito.Progetto_distributori.Service.PointService;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@RunWith(SpringRunner.class)
//@TestPropertySource(locations = "classpath:application.yaml")
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ProgettoDistributoriApplicationTests.class)
//class ProgettoDistributoriApplicationTests {
//
//    private final String pathFile = "C:\\Users\\V.Conforti\\Desktop\\Progetto_distributori\\punti_comuni.csv";
//    @Autowired
//    private PointService pointService;
//
//    @Test
//    @DisplayName("Test avviato")
//    void test(String pathFile) throws IOException {
//        List<Boolean> booleanList = new ArrayList<>();
//        Set<PuntoInComune> puntoInComuneSet = extracPuntoInComuni(pathFile);
//        for (PuntoInComune puntoInComune : puntoInComuneSet) {
//            Point point = new Point(puntoInComune.getLantPunto(), puntoInComune.getLonPunto());
//            Comune comuneInpoint = pointService.getComuneInpoint(point);
//            booleanList.add(comuneInpoint.getIdComune() == puntoInComune.getId_regione());
//
//        }
//        boolean b = booleanList.stream().allMatch(aBoolean -> aBoolean);
//        Assert.assertTrue(b);
//    }
//
//    private Set<PuntoInComune> extracPuntoInComuni(String pathFile) throws IOException {
//
//        Path path = Paths.get(pathFile);
//        Set<PuntoInComune> puntoInComuneSet = new HashSet<>();
//        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
//
//            reader.readLine();
//            while (reader.readLine() != null) {
//                String[] split = reader.toString().split(",");
//
//                PuntoInComune puntoInComune = new PuntoInComune();
//                puntoInComune.setId_regione(Integer.valueOf(split[0]));
//                puntoInComune.setCod_regione(Integer.valueOf(split[1]));
//                puntoInComune.setNome_regione(String.valueOf(split[2]));
//                puntoInComune.setLantPunto(Double.valueOf(split[3]));
//                puntoInComune.setLonPunto(Double.valueOf(split[4]));
//                puntoInComuneSet.add(puntoInComune);
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return puntoInComuneSet;
//    }
//}