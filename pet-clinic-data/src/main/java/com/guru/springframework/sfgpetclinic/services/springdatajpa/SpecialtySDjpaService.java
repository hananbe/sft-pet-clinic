package com.guru.springframework.sfgpetclinic.services.springdatajpa;

import com.guru.springframework.sfgpetclinic.model.Speciality;
import com.guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import com.guru.springframework.sfgpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtySDjpaService implements SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public SpecialtySDjpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        HashSet<Speciality> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialty -> specialties.add(specialty));
        return specialties;
    }

    @Override
    public Speciality findViewByID(Long aLong) {
        Optional<Speciality> speciality = specialtyRepository.findById(aLong);
        if (speciality.isPresent())
            return speciality.get();

        return null;
    }

    @Override
    public Speciality save(Speciality object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
