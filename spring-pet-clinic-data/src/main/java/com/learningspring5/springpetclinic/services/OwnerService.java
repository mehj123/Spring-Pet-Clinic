package com.learningspring5.springpetclinic.services;


import com.learningspring5.springpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner,Long>{
    Owner findByLastName(String lastName);
}
