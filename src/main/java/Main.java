import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        System.out.println("Enter a number: ");
        String lineFromConsole = getLineFromConsole();
        System.out.println(lineFromConsole);
*/
        LuhnValidator luhn = new LuhnValidator();

        System.out.println("The Luhner: ");
        try {
            System.out.println(luhn.isLuhnNumber("528575948423232323998333139")); // true
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(luhn.isLuhnNumber("5285759484333139")); // true
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(luhn.isLuhnNumber("efjhsdf")); // true
        } catch (Exception e) {
            e.printStackTrace();
        }

        LuhnCheckDigit checker = new LuhnCheckDigit();
        boolean valid = checker.isValid("5285759484333139");
        System.out.println("Hello Apache");
        valid = checker.isValid("5285759484333139");
        System.out.println(valid);
        // checkDigit("49927398716");
    }

    public static String getLineFromConsole() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        return input;
    }

}
