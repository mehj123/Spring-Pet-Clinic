package com.learningspring5.springpetclinic.services;


import java.util.Set;

public interface CrudService <T, ID> {

    T findById(ID id);
    T save(T object);
    Set<T> findAll();
    void delete(T Object);
    void deleteById(ID id);
}
