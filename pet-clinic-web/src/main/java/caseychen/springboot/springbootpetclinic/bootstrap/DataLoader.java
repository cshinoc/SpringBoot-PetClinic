package caseychen.springboot.springbootpetclinic.bootstrap;

import caseychen.springboot.springbootpetclinic.model.*;
import caseychen.springboot.springbootpetclinic.services.OwnerService;
import caseychen.springboot.springbootpetclinic.services.PetTypeService;
import caseychen.springboot.springbootpetclinic.services.SpecialitiesService;
import caseychen.springboot.springbootpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitiesService specialitiesService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialitiesService specialitiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRaiology = specialitiesService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialitiesService.save(surgery);


        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialitiesService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Micheal");
        owner1.setLastName("Weston");
        owner1.setAddress("123 test");
        owner1.setCity("SD");
        owner1.setTelephone("1234556");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("juju");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Flona");
        owner2.setLastName("Glenanna");
        owner2.setAddress("Teaofnea");
        owner2.setCity("SD");
        owner2.setTelephone("1234r425");

        Pet flonasPet = new Pet();
        flonasPet.setPetType(saveCatPetType);
        flonasPet.setOwner(owner2);
        flonasPet.setBirthDate(LocalDate.now());
        flonasPet.setName("gouzai");


        ownerService.save(owner2);

        System.out.println("Loaded Owenrs...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRaiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Zai");
        vet2.setLastName("Gou");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
