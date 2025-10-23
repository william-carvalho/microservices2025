package br.com.will.services;

import br.com.will.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {

        logger.info("Find one person");

        Person person = new Person();
        person.setId(counter.getAndIncrement());
        person.setFirstName("Will");
        person.setLastName("Bill");
        person.setAddress("Campeche - Floripa - BR");
        person.setGender("Male");

        return person;

    }

    public Person create(Person person) {

        logger.info("Creating one Person!");

        return person;
    }

    public Person update(Person person) {

        logger.info("Updating one Person!");

        return person;
    }

    public void delete(String id) {

        logger.info("Deleting one Person!");

    }

    public List<Person> findAll() {

        logger.info("Finding all People!");

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Firstname " + i);
        person.setLastName("Lastname " + i);
        person.setAddress("Some Address in Brasil");
        person.setGender("Male");
        return person;
    }

}
