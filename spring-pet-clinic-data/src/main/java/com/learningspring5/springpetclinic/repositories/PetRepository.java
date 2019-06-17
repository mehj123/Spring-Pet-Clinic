package com.learningspring5.springpetclinic.repositories;

import com.learningspring5.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
