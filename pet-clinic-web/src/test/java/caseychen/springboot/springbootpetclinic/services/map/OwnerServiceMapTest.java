package caseychen.springboot.springbootpetclinic.services.map;

import caseychen.springboot.springbootpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long ownerID = 1L;
    final String lastName = "JuJu";

    @BeforeEach
    void setUp() {

        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());

        ownerServiceMap.save(Owner.builder().id(ownerID).lastName(lastName).build());

    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();

        assertEquals(1,ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerID);

        assertEquals(ownerID, owner.getId());
    }

    @Test
    void saveExistingId() {

        Long id = 2L;

        Owner owner2 = Owner.builder().id(id).build();

        Owner savedOwner = ownerServiceMap.save(owner2);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {

        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {

         ownerServiceMap.delete(ownerServiceMap.findById(ownerID));

         assertEquals(0,ownerServiceMap.findAll().size());

    }

    @Test
    void deleteById() {

        ownerServiceMap.deleteById(ownerID);

        assertEquals(0, ownerServiceMap.findAll().size());

    }

    @Test
    void findByLastName() {

        Owner juju = ownerServiceMap.findByLastName(lastName);

        assertNotNull(juju);

        assertEquals(ownerID, juju.getId());
    }

    @Test
    void findByLastNameNotFound() {

        Owner juju = ownerServiceMap.findByLastName("foo");

        assertNull(juju);

    }
}