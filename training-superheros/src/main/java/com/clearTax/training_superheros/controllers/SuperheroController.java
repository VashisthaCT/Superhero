package com.clearTax.training_superheros.controllers;

import com.clearTax.training_superheros.model.Superhero;
import com.clearTax.training_superheros.repository.SuperheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class SuperheroController {

    @Autowired
    private SuperheroRepository superheroRepository;

    // Insert a single superhero
    @PostMapping("/superhero")
    public Superhero createSuperhero(@RequestBody Superhero superhero) {
        return superheroRepository.save(superhero);
    }

    // Insert multiple superheroes
    @PostMapping("/superheroes")
    public List<Superhero> createSuperheroes(@RequestBody List<Superhero> superheroes) {
        return superheroRepository.saveAll(superheroes);
    }

    // Get a superhero by name
    @GetMapping("/name/{name}")
    public ResponseEntity<Superhero> getSuperheroByName(@PathVariable String name) {
        Optional<Superhero> superhero = superheroRepository.findById(name);
        return superhero.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Get superheroes by power
    @GetMapping("/power/{power}")
    public List<Superhero> getSuperheroesByPower(@PathVariable String power) {
        return superheroRepository.findByPower(power);
    }

    // Delete a superhero by name
    @DeleteMapping("/name/{name}")
    public ResponseEntity<Void> deleteSuperheroByName(@PathVariable String name) {
        if (superheroRepository.existsById(name)) {
            superheroRepository.deleteById(name);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update a superhero by name
    @PutMapping("/name/{name}")
    public ResponseEntity<Superhero> updateSuperheroByName(@PathVariable String name, @RequestBody Superhero updatedSuperhero) {
        Optional<Superhero> superheroOptional = superheroRepository.findById(name);

        if (superheroOptional.isPresent()) {
            Superhero superhero = superheroOptional.get();
            superhero.setPower(updatedSuperhero.getPower());
            superhero.setGender(updatedSuperhero.getGender());
            superhero.setUniverse(updatedSuperhero.getUniverse());
            superhero.setAge(updatedSuperhero.getAge());
            superhero.setArchEnemy(updatedSuperhero.getArchEnemy());
            return ResponseEntity.ok(superheroRepository.save(superhero));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}