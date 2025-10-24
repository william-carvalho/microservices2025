package br.com.will.controller;

import br.com.will.dto.ExchangeDto;
import br.com.will.enverionment.InstanceInformationService;
import br.com.will.model.Book;
import br.com.will.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private InstanceInformationService instanceInformationService;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value ="/first/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBookFirst(@PathVariable("id") Long id, @PathVariable("currency") String currency){

        String port = instanceInformationService.retrieveServerPort();

        var book = bookRepository.findById(id).orElseThrow();

        book.setEnviroment(port);
        book.setCurrency(currency);

        return book;
    }

    @GetMapping(value ="/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency){

        String port = instanceInformationService.retrieveServerPort();

        var book = bookRepository.findById(id).orElseThrow();

        HashMap<String, String> params = new HashMap<>();
        params.put("amount", book.getPrice().toString());
        params.put("from", "USD");
        params.put("to", currency);

        var response = new RestTemplate().getForEntity("http://localhost:8000/exchange-service/{amount}/{from}/{to}", ExchangeDto.class, params);

       ExchangeDto exchangeDto = response.getBody();

        book.setEnviroment(port);
        book.setPrice(exchangeDto.getConvertedValue());
        book.setCurrency(currency);

        return book;
    }
}
