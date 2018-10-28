package com.enesanbar.petclinic.repositories;

import com.enesanbar.petclinic.models.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
