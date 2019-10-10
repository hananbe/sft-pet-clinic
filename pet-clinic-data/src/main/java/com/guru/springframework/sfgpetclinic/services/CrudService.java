package com.guru.springframework.sfgpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {
    Set<T> findAll();

    T findViewByID(ID id);

    T save(T object);

    void delete(T object);

    void deleteByID(ID id);


}
