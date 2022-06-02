package cs.vsu.ru.controllers;


import cs.vsu.ru.entities.Car;
import cs.vsu.ru.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    ResponseEntity<List<Car>> findAll() {
        final  List<Car> cars = new ArrayList<>();
        carService.findAll().forEach(request -> {
            cars.add(request);
        });
        System.out.println(cars.size());
        System.out.println(cars.get(0).toString());
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }


    @PostMapping()
    ResponseEntity<Car> add(@RequestBody Car car) {
        return new ResponseEntity<>(carService.create(car),HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    ResponseEntity<Car> findById(@PathVariable(name = "id") int id) {
        System.out.println("id: " + id);
        Car c = carService.findById(id);
        System.out.println(c);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        carService.deleteById(id);
    }

    @PutMapping
    ResponseEntity<Car> update(@RequestBody Car car){
        return new ResponseEntity<>(carService.update(car),HttpStatus.OK);
    }

}
