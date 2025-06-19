package it.vito.progettoDistributori.Service;

import it.vito.progettoDistributori.model.DistributoreDTO;
import it.vito.progettoDistributori.model.DistributoreForInsertDTO;
import it.vito.progettoDistributori.model.Point;
import it.vito.progettoDistributori.model.PrezzoDTO;
import it.vito.progettoDistributori.model.db.*;
import it.vito.progettoDistributori.Repository.*;
import it.vito.progettoDistributori.Util.UtilsPoint;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class PointService {

    public static final String PUNTO_AL_DI_FUORI_DEL_TERRITORIO_NAZIONALE = "Punto al di fuori del territorio nazionale";
    Logger logger = Logger.getLogger(PointService.class.getName());

    @Autowired
    private RegioneRepository regioneRepository;

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Autowired
    private ComuneRepository comuneRepository;
    @Autowired
    private DistributoreRepository distributoreRepository;

    @Autowired
    private PrezziRepository prezziRepository;


    private static Double[] distanze(double distanza, int N) {

        Double[] distanze = new Double[N];
        for (int i = 1; N >= i; i++) {
            distanze[i - 1] = distanza * ((double) i / (double) N);
        }
        return distanze;
    }

    public List<DistributoreDTO> getListaDistrubori(Point point, Double distanza) {
        distanza = (distanza == null) ? 5000 : distanza * 1000;
        logger.info("Avvio procedura");
        List<Distributore> distributori = new ArrayList<>();

        getComuniInDistance(point, distanza).forEach(comune -> {
            List<Distributore> distributoriByIdComune = distributoreRepository.findDistributoriByIdComune(comune.getIdComune());

            distributori.addAll(distributoriByIdComune);
        });

        Double finalDistanza = distanza;
        List<DistributoreDTO> distributoreDTOS = distributori.stream().map(distributore -> {
            DistributoreDTO distributoreDTO = new DistributoreDTO();
            distributoreDTO.setIdImpianto(distributore.getIdImpianto());
            distributoreDTO.setGestore(distributore.getGestore());
            distributoreDTO.setBandiera(distributore.getBandiera());
            distributoreDTO.setTipoImpianto(distributore.getTipoImpianto());
            distributoreDTO.setNomeImpianto(distributore.getNomeImpianto());
            distributoreDTO.setIndirizzo(distributore.getIndirizzo());
            distributoreDTO.setComune(distributore.getComune().getNomeComune());
            distributoreDTO.setProvincia(distributore.getComune().getProvincia().getSiglaProvincia());
            distributoreDTO.setLatitudine(distributore.getLatitudine());
            distributoreDTO.setLongitudine(distributore.getLongitudine());
            double d = UtilsPoint.calculateDistanceBetweenPointsFromHaversineFormula(new Point(point.getY(), point.getX()), new Point(distributore.getLatitudine(), distributore.getLongitudine()));

            distributoreDTO.setDistanza(BigDecimal.valueOf(d * 1000).setScale(1, RoundingMode.HALF_UP).doubleValue());
            return distributoreDTO;
        }).filter(distributore -> distributore.getDistanza() <= finalDistanza).collect(Collectors.toList());


        for (DistributoreDTO dto : distributoreDTOS) {
            List<Prezzo> prezziFromImpianto = prezziRepository.getPrezziFromImpianto(dto.getIdImpianto());
            List<PrezzoDTO> collect = prezziFromImpianto.stream().map(prezzo -> {
                PrezzoDTO prezzoDTO = new PrezzoDTO();
                prezzoDTO.setDescCarburante(prezzo.getDescCarburante());
                prezzoDTO.setPrezzo(prezzo.getPrezzo());
                prezzoDTO.setSelf(prezzo.getSelf());
                prezzoDTO.setDtComu(prezzo.getDtComu());
                return prezzoDTO;
            }).sorted(Comparator.comparing(PrezzoDTO::getPrezzo)).collect(Collectors.toList());

            dto.setPrezzi(collect);
        }
        return distributoreDTOS.stream().sorted(Comparator.comparing(DistributoreDTO::getDistanza)).collect(Collectors.toList());

    }

    public List<Comune> getComuniInDistance(Point point, double distanza) {
        List<Comune> comuni = new ArrayList<>();


        Comune comuneInpointPrincipale = getComuneInpoint(point);

         if(comuneInpointPrincipale == null){
             throw new RuntimeException(PUNTO_AL_DI_FUORI_DEL_TERRITORIO_NAZIONALE);
         }else {
             comuni.add(comuneInpointPrincipale);

             List<Point> points = pointsInCircles(point, distanza);

             for (Point pointConfinanti : points) {
                 Comune comuneInpoint = getComuneInpoint(pointConfinanti);
                 Predicate<Comune> comunePredicate = comune -> Objects.equals(comune.getIdComune(), comuneInpoint.getIdComune());

                 if (comuni.stream().noneMatch(comunePredicate)) comuni.add(comuneInpoint);
             }
             comuni.removeAll(Collections.singleton(null));

             return comuni;
         }
    }

    public List<Point> pointsInCircles(Point centerPoint, double distanza) {
        return Arrays.asList(distanze(distanza, (int) (distanza / 500D))).stream().map(d -> UtilsPoint.pointsFromCenter(centerPoint, d)).flatMap(Collection::stream).collect(Collectors.toList());
    }

    public Comune getComuneInpoint(Point point) {
        try {
            Optional<Regione> regioneInPointOp = getRegioneInPoint(point);
            Regione regioneInPoint = regioneInPointOp.orElseThrow(() -> new RuntimeException(PUNTO_AL_DI_FUORI_DEL_TERRITORIO_NAZIONALE));

            Optional<Provincia> provinciaInPointFromRegioneOp = getProvinciaInPointFromRegione(point, regioneInPoint);
            Optional<Comune> comuneInPointFromProvinciaOp = getComuneInPointFromProvincia(point, provinciaInPointFromRegioneOp.orElseThrow(() -> new RuntimeException(PUNTO_AL_DI_FUORI_DEL_TERRITORIO_NAZIONALE)));

            return comuneInPointFromProvinciaOp.orElseThrow(() -> new RuntimeException(PUNTO_AL_DI_FUORI_DEL_TERRITORIO_NAZIONALE));
        } catch (Exception e) {
            return null;
        }
    }

    private Optional<Regione> getRegioneInPoint(Point point) {

        List<Regione> regioneAllList = regioneRepository.findAll();

        for (Regione regione : regioneAllList) {
            boolean isPoligono = pointInMultiPolygon(point, regione.getGeometria());
            if (isPoligono) {
                return Optional.of(regione);
            }
        }
        return Optional.empty();
    }

    private Optional<Provincia> getProvinciaInPointFromRegione(Point point, Regione regione) {

        List<Provincia> provinciaListListFromRegione = provinciaRepository.getProvinciaFromRegione(regione.getNomeRegione());

        for (Provincia provincia : provinciaListListFromRegione) {
            boolean isPoligono = pointInMultiPolygon(point, provincia.getGeometria());
            if (isPoligono) {
                return Optional.of(provincia);
            }
        }
        return Optional.empty();
    }

    private Optional<Comune> getComuneInPointFromProvincia(Point point, Provincia provincia) {

        List<Comune> comuneListListFromProvincia = comuneRepository.getComuneFromProvincia(provincia.getNomeProvincia());

        for (Comune comune : comuneListListFromProvincia) {

            boolean isPoligono = pointInMultiPolygon(point, comune.getGeometria());
            if (isPoligono) {
                return Optional.of(comune);
            }
        }
        return Optional.empty();
    }

    private boolean pointInMultiPolygon(Point point, String geoJson) {

        JSONObject jsonObject = new JSONObject(geoJson);
        JSONArray coordinates = jsonObject.getJSONArray("coordinates");
        List<List<Point>> poligoni = new ArrayList<>();
        extractGeomety(coordinates, poligoni);
        poligoni.removeAll(Collections.singleton(null));

        boolean b = poligoni.stream().anyMatch(poligono -> UtilsPoint.pointInPolygon(point, poligono));
        boolean b1 = poligoni.stream().map(poligono -> UtilsPoint.pointInPolygon(point, poligono)).filter(aBoolean -> aBoolean).count() % 2 != 0;
        return b && b1;
    }

    private List<Point> extractGeomety(JSONArray jsonArray, List<List<Point>> poligoni) {

        if (jsonArray.getJSONArray(0).length() == 2 && (jsonArray.getJSONArray(0).get(0) instanceof BigDecimal)) {
            List<Point> poligono = new ArrayList<>();
            for (int i = 0; jsonArray.length() > i; i++) {
                JSONArray jsonArray1 = jsonArray.getJSONArray(i);
                poligono.add(new Point(jsonArray1.getDouble(0), jsonArray1.getDouble(1)));

            }
            return poligono;
        } else {
            for (int i = 0; jsonArray.length() > i; i++) {
                JSONArray jsonArray1 = jsonArray.getJSONArray(i);
                List<Point> poligono = extractGeomety(jsonArray1, poligoni);
                poligoni.add(poligono);
            }
            return null;
        }
    }


    public void insertDistributori() {

        Path path = Paths.get("C:\\Users\\V.Conforti\\Desktop\\Progetto_distributori\\anagrafica_impianti_attivi.csv");

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                Distributore distributore = new Distributore();
                try {


                    String[] celle = line.split(";");

                    DistributoreForInsertDTO distributoreForInsertDTO = new DistributoreForInsertDTO.DistributoreDTOBuilder().idImpianto(Integer.valueOf(celle[0])).gestore(String.valueOf(celle[1])).bandiera(String.valueOf(celle[2])).tipoImpianto(String.valueOf(celle[3])).nomeImpianto(String.valueOf(celle[4])).indirizzo(String.valueOf(celle[5])).comune(String.valueOf(celle[6])).provincia(String.valueOf(celle[7])).latitudine((celle[8].equalsIgnoreCase("null") || celle[8].isEmpty() || celle[8].isBlank()) ? null : Double.valueOf(celle[8])).longitudine((celle[9].equalsIgnoreCase("null") || celle[9].isEmpty() || celle[9].isBlank()) ? null : Double.valueOf(celle[9])).build();


                    distributore.setCodImpianto(distributoreForInsertDTO.getIdImpianto());
                    distributore.setGestore(distributoreForInsertDTO.getGestore());
                    distributore.setBandiera(distributoreForInsertDTO.getBandiera());
                    distributore.setTipoImpianto(distributoreForInsertDTO.getTipoImpianto());
                    distributore.setNomeImpianto(distributoreForInsertDTO.getNomeImpianto());
                    distributore.setIndirizzo(distributoreForInsertDTO.getIndirizzo());
                    distributore.setLatitudine(distributoreForInsertDTO.getLatitudine());
                    distributore.setLongitudine(distributoreForInsertDTO.getLongitudine());

                    Comune comuneInpoint = getComuneInpoint(new Point(distributoreForInsertDTO.getLongitudine(), distributoreForInsertDTO.getLatitudine()));
                    distributore.setComune(comuneInpoint);

                    distributoreRepository.saveAndFlush(distributore);

                } catch (Exception e) {
                    System.out.println(distributore);
                    System.out.println(e.getMessage());

                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
