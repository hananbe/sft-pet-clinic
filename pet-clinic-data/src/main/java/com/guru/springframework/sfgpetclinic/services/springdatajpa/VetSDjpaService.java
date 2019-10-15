package com.guru.springframework.sfgpetclinic.services.springdatajpa;

import com.guru.springframework.sfgpetclinic.model.Vet;
import com.guru.springframework.sfgpetclinic.repositories.VetRepository;
import com.guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDjpaService implements VetService {
    private final VetRepository vetRepository;

    public VetSDjpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        HashSet<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vet -> vets.add(vet));
        return vets;
    }

    @Override
    public Vet findViewByID(Long aLong) {
        Optional<Vet> vet = vetRepository.findById(aLong);

        if (vet.isPresent())
            return vet.get();

        return null;
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
