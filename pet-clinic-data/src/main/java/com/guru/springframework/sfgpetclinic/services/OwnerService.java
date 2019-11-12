package com.guru.springframework.sfgpetclinic.services;

import com.guru.springframework.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);

}
