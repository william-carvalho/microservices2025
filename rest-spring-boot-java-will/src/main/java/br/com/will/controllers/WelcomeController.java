package br.com.will.controllers;

import br.com.will.model.Welcome;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class WelcomeController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //Ao executar o projeto fazer requisição para http://localhost:8080/welcome?name=CR7
    @RequestMapping("/welcome")
    public Welcome welcome(@RequestParam(value = "name") String name){
        return new Welcome(counter.incrementAndGet(), String.format(template, name));
    }
}
