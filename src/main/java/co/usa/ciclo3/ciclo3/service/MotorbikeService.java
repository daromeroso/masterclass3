package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Motorbike;
import co.usa.ciclo3.ciclo3.repository.MotorbikeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotorbikeService {
    
    @Autowired
    private MotorbikeRepository motorbikeRepository;
    
    public List<Motorbike> getAll(){
        return motorbikeRepository.getAll();
    }
    
    public Optional<Motorbike> getMotorbike(int id){
        return motorbikeRepository.getMotorbike(id);
    }
    
    public Motorbike save(Motorbike p){
        if(p.getId()==null){
            return motorbikeRepository.save(p);            
        }else{
            Optional<Motorbike> paux=motorbikeRepository.getMotorbike(p.getId());
            if(paux.isEmpty()){
                return motorbikeRepository.save(p); 
            }else{
                return p;
            }
        }
    }
}
