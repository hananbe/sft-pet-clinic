package com.guru.springframework.sfgpetclinic.services.springdatajpa;

import com.guru.springframework.sfgpetclinic.model.Pet;
import com.guru.springframework.sfgpetclinic.repositories.PetRepository;
import com.guru.springframework.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDjpaService implements PetService {
    private final PetRepository petRepository;

    public PetSDjpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        HashSet<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pet -> pets.add(pet));
        return pets;
    }

    @Override
    public Pet findViewByID(Long aLong) {
        Optional<Pet> pet = petRepository.findById(aLong);
        if (pet.isPresent())
            return pet.get();

        return null;
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
