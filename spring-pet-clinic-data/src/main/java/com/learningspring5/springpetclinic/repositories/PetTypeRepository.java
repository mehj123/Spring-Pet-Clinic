package com.learningspring5.springpetclinic.repositories;

import com.learningspring5.springpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
