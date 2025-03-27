package RosanaCeline.validation;

import RosanaCeline.exception.UnsuportedMathOperationException;

public class NumberConvertion {

    // Converte a String para Double
    public static Double convertToDouble(String strNumber) throws IllegalArgumentException {

        if (strNumber == null || strNumber.isEmpty()) throw new UnsuportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",", ".");

        return Double.parseDouble(number);
    }
}
