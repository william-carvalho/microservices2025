package br.com.will.services;

import br.com.will.exception.ResourceNotFoundException;
import br.com.will.model.Person;
import br.com.will.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PersonServicesTest {

    @Mock
    private PersonRepository repository;

    @InjectMocks
    private PersonServices service;

    private Person person;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        person = new Person();
        person.setId(1L);
        person.setFirstName("Will");
        person.setLastName("Bill");
        person.setAddress("Florianópolis");
        person.setGender("Male");
    }

    @Test
    void testFindAll_ShouldReturnList() {
        when(repository.findAll()).thenReturn(Arrays.asList(person));

        List<Person> result = service.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testFindById_ShouldReturnPerson_WhenExists() {
        when(repository.findById(1L)).thenReturn(Optional.of(person));

        Person result = service.findById(1L);

        assertNotNull(result);
        assertEquals("Will", result.getFirstName());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testFindById_ShouldThrowException_WhenNotFound() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            service.findById(1L);
        });

        assertEquals("No records found for this ID: 1", exception.getMessage());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testCreate_ShouldReturnCreatedPerson() {
        when(repository.save(any(Person.class))).thenReturn(person);

        Person result = service.create(person);

        assertNotNull(result);
        assertEquals("Will", result.getFirstName());
        verify(repository, times(1)).save(person);
    }

    @Test
    void testUpdate_ShouldReturnUpdatedPerson_WhenExists() {
        Person updated = new Person();
        updated.setId(1L);
        updated.setFirstName("Will");
        updated.setLastName("Bill");
        updated.setAddress("Florianópolis");
        updated.setGender("Male");

        when(repository.findById(1L)).thenReturn(Optional.of(person));
        when(repository.save(any(Person.class))).thenReturn(updated);

        Person result = service.update(updated);

        assertEquals("Will", result.getFirstName());
        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(any(Person.class));
    }

    @Test
    void testUpdate_ShouldThrowException_WhenNotFound() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.update(person));
        verify(repository, times(1)).findById(1L);
        verify(repository, never()).save(any());
    }

    @Test
    void testDelete_ShouldReturnTrue_WhenPersonExists() {
        when(repository.findById(1L)).thenReturn(Optional.of(person));
        doNothing().when(repository).delete(person);

        boolean result = service.delete(1L);

        assertTrue(result);
        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).delete(person);
    }

    @Test
    void testDelete_ShouldThrowException_WhenNotFound() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.delete(1L));
        verify(repository, times(1)).findById(1L);
        verify(repository, never()).delete(any());
    }
}
