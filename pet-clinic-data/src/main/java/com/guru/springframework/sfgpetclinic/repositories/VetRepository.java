package com.guru.springframework.sfgpetclinic.repositories;

import com.guru.springframework.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
