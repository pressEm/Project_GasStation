package cs.vsu.ru.repository;

import cs.vsu.ru.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.RequestEntity;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
