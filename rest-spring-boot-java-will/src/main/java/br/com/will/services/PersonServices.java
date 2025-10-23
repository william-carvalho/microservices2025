package br.com.will.services;

import br.com.will.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){

        logger.info("Find one person");

        Person person = new Person();
        person.setId(counter.getAndIncrement());
        person.setFirstName("Will");
        person.setLastName("Bill");
        person.setAddress("Campeche - Floripa - BR");
        person.setGender("Male");

        return person;

    }
}
