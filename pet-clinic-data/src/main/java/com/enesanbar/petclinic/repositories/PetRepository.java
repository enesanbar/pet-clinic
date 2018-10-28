package com.enesanbar.petclinic.repositories;

import com.enesanbar.petclinic.models.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
