package kasperek.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Tomasz Kasperek
 * @version 0.3 11/30/2018
 * @since 0.1
 */

public class Utils {

    /**
     * The method is responsible for retrieving the value entered by user.
     *
     * @return value entered by user.
     */

    public static String readLine() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";

        try {
            line = br.readLine();
        } catch (IOException ioe) {
            ioe.getMessage();
        }

        return line;
    }

    public static String removeLastSeparator(StringBuilder str, String separator) {
        return str.substring(0, str.lastIndexOf(separator));
    }

    public static boolean isNumber(String number) {
        return number.matches("-?\\d+(\\.\\d+)?");
    }

    public static boolean validateUserValue(String choice) {
        if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4"))
            return true;
        else if (choice.equalsIgnoreCase("q"))
            System.exit(0);

        return false;
    }

    public static boolean validateUserValue(int choice) {
        return choice >= 3;
    }
}
