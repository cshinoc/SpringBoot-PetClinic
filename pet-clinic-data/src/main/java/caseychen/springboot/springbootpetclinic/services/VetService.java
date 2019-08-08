package caseychen.springboot.springbootpetclinic.services;

import caseychen.springboot.springbootpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Long id);
    Set<Vet> finaAll();
}