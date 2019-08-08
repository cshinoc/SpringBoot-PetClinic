package caseychen.springboot.springbootpetclinic.services;

import caseychen.springboot.springbootpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}