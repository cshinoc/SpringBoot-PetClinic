package caseychen.springboot.springbootpetclinic.repositories;

import caseychen.springboot.springbootpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
