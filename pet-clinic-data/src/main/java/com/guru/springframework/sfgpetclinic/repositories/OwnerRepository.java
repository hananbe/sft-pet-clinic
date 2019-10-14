package com.guru.springframework.sfgpetclinic.repositories;

import com.guru.springframework.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
}
