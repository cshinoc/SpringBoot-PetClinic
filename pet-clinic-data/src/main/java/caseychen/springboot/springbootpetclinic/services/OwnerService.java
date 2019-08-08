package caseychen.springboot.springbootpetclinic.services;

import caseychen.springboot.springbootpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByLastName(String lastName);
    Owner findById(Long id);
    Owner save(Long id);
    Set<Owner> finaAll();

}