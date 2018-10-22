package com.enesanbar.petclinic.bootstrap;

import com.enesanbar.petclinic.models.Owner;
import com.enesanbar.petclinic.models.Pet;
import com.enesanbar.petclinic.models.PetType;
import com.enesanbar.petclinic.models.Vet;
import com.enesanbar.petclinic.services.OwnerService;
import com.enesanbar.petclinic.services.PetTypeService;
import com.enesanbar.petclinic.services.VetService;
import org.apache.tomcat.jni.Local;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
