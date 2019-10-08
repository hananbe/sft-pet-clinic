package com.guru.springframework.sfgpetclinic.bootstrap;

import com.guru.springframework.sfgpetclinic.model.Owner;
import com.guru.springframework.sfgpetclinic.model.PetType;
import com.guru.springframework.sfgpetclinic.model.Vet;
import com.guru.springframework.sfgpetclinic.services.OwnerService;
import com.guru.springframework.sfgpetclinic.services.PetTypeService;
import com.guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Waston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fionna");
        owner2.setLastName("Glene");

        ownerService.save(owner2);
        System.out.println("Loaded owners...");


        Vet vet1 = new Vet();
        vet1.setFirstName("dr.eric");
        vet1.setLastName("cohen");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("dr.moshe");
        vet2.setLastName("levi");

        vetService.save(vet2);


        System.out.println("Loaded vets...");


    }
}
