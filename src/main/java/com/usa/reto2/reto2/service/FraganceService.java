package com.usa.reto2.reto2.service;

import com.usa.reto2.reto2.model.Fragance;
import com.usa.reto2.reto2.repository.FraganceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FraganceService {

    @Autowired
    private FraganceRepository fraRepository;

    public List<Fragance> getAll() {
        return fraRepository.getAll();
    }

    public Optional<Fragance> getFra(String reference) {
        return fraRepository.getFra(reference);
    }

    public Fragance create(Fragance accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return fraRepository.create(accesory);
        }
    }

    public Fragance update(Fragance accesory) {

        if (accesory.getReference() != null) {
            Optional<Fragance> accesoryDb = fraRepository.getFra(accesory.getReference());
            if (!accesoryDb.isEmpty()) {

                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }

                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }

                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                fraRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getFra(reference).map(accesory -> {
            fraRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
