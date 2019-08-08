package caseychen.springboot.springbootpetclinic.bootstrap;

import caseychen.springboot.springbootpetclinic.model.Owner;
import caseychen.springboot.springbootpetclinic.model.Vet;
import caseychen.springboot.springbootpetclinic.services.OwnerService;
import caseychen.springboot.springbootpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

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
