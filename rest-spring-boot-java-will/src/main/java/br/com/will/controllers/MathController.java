package br.com.will.controllers;


import br.com.will.exception.UnsuportedMathOperationException;
import io.micrometer.common.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    //http://localhost:8080/math/sum/83/55
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsuportedMathOperationException("Please set a numeric value!");

        return convertToDouble(numberOne) + convertToDouble(numberTwo);

    }

    private Double convertToDouble(String strNumber) throws IllegalArgumentException {

        if (StringUtils.isEmpty(strNumber)) throw new UnsuportedMathOperationException("Please set a numeric value!");


        String number = strNumber.replace(",", "."); //USD 500.000

        return Double.parseDouble(number);

    }

    private boolean isNumeric(String strNumber) {

        if (StringUtils.isEmpty(strNumber)) return false;

        String number = strNumber.replace(",", "."); //USD 500.000

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }
    //http://localhost:8080/math/division/83/55
    //http://localhost:8080/math/subtraction/83/55
    //http://localhost:8080/math/division/83/55
}
