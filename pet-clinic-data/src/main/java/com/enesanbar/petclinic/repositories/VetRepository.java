package com.enesanbar.petclinic.repositories;

import com.enesanbar.petclinic.models.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
