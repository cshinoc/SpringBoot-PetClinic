package caseychen.springboot.springbootpetclinic.repositories;

import caseychen.springboot.springbootpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
