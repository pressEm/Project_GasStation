package cs.vsu.ru.repository;

import cs.vsu.ru.entities.Request;
import cs.vsu.ru.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {
}
