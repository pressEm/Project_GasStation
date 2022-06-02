package cs.vsu.ru.services;

import cs.vsu.ru.entities.GasStation;
import cs.vsu.ru.repository.GasStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GasStationService {
    GasStationRepository gasStationRepository;

    @Autowired
    public GasStationService(GasStationRepository gasStationRepository) {
        this.gasStationRepository = gasStationRepository;
    }
    public GasStation create(GasStation car){
        gasStationRepository.save(car);
        return car;
    }

    public List<GasStation> findAll(){
        List<GasStation> cars = null;
        cars = gasStationRepository.findAll();
        if (cars != null){
        }
        return cars;
    }

    public GasStation findById(int id){
        Optional<GasStation> gasStation = gasStationRepository.findById(id);
        if (gasStation.isPresent()){
            return gasStation.get();
        }
        return null;
    }

    public GasStation update(GasStation station){
        gasStationRepository.save(station);
        return station;
    }


    public void deleteById(int id){
        gasStationRepository.deleteById(id);
    }
}
