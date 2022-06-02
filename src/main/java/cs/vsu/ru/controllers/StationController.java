package cs.vsu.ru.controllers;


import cs.vsu.ru.entities.Station;
import cs.vsu.ru.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {
    StationService stationService;

    @Autowired
    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping()
    ResponseEntity<List<Station>> findAll() {
        final  List<Station> stations = new ArrayList<>();
        stationService.findAll().forEach(request -> {
            stations.add(request);
        });
        System.out.println(stations.size());
        System.out.println(stations.get(0).toString());
        return new ResponseEntity<>(stations, HttpStatus.OK);
    }


    @PostMapping()
    ResponseEntity<Station> add(@RequestBody Station request) {
        return new ResponseEntity<>(stationService.create(request),HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    ResponseEntity<Station> findById(@PathVariable(name = "id") int id) {
        System.out.println("id: " + id);
        Station c = stationService.findById(id);
        System.out.println(c);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        stationService.deleteById(id);
    }

    @PutMapping
    ResponseEntity<Station> update(@RequestBody Station customer){
        return new ResponseEntity<>(stationService.update(customer),HttpStatus.OK);
    }

}
