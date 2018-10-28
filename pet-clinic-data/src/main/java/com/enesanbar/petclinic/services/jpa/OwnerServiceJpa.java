package com.enesanbar.petclinic.services.jpa;

import com.enesanbar.petclinic.models.Owner;
import com.enesanbar.petclinic.repositories.OwnerRepository;
import com.enesanbar.petclinic.repositories.PetRepository;
import com.enesanbar.petclinic.repositories.PetTypeRepository;
import com.enesanbar.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerServiceJpa implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceJpa(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
         return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
