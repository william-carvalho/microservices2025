package br.com.will.services;

import br.com.will.exception.UnsuportedMathOperationException;
import br.com.will.utils.NumberConverter;
import org.springframework.stereotype.Service;

@Service
public class MathServices {

    public Double sum(String numberOne, String numberTwo) {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsuportedMathOperationException("Please set a numeric value!");

        return NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo);
    }

    public Double subtraction(String numberOne, String numberTwo) {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsuportedMathOperationException("Please set a numeric value!");

        return NumberConverter.convertToDouble(numberOne) - NumberConverter.convertToDouble(numberTwo);
    }

    public Double multiplication(String numberOne, String numberTwo) {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsuportedMathOperationException("Please set a numeric value!");

        return NumberConverter.convertToDouble(numberOne) * NumberConverter.convertToDouble(numberTwo);
    }

    public Double division(String numberOne, String numberTwo) {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsuportedMathOperationException("Please set a numeric value!");

        Double divisor = NumberConverter.convertToDouble(numberTwo);
        if (divisor == 0) throw new UnsuportedMathOperationException("Division by zero is not allowed!");

        return NumberConverter.convertToDouble(numberOne) / divisor;
    }

    public Double average(String numberOne, String numberTwo) {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsuportedMathOperationException("Please set a numeric value!");

        return (NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo)) / 2;
    }

    public Double squareRoot(String number) {
        if (!NumberConverter.isNumeric(number))
            throw new UnsuportedMathOperationException("Please set a numeric value!");

        Double value = NumberConverter.convertToDouble(number);
        if (value < 0) throw new UnsuportedMathOperationException("Cannot calculate square root of a negative number!");

        return Math.sqrt(value);
    }
}
