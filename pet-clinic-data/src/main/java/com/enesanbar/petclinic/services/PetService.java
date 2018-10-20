package com.enesanbar.petclinic.services;

import com.enesanbar.petclinic.models.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);
    
    Set<Pet> findAll();

}
