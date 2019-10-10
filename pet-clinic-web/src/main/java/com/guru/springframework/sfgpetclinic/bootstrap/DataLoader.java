package com.guru.springframework.sfgpetclinic.bootstrap;

import com.guru.springframework.sfgpetclinic.model.*;
import com.guru.springframework.sfgpetclinic.services.OwnerService;
import com.guru.springframework.sfgpetclinic.services.PetTypeService;
import com.guru.springframework.sfgpetclinic.services.SpecialtyService;
import com.guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0)
            loadData();


    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType dogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType catPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radioglogy");
        Speciality savedRadilogyy = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Waston");
        owner1.setAddress("Ben-Gurion 27");
        owner1.setCity("Tel-Aviv");
        owner1.setTelephone("03-9753040");
        ownerService.save(owner1);

        Pet mikePet = new Pet();
        mikePet.setPetType(dogPetType);
        mikePet.setBirthDate(LocalDate.now());
        mikePet.setName("luna");
        mikePet.setOwner(owner1);

        owner1.getPets().add(mikePet);


        Owner owner2 = new Owner();
        owner2.setFirstName("Fionna");
        owner2.setLastName("Glene");

        ownerService.save(owner2);
        System.out.println("Loaded owners...");


        Pet FionnaPet = new Pet();
        mikePet.setPetType(catPetType);
        mikePet.setBirthDate(LocalDate.now());
        mikePet.setName("mars");
        mikePet.setOwner(owner2);


        Vet vet1 = new Vet();
        vet1.setFirstName("dr.eric");
        vet1.setLastName("cohen");

        vetService.save(vet1);
        vet1.getSpecialities().add(radiology);

        Vet vet2 = new Vet();
        vet2.setFirstName("dr.moshe");
        vet2.setLastName("levi");
        owner1.setAddress("Ben-Gurion 227");
        owner1.setCity("Tel-Aviv");
        owner1.setTelephone("03-9773040");
        vetService.save(vet2);
        vet2.getSpecialities().add(surgery);
        vet2.getSpecialities().add(dentistry);

        System.out.println("Loaded vets...");
    }
}
