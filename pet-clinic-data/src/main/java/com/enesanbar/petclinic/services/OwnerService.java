package com.enesanbar.petclinic.services;

import com.enesanbar.petclinic.models.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

}
