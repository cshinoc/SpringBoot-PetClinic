package caseychen.springboot.springbootpetclinic.services;

import caseychen.springboot.springbootpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> finaAll();
}