package caseychen.springboot.springbootpetclinic.bootstrap;

import caseychen.springboot.springbootpetclinic.model.Owner;
import caseychen.springboot.springbootpetclinic.model.PetType;
import caseychen.springboot.springbootpetclinic.model.Vet;
import caseychen.springboot.springbootpetclinic.services.OwnerService;
import caseychen.springboot.springbootpetclinic.services.PetTypeService;
import caseychen.springboot.springbootpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {


        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Micheal");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Flona");
        owner2.setLastName("Glenanna");

        ownerService.save(owner2);

        System.out.println("Loaded Owenrs...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Zai");
        vet2.setLastName("Gou");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
