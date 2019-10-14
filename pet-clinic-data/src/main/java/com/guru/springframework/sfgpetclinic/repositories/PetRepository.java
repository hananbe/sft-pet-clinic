package com.guru.springframework.sfgpetclinic.repositories;

import com.guru.springframework.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
