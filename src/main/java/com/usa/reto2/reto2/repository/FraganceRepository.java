package com.usa.reto2.reto2.repository;

import com.usa.reto2.reto2.model.Fragance;
import com.usa.reto2.reto2.repository.crud.FraganceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FraganceRepository {

    @Autowired
    private FraganceCrudRepository repository;

    public List<Fragance>getAll() {
        return repository.findAll();
    }

    public Optional<Fragance> getFra(String reference) {
        return repository.findById(reference);
    }

    public Fragance create(Fragance fra) {
        return repository.save(fra);
    }

    public void update(Fragance fra) {
        repository.save(fra);
    }

    public void delete(Fragance fra) {
        repository.delete(fra);
    }







}
