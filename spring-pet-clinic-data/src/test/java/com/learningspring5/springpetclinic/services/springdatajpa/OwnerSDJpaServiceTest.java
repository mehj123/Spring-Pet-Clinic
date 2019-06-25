package com.learningspring5.springpetclinic.services.springdatajpa;

import com.learningspring5.springpetclinic.model.Owner;
import com.learningspring5.springpetclinic.repositories.OwnerRepository;
import com.learningspring5.springpetclinic.repositories.PetRepository;
import com.learningspring5.springpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void findByLastName() {
        String lastName = "Begum";
        Owner returnOwner = Owner.builder().id(1L).lastName(lastName).build();
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner begum = ownerSDJpaService.findByLastName(lastName);
        assertEquals(lastName, begum.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findById() {
        Long id = 1L;
        Owner returnOwner = Owner.builder().id(id).build();
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = ownerSDJpaService.findById(id);
        assertEquals(returnOwner.getId(), owner.getId());


    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(1L).build();
        Owner returnOwner = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner savedOwner = ownerSDJpaService.save(owner);

        assertEquals(savedOwner.getId(), returnOwner.getId());



    }

    @Test
    void findAll() {
        Set<Owner> ownersSet = new HashSet<>();
        ownersSet.add(Owner.builder().id(1L).build());
        ownersSet.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(ownersSet);

        Set<Owner> owners = ownerSDJpaService.findAll();
        assertEquals(owners.size(), ownersSet.size());
    }

    @Test
    void delete() {
    }


    @Test
    void deleteById() {
    }
}