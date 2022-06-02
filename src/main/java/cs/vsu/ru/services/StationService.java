package cs.vsu.ru.services;

import cs.vsu.ru.entities.Station;
import cs.vsu.ru.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationService {
    StationRepository stationRepository;

    @Autowired
    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }


    public Station create(Station station) {
        stationRepository.save(station);
        return station;
    }

    public List<Station> findAll() {
        List<Station> stations = null;
        stations = stationRepository.findAll();
        if (stations != null) {
        }
        return stations;
    }

    public Station findById(int id) {
        Optional<Station> req = stationRepository.findById(id);
        if (req.isPresent()) {
            return req.get();
        }
        return null;
    }

    public Station update(Station station) {
        stationRepository.save(station);
        return station;
    }

    public void deleteById(int id) {
        stationRepository.deleteById(id);
    }

}
