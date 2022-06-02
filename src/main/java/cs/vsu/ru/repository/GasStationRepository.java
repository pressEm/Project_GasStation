package cs.vsu.ru.repository;

import cs.vsu.ru.entities.GasStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GasStationRepository extends JpaRepository<GasStation, Integer> {
}
