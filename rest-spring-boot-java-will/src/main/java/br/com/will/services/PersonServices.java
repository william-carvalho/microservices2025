package br.com.will.services;

import br.com.will.exception.ResourceNotFoundException;
import br.com.will.model.Person;
import br.com.will.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PersonRepository repository;

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(Long id) {

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

    }

    public Person create(Person person) {

        logger.info("Creating one Person!");

        return repository.save(person);

    }

    public Person update(Person person) {

        logger.info("Updating one Person!");

        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);

    }

    public void delete(Long id) {

        logger.info("Deleting one Person!");

        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(entity);

    }

    public List<Person> findAll() {

        logger.info("Finding all People!");

        return repository.findAll();

    }

}
