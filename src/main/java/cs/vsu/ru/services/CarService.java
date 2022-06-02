package cs.vsu.ru.services;

import cs.vsu.ru.entities.Car;
import cs.vsu.ru.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car create(Car car){
        carRepository.save(car);
        return car;
    }

    public List<Car> findAll(){
        List<Car> cars = null;
        cars = carRepository.findAll();
        if (cars != null){
        }
        return cars;
    }

    public Car findById(int id){
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()){
            return car.get();
        }
        return null;
    }

    public Car update(Car car){
        carRepository.save(car);
        return car;
    }


    public void deleteById(int id){
        carRepository.deleteById(id);
    }
}
