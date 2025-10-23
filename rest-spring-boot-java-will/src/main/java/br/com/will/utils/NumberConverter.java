package br.com.will.utils;

import br.com.will.exception.UnsuportedMathOperationException;
import io.micrometer.common.util.StringUtils;

public class NumberConverter {

    public static Double convertToDouble(String strNumber) {
        if (StringUtils.isEmpty(strNumber))
            throw new UnsuportedMathOperationException("Please set a numeric value!");

        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strNumber) {
        if (StringUtils.isEmpty(strNumber)) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
