import java.util.Scanner;

/**
 * Where the Luhn Magic happens via command line
 */
public class Main {
    public static void main(String[] args) {
        String defaultText = "Input " + "'" + "%s" + "'";

        LuhnValidator luhn = new LuhnValidator();

        System.out.println("The magical Luhn Validator!");
        System.out.print("Enter a Number or EXIT to leave: ");

        String digits = "";

        while (true) {
            digits = getInputFromConsole();

            if (digits.equals("EXIT")) {
                return;
            }

            try {
                if (luhn.isLuhnNumber(digits)) {
                    System.out.println(String.format(defaultText, digits) + " is a valid Luhn number. :)");
                } else {
                    System.out.println(String.format(defaultText, digits) + " is NOT a valid Luhn number.");
                    System.out.print("Try again: ");
                }
            } catch (Exception e) {
                System.out.println(String.format(defaultText, digits) + " is not a valid Number. It contains Chars.");
                System.out.print("Pls enter only digits: ");
            }
        }
    }

    private static String getInputFromConsole() {
        return new Scanner(System.in).nextLine();
    }

}
