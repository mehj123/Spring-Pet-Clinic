package com.learningspring5.springpetclinic.bootstrap;

import com.learningspring5.springpetclinic.model.Owner;
import com.learningspring5.springpetclinic.model.PetType;
import com.learningspring5.springpetclinic.model.Vet;
import com.learningspring5.springpetclinic.services.OwnerService;
import com.learningspring5.springpetclinic.services.PetTypeService;
import com.learningspring5.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType= petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType= petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Anas");
        owner1.setLastName("PM");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mehjabeen");
        owner2.setLastName("Begum");

        ownerService.save(owner2);

        System.out.println("Loaded owners data...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Fathima");
        vet1.setLastName("PA");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Noora");
        vet2.setLastName("PA");

        vetService.save(vet2);

        System.out.println("Loaded vet data...");

    }
}
