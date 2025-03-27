package RosanaCeline.validation;

public class NumberVerification {

    // Verifica se o valor eh numerico antes de somar ele
    // Se n for numerico entra na excecao
    public static boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");

        // permite numeros positivos e negativos ([-+]?)
        // permite numeros inteiros e decimais ([0-9]*\\.?[0-9]+)
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
