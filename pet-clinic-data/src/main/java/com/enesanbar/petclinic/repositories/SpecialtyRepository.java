package com.enesanbar.petclinic.repositories;

import com.enesanbar.petclinic.models.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
