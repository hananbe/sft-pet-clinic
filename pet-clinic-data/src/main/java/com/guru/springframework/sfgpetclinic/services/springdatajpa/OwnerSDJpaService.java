package com.guru.springframework.sfgpetclinic.services.springdatajpa;

import com.guru.springframework.sfgpetclinic.model.Owner;
import com.guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import com.guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owner -> owners.add(owner));
        return owners;
    }

    @Override
    public Owner findViewByID(Long aLong) {
        Optional<Owner> owner = ownerRepository.findById(aLong);

        if (owner.isPresent())
            return owner.get();

        return null;
    }

    @Override
    public Owner save(Owner object) {

        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        ownerRepository.deleteById(aLong);

    }
    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName);
    }

}
