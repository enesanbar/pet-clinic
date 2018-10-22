package com.enesanbar.petclinic.bootstrap;

import com.enesanbar.petclinic.models.*;
import com.enesanbar.petclinic.services.OwnerService;
import com.enesanbar.petclinic.services.PetTypeService;
import com.enesanbar.petclinic.services.SpecialtyService;
import com.enesanbar.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final SpecialtyService specialtyService;
    private final PetTypeService petTypeService;

    public DataInitializer(OwnerService ownerService, VetService vetService, SpecialtyService specialtyService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.specialtyService = specialtyService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count == 0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Micheal");
        owner1.setLastName("Weston");
        owner1.setAddress("Aydinlar Mah.");
        owner1.setCity("Istanbul");
        owner1.setTelephone("123456");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");

        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Enes");
        owner2.setLastName("Anbar");
        owner2.setAddress("Kasimpasa");
        owner2.setCity("Istanbul");
        owner2.setTelephone("654321");
        ownerService.save(owner2);

        Pet enesCat = new Pet();
        enesCat.setPetType(savedCatType);
        enesCat.setOwner(owner2);
        enesCat.setBirthDate(LocalDate.now());
        enesCat.setName("Just Cat");
        owner2.getPets().add(enesCat);

        Owner owner3 = new Owner();
        owner3.setFirstName("John");
        owner3.setLastName("Doe");
        ownerService.save(owner3);

        System.out.println("Loading Owners...");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Axl");
        vet2.setLastName("Rose");
        vet2.getSpecialties().add(savedDentistry);
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loading Vets...");
    }

}
