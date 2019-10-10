package com.guru.springframework.sfgpetclinic.services.map;

import com.guru.springframework.sfgpetclinic.model.Speciality;
import com.guru.springframework.sfgpetclinic.model.Vet;
import com.guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private SpecialtyMapService specialtyMapService;

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findViewByID(Long aLong) {
        return this.findViewById(aLong);
    }

    @Override
    public Vet save(Vet vet) {
        if (vet.getSpecialities().size() > 0) {
            vet.getSpecialities().forEach(speciality -> {
                if (speciality.getId() != null) {
                    Speciality savedSpeciality = specialtyMapService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }

        return super.save(vet);

    }

    @Override
    public void delete(Vet vet) {
        {
            super.delete(vet);
        }

    }

    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);
    }
}
