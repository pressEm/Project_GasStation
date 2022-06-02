package cs.vsu.ru.controllers;

import cs.vsu.ru.entities.Car;
import cs.vsu.ru.entities.Request;
import cs.vsu.ru.repository.CarRepository;
import cs.vsu.ru.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/requests")
public class RequestController {

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    private RequestService requestService;

    @GetMapping()
    ResponseEntity<List<Request>> findAll() {
        final  List<Request> requests = new ArrayList<>();
        requestService.findAll().forEach(request -> {
            requests.add(request);
        });
        System.out.println(requests.size());
        System.out.println(requests.get(0).toString());
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }


    @PostMapping()
    ResponseEntity<Request> add(@RequestBody Request request) {
        return new ResponseEntity<>(requestService.create(request),HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    ResponseEntity<Request> findById(@PathVariable(name = "id") int id) {
        System.out.println("id: " + id);
        Request c = requestService.findById(id);
        System.out.println(c);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        requestService.deleteById(id);
    }

    @PutMapping
    ResponseEntity<Request> update(@RequestBody Request customer){
        return new ResponseEntity<>(requestService.update(customer),HttpStatus.OK);
    }

}
