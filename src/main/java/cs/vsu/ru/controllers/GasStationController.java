package cs.vsu.ru.controllers;


import cs.vsu.ru.entities.GasStation;
import cs.vsu.ru.services.GasStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("gasStations")
public class GasStationController {
    GasStationService gasStationService;

    @Autowired
    public GasStationController(GasStationService gasStationService) {
        this.gasStationService = gasStationService;
    }

    @GetMapping()
    ResponseEntity<List<GasStation>> findAll() {
        final  List<GasStation> cars = new ArrayList<>();
        gasStationService.findAll().forEach(request -> {
            cars.add(request);
        });
        System.out.println(cars.size());
        System.out.println(cars.get(0).toString());
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }


    @PostMapping()
    ResponseEntity<GasStation> add(@RequestBody GasStation gasStation) {
        return new ResponseEntity<>(gasStationService.create(gasStation),HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    ResponseEntity<GasStation> findById(@PathVariable(name = "id") int id) {
        System.out.println("id: " + id);
        GasStation c = gasStationService.findById(id);
        System.out.println(c);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        gasStationService.deleteById(id);
    }

    @PutMapping
    ResponseEntity<GasStation> update(@RequestBody GasStation gasStation){
        return new ResponseEntity<>(gasStationService.update(gasStation),HttpStatus.OK);
    }

}
