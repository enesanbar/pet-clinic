package com.enesanbar.petclinic.repositories;

import com.enesanbar.petclinic.models.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
