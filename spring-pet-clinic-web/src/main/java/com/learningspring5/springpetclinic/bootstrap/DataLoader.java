package com.learningspring5.springpetclinic.bootstrap;

import com.learningspring5.springpetclinic.model.*;
import com.learningspring5.springpetclinic.services.OwnerService;
import com.learningspring5.springpetclinic.services.PetTypeService;
import com.learningspring5.springpetclinic.services.SpecialtiesService;
import com.learningspring5.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;


    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService,SpecialtiesService specialtiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType= petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType= petTypeService.save(cat);

        Specialty radiology =  new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtiesService.save(radiology);

        Specialty surgery =  new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtiesService.save(surgery);

        Specialty dentistry =  new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtiesService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Anas");
        owner1.setLastName("PM");
        owner1.setAddress("123 street1");
        owner1.setCity("AE");
        owner1.setTelephone("123456");
        ownerService.save(owner1);

        Pet anasPet = new Pet();
        anasPet.setPetType(savedDogPetType);
        anasPet.setOwner(owner1);
        anasPet.setBirthDate(LocalDate.now());
        anasPet.setName("Kooi");
        owner1.getPets().add(anasPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mehjabeen");
        owner2.setLastName("Begum");
        owner2.setAddress("1234 street2");
        owner2.setCity("DXB");
        owner2.setTelephone("1234567");

        Pet mehjPet = new Pet();
        mehjPet.setPetType(savedCatPetType);
        mehjPet.setOwner(owner2);
        mehjPet.setBirthDate(LocalDate.now());
        mehjPet.setName("KooiCat");
        owner2.getPets().add(mehjPet);

        ownerService.save(owner2);

        System.out.println("Loaded owners data...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Fathima");
        vet1.setLastName("PA");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Noora");
        vet2.setLastName("PA");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded vet data...");
    }
}
