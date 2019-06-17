package com.learningspring5.springpetclinic.services.map;

import com.learningspring5.springpetclinic.model.Visit;
import com.learningspring5.springpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VisitMapService extends AbstractMapService<Visit,Long> implements VisitService {
    
    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit object) {
        if(object.getPet() == null || object.getPet().getOwner() == null
        || object.getPet().getId() ==null || object.getPet().getOwner().getId() == null){
            throw new RuntimeException("Invalid visit");
        }
        return super.save(object);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Visit Object) {
        super.delete(Object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
