package com.learningspring5.springpetclinic.services;


import com.learningspring5.springpetclinic.model.Owner;

import java.util.List;


public interface OwnerService extends CrudService<Owner,Long>{
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
