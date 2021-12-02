package com.usa.reto2.reto2.repository.crud;

import com.usa.reto2.reto2.model.Fragance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FraganceCrudRepository extends MongoRepository<Fragance, String> {
}
