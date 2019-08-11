package caseychen.springboot.springbootpetclinic.repositories;

import caseychen.springboot.springbootpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
