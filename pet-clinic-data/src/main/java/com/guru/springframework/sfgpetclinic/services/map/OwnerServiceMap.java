package com.guru.springframework.sfgpetclinic.services.map;

import com.guru.springframework.sfgpetclinic.model.Owner;
import com.guru.springframework.sfgpetclinic.services.CrudServices;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudServices<Owner, Long> {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner findViewByID(Long id) {
        return this.findViewById(id);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(),owner);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);
    }
}
