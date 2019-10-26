package com.guru.springframework.sfgpetclinic.services.springdatajpa;

import com.guru.springframework.sfgpetclinic.model.Owner;
import com.guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import com.guru.springframework.sfgpetclinic.repositories.PetRepository;
import com.guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    Owner owner;
    public static final String lastName = "John";

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;


    @BeforeEach
    void setUp() {
        //  owner=Owner.builder().id(1l).lastName(lqstName).firstName("smith").build();;
        Long id = 1L;
        owner = new Owner(id, "john", lastName, "", "", "", new HashSet<>());
    }

    @Test
    void findLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(owner);

        Owner smith = ownerSDJpaService.findLastName(lastName);

        assertEquals(lastName, smith.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1l).build());
        returnOwnersSet.add(Owner.builder().id(2l).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = ownerSDJpaService.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));

        Owner owner = ownerSDJpaService.findViewByID(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerSDJpaService.findViewByID(1L);

        assertNull(owner);
    }


    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(owner);

        Owner savedOwner = ownerSDJpaService.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(owner);

        //default is 1 times
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteByID(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}
