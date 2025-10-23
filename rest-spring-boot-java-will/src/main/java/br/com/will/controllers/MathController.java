package br.com.will.controllers;

import br.com.will.exception.UnsuportedMathOperationException;
import br.com.will.services.MathService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        return mathService.sum(numberOne, numberTwo);
    }

    @GetMapping("/sub/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        return mathService.subtraction(numberOne, numberTwo);
    }

    @GetMapping("/mult/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        return mathService.multiplication(numberOne, numberTwo);
    }

    @GetMapping("/div/{numberOne}/{numberTwo}")
    public Double division(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        return mathService.division(numberOne, numberTwo);
    }

    @GetMapping("/avg/{numberOne}/{numberTwo}")
    public Double average(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        return mathService.average(numberOne, numberTwo);
    }

    @GetMapping("/sqrt/{number}")
    public Double squareRoot(@PathVariable String number) throws Exception {
        return mathService.squareRoot(number);
    }
}
