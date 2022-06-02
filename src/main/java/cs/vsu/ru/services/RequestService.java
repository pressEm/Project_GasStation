package cs.vsu.ru.services;

import cs.vsu.ru.entities.Request;
import cs.vsu.ru.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {
    RequestRepository requestRepository;

//    public RequestService() {
//    }

    @Autowired
    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Request create(Request req) {
        requestRepository.save(req);
        return req;
    }

    public List<Request> findAll() {
        List<Request> requestEntities = null;
        requestEntities = requestRepository.findAll();
        if (requestEntities != null) {
        }
        return requestEntities;
    }

    public Request findById(int id) {
        Optional<Request> req = requestRepository.findById(id);
        if (req.isPresent()) {
            return req.get();
        }
        return null;
    }

    public Request update(Request req) {
        requestRepository.save(req);
        return req;
    }

    public void deleteById(int id) {
        requestRepository.deleteById(id);
    }

}
