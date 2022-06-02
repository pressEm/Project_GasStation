package cs.vsu.ru.services;


import cs.vsu.ru.entities.Owner;
import cs.vsu.ru.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    OwnerRepository ownerRepository;

    public Owner create(Owner owner){
        ownerRepository.save(owner);
        return owner;
    }

    public List<Owner> findAll(){
        List<Owner> cars = null;
        cars = ownerRepository.findAll();
        if (cars != null){
        }
        return cars;
    }

    public Owner findById(int id){
        Optional<Owner> owner = ownerRepository.findById(id);
        if (owner.isPresent()){
            return owner.get();
        }
        return null;
    }

    public Owner update(Owner owner){
        ownerRepository.save(owner);
        return owner;
    }


    public void deleteById(int id){
        ownerRepository.deleteById(id);
    }

}
