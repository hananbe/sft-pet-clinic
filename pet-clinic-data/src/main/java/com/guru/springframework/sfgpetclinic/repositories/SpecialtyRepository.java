package com.guru.springframework.sfgpetclinic.repositories;

import com.guru.springframework.sfgpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Speciality,Long> {
}
