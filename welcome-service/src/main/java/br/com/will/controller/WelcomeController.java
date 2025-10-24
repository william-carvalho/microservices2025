package br.com.will.controller;

import br.com.will.config.WelcomeConfiguration;
import br.com.will.model.Welcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class WelcomeController {

    private static final String template = "%s, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private WelcomeConfiguration configuration;

    // http://localhost:8080/welcome?name=will
    @RequestMapping("/welcome")
    public Welcome greeting(@RequestParam(value = "name", defaultValue = "") String name) {
        if (name.isEmpty()) name =  configuration.getDefaultValue();
        return new Welcome(counter.incrementAndGet(), String.format(template, configuration.getWelcome(), name));

    }
}

