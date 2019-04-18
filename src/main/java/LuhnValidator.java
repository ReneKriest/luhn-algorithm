import java.math.BigInteger;

/**
 * Class that validates a given string whether it stands the Luhn Algorithm check or not
 * https://en.wikipedia.org/wiki/Luhn_algorithm
 *
 * ------------------------------------------------------------
 * #TODO
 * There are several options to handle the Validation.
 *
 * Filter Pattern, Strategy Pattern, Interceptor Pattern
 *
 * However these pattern add only more boilerplate to this small class, This is overkill for these
 * almost trivial checks. Also there is no reuse in this case.
 *
 * Number --> add Filter: Luhn, isLargerThen, ...
 */
public class LuhnValidator {

    /**
     * Build checksum and return boolean
     * @param digits Number as String to check
     */
    boolean isLuhnNumber(String digits) throws Exception {
        digits = validateString(digits);

        int value;
        int totalSum = 0;

        for (int i = 0, digitsLength = digits.length() - 1; i <= digitsLength; i++) {
            value = Character.getNumericValue(digits.charAt(digitsLength - i));
            if (i % 2 == 1) {
                value *= 2;
                if (value > 9) {
                    value -= 9;
                }
            }
            totalSum += value;
        }

        return totalSum % 10 == 0;
    }

    /**
     * Checks whether a String is a valid number and converts to BigInteger
     * @param digits Digits as String
     * @return Returns a String that only contains Numbers without any leading zeros
     */
    String validateString(String digits) throws Exception {
        digits = removeWhitespace(digits); // Converter/Transformer
        containsOnlyDigits(digits); // Checks: boolean
        return String.valueOf(convertToBigInteger(digits));// C/T
    }

    /**
     * This is room for improvement:
     * - Check BigInteger's value digits > 0
     * - Check BigInteger's value length > 7 digits
     * @param digits Digits as String
     * @return Boolean
     */
    private boolean checkForEdgeCases(String digits) {
        return true;
    }

    /**
     * Remove all Whitespaces:
     * - at the start (trim start)
     * - at the end (trim end)
     * - 1 or more adjacent/consecutive whitespaces
     * - no whitespace at all
     * @param digits Digits as String
     * @return String Digits without possible whitespace(s)
     */
    private String removeWhitespace(String digits) {
        return digits.replaceAll("\\s+","");
    }

    /**
     * Checks whether a String only contains digits
     * Range: Long.MAX
     * @param digits Digits as String
     * @return BigInteger
     */
    BigInteger convertToBigInteger(String digits) {
        try {
            return new BigInteger(digits);
        } catch (NumberFormatException exception) {
            throw exception;
        }
    }

    /**
     * Checks strings if it contains only digits
     * @param digits
     * @return Boolean true if there were only digits in the number string
     * @throws Exception In case there were characters in the number string
     */
    boolean containsOnlyDigits(String digits) throws Exception {
        if (digits.matches("[0-9]+")) {
            return true;
        } else {
            throw new Exception("Contains characters!");
        }
    }
}
