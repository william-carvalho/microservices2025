package br.com.will.controllers;

import br.com.will.model.Person;
import br.com.will.services.PersonServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonServices personServices;

    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        Person person = personServices.findById(id);
        return person != null ? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        List<Person> persons = personServices.findAll();
        return ResponseEntity.ok(persons);
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        Person created = personServices.create(person);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person) {
        person.setId(id);
        Person updated = personServices.update(person);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = personServices.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
