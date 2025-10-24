package br.com.will.controller;

import br.com.will.enverionment.InstanceInformationService;
import br.com.will.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private InstanceInformationService instanceInformationService;

    @GetMapping(value ="/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency){
        return new Book(1L, "Denzel" , "Dia de treinamento", 38.5, new Date(), "BRL", instanceInformationService.retrieveServerPort());
    }
}
