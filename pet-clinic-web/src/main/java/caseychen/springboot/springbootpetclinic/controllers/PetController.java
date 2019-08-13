package caseychen.springboot.springbootpetclinic.controllers;

import caseychen.springboot.springbootpetclinic.model.Owner;
import caseychen.springboot.springbootpetclinic.model.Pet;
import caseychen.springboot.springbootpetclinic.model.PetType;
import caseychen.springboot.springbootpetclinic.services.OwnerService;
import caseychen.springboot.springbootpetclinic.services.PetService;
import caseychen.springboot.springbootpetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private static final String VIEWS_PET_CREATE_OR_UPDATE = "pets/createOrUpdatePetForm";

    private final PetService petService;
    private final PetTypeService petTypeService;
    private final OwnerService ownerService;

    public PetController(PetService petService, PetTypeService petTypeService, OwnerService ownerService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.ownerService = ownerService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException{
                setValue(LocalDate.parse(text));
            }
        });
    }

    @GetMapping("pets/new")
    public String initCreationForm(Owner owner, Model model) {
        Pet pet = Pet.builder().build();
        owner.getPets().add(pet);
        pet.setOwner(owner);
        model.addAttribute("pet", pet);
        model.addAttribute("petTypes", petTypeService.findAll());

        return VIEWS_PET_CREATE_OR_UPDATE;
    }

    @PostMapping("pets/new")
    public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult bindingResult,
                                      Model model) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew()
                && owner.getPet(pet.getName(), true) != null) {
            bindingResult.rejectValue("name", "duplicate", "alreadyExists");
        }
        owner.getPets().add(pet);
        pet.setOwner(owner);

        if (bindingResult.hasErrors()) {
            model.addAttribute("pet", pet);
            return VIEWS_PET_CREATE_OR_UPDATE;
        } else {
            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable Long petId, Model model) {
        model.addAttribute("pet", petService.findById(petId));
        return VIEWS_PET_CREATE_OR_UPDATE;
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(@Valid Pet pet, BindingResult bindingResult,
                                    Owner owner, Model model) {
        if (bindingResult.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return VIEWS_PET_CREATE_OR_UPDATE;
        } else {
            owner.getPets().add(pet);
            pet.setOwner(owner);
            petService.save(pet);

            return "redirect:/owners/" + owner.getId();
        }
    }
}