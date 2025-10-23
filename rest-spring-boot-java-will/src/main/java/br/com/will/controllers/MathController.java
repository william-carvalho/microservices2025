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

    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne,
                              @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsuportedMathOperationException("Please set a numeric value!");

        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping("/mult/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne,
                                 @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsuportedMathOperationException("Please set a numeric value!");

        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne,
                           @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsuportedMathOperationException("Please set a numeric value!");

        Double divisor = convertToDouble(numberTwo);
        if (divisor == 0) throw new UnsuportedMathOperationException("Division by zero is not allowed!");

        return convertToDouble(numberOne) / divisor;
    }

    @RequestMapping("/avg/{numberOne}/{numberTwo}")
    public Double average(@PathVariable("numberOne") String numberOne,
                          @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsuportedMathOperationException("Please set a numeric value!");

        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    @RequestMapping("/sqrt/{number}")
    public Double squareRoot(@PathVariable("number") String number) throws Exception {

        if (!isNumeric(number))
            throw new UnsuportedMathOperationException("Please set a numeric value!");

        Double value = convertToDouble(number);
        if (value < 0D) throw new UnsuportedMathOperationException("Cannot calculate square root of a negative number!");

        return Math.sqrt(value);
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
