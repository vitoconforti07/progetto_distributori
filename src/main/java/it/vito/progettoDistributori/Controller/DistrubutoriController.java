package it.vito.progettoDistributori.Controller;

import it.vito.progettoDistributori.model.DistributoreDTO;
import it.vito.progettoDistributori.model.Point;
import it.vito.progettoDistributori.model.db.Comune;
import it.vito.progettoDistributori.Service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/distributori")
public class DistrubutoriController {

    Logger logger = Logger.getLogger(DistrubutoriController.class.getName());
    @Autowired
    PointService pointService;

    @GetMapping("/getComune")
    public ResponseEntity<List<Comune>> getComune(@RequestParam("lant") double lant, @RequestParam("lon") double lon,
                                                      @RequestParam(value = "distance", required = false) Double distance) throws IOException {

        distance = (distance == null) ? 5000 : distance * 1000;
        List<Comune> collect = pointService.getComuniInDistance(new Point(lant, lon), distance).stream().map(comune -> {
            comune.setGeometria(null);
            comune.setProvincia(null);
            return comune;
        }).collect(Collectors.toList());

        return new ResponseEntity(collect, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/getDistributori", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<DistributoreDTO>> getDistributori(@RequestParam("lant") double lant,
                                                                  @RequestParam("lon") double lon,
                                                                  @RequestParam(value = "distance", required = false) Double distance) {

        try {
            Point point = new Point(lon, lant);
            logger.info(point + " and distance " + distance);
            List<DistributoreDTO> listaDistrubori = pointService.getListaDistrubori(point, distance);

            return ResponseEntity.ok(listaDistrubori);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ResponseEntity(null, HttpStatus.CONFLICT);
        }

    }

}
