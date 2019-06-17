package com.learningspring5.springpetclinic.repositories;

import com.learningspring5.springpetclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
