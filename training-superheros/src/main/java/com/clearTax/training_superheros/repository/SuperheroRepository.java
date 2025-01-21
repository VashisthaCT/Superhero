package com.clearTax.training_superheros.repository;

import com.clearTax.training_superheros.model.Superhero;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuperheroRepository extends MongoRepository<Superhero, String> {
    List<Superhero> findByPower(String power);
}