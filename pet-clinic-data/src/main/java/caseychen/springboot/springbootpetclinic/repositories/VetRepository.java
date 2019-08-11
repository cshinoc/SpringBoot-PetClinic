package caseychen.springboot.springbootpetclinic.repositories;

import caseychen.springboot.springbootpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
