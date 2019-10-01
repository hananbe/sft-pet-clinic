package com.guru.springframework.sfgpetclinic.services;

import com.guru.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudServices<Owner,Long> {

    Owner findLastName(String lastName);
}
