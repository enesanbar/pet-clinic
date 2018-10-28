package com.enesanbar.petclinic.repositories;

import com.enesanbar.petclinic.models.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
