package com.guru.springframework.sfgpetclinic.services.map;

import com.guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerMapServiceTest {
    private OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(1L).build());
    }

    @Test
    void findAll() {
        Set<Owner> set = new HashSet<>();
        set = ownerMapService.findAll();

        assertEquals(1, set.size());

    }

    @Test
    void delete() {
        Owner owner = new Owner(2L, "owner2", "", "", "", "", new HashSet<>());
        ownerMapService.save(owner);
        assertEquals(owner, ownerMapService.findViewByID(2L));
        ownerMapService.delete(owner);

        assertEquals(null, ownerMapService.findViewByID(2L));

    }

    @Test
    void findViewByID() {
        Owner owner = ownerMapService.findViewByID(1L);
        Long id = 1L;
        assertEquals(id, owner.getId());

    }

    @Test
    void save() {
        Owner owner = new Owner(3L, "owner3", "", "", "", "", new HashSet<>());
        Owner ownerSaved = ownerMapService.save(owner);
        Long id = 3L;

        assertEquals(id, ownerSaved.getId());


    }

    @Test
    void deleteByID() {
        Owner owner = new Owner(4L, "owner3", "", "", "", "", new HashSet<>());
        ownerMapService.save(owner);
        Long id = 4L;
        ownerMapService.deleteByID(4L);
        assertEquals(null, ownerMapService.findViewByID(4L));

    }

    @Test
    void findLastName() {
        Owner owner = new Owner(5L, "owner3", "Levi", "", "", "", new HashSet<>());
        ownerMapService.save(owner);
        assertEquals(owner, ownerMapService.findLastName(owner.getLastName()));
    }
}