package com.learningspring5.springpetclinic.services;

import com.learningspring5.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet owner);
    Set<Vet> findAll();
}
