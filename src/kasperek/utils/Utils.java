package kasperek.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Tomasz Kasperek
 * @version 0.1 11/23/2018
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
}
