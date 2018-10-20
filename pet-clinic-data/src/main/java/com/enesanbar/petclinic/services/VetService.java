package com.enesanbar.petclinic.services;

import com.enesanbar.petclinic.models.Pet;
import com.enesanbar.petclinic.models.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);
    
    Set<Vet> findAll();

}
