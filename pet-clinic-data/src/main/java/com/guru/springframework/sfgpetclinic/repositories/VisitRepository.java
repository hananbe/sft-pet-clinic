package com.guru.springframework.sfgpetclinic.repositories;

import com.guru.springframework.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
