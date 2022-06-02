package cs.vsu.ru.controllers;


import cs.vsu.ru.entities.Owner;
import cs.vsu.ru.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping()
    ResponseEntity<List<Owner>> findAll() {
        final  List<Owner> cars = new ArrayList<>();
        ownerService.findAll().forEach(request -> {
            cars.add(request);
        });
        System.out.println(cars.size());
        System.out.println(cars.get(0).toString());
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }


    @PostMapping()
    ResponseEntity<Owner> add(@RequestBody Owner car) {
        return new ResponseEntity<>(ownerService.create(car),HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    ResponseEntity<Owner> findById(@PathVariable(name = "id") int id) {
        System.out.println("id: " + id);
        Owner c = ownerService.findById(id);
        System.out.println(c);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        ownerService.deleteById(id);
    }

    @PutMapping
    ResponseEntity<Owner> update(@RequestBody Owner car){
        return new ResponseEntity<>(ownerService.update(car),HttpStatus.OK);
    }

}
