package com.learningspring5.springpetclinic.repositories;

import com.learningspring5.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
