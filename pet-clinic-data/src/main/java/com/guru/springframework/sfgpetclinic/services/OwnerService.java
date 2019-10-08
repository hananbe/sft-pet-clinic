package com.guru.springframework.sfgpetclinic.services;

import com.guru.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findLastName(String lastName);
}
