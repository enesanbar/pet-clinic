package com.enesanbar.petclinic.bootstrap;

import com.enesanbar.petclinic.models.Owner;
import com.enesanbar.petclinic.models.Vet;
import com.enesanbar.petclinic.services.OwnerService;
import com.enesanbar.petclinic.services.VetService;
import com.enesanbar.petclinic.services.map.OwnerServiceMap;
import com.enesanbar.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataInitializer() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Micheal");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Enes");
        owner2.setLastName("Anbar");

        ownerService.save(owner2);

        System.out.println("Loading Owners...");

        Vet owner3 = new Vet();
        owner3.setId(1L);
        owner3.setFirstName("Sam");
        owner3.setLastName("Axe");

        vetService.save(owner3);

        Vet owner4 = new Vet();
        owner4.setId(2L);
        owner4.setFirstName("Axl");
        owner4.setLastName("Rose");

        vetService.save(owner4);

        System.out.println("Loading Vets...");
    }

}
