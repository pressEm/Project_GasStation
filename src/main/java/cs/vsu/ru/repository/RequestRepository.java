package cs.vsu.ru.repository;

import cs.vsu.ru.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
    Optional<Request> findById(int id);

    @Query(value = "SELECT c FROM Request c")
    List<Request> findAll();
}
