package caseychen.springboot.springbootpetclinic.repositories;

import caseychen.springboot.springbootpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
