package com.enesanbar.petclinic.bootstrap;

import com.enesanbar.petclinic.models.Owner;
import com.enesanbar.petclinic.models.PetType;
import com.enesanbar.petclinic.models.Vet;
import com.enesanbar.petclinic.services.OwnerService;
import com.enesanbar.petclinic.services.PetTypeService;
import com.enesanbar.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Micheal");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Enes");
        owner2.setLastName("Anbar");
        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("John");
        owner3.setLastName("Doe");
        ownerService.save(owner3);

        System.out.println("Loading Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Axl");
        vet2.setLastName("Rose");
        vetService.save(vet2);

        System.out.println("Loading Vets...");
    }

}
