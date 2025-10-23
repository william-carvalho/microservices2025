package br.com.will.services;

import br.com.will.exception.ResourceNotFoundException;
import br.com.will.model.Person;
import br.com.will.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private static final Logger logger = Logger.getLogger(PersonServices.class.getName());
    private final PersonRepository repository;

    public PersonServices(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> findAll() {
        logger.info("Finding all people");
        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info(() -> String.format("Finding person by ID: %d", id));
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));
    }

    public Person create(Person person) {
        logger.info(() -> String.format("Creating new person: %s %s", person.getFirstName(), person.getLastName()));
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info(() -> String.format("Updating person with ID: %d", person.getId()));

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + person.getId()));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public boolean delete(Long id) {
        logger.info(() -> String.format("Deleting person with ID: %d", id));

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

        repository.delete(entity);
        return true;
    }
}
