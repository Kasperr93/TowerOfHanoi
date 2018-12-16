package kasperek.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Tomasz Kasperek
 * @version 1.0 12/14/2018
 * @since 0.1
 */

public class Utils {

    /**
     * The method is responsible for retrieves the value entered by the user.
     *
     * @return value entered by the user.
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

    /**
     * The method is responsibility for remove the last separator from String.
     *
     * @param str       String from which should be removing the last separator.
     * @param separator the last separator who will be remove.
     * @return String after removed the last separator.
     */

    public static String removeLastSeparator(StringBuilder str, String separator) {
        return str.substring(0, str.lastIndexOf(separator));
    }

    /**
     * The method checks whether string is a number.
     *
     * @param number is a string entered by the user.
     * @return boolean value, if is a number - the method return true, else - the method return false.
     */

    public static boolean isNumber(String number) {
        return number.matches("-?\\d+(\\.\\d+)?");
    }

    /**
     * The method is responsibility for checks values entered by the user.
     *
     * @param choice value entered by the user.
     * @return boolean value, if it's the correct value - the method return true, else - the method return false.
     */

    public static boolean validateUserValue(String choice) {
        if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4"))
            return true;
        else if (choice.equalsIgnoreCase("q"))
            System.exit(0);

        return false;
    }

    /**
     * The method is responsibility for checks values entered by the user.
     *
     * @param choice value entered by the user.
     * @return boolean value, if it's the correct value - the method return true, else - the method return false.
     */

    public static boolean validateUserValue(int choice) {
        return choice >= 3;
    }
}
