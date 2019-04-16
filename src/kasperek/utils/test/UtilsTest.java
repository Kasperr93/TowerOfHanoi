package kasperek.utils.test;

import kasperek.utils.Utils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Tomasz Kasperek
 * @version 1.0.1 04/16/2019
 * @see kasperek.utils
 * @since 1.0
 */

public class UtilsTest {

    /**
     * Test <code>shouldRemovedLastSeparator</code> checks that the separator was removed.
     */

    @Test
    public void shouldRemovedLastSeparator() {

        // Given
        StringBuilder valueWithSeparatorDot = new StringBuilder("Test123..");
        StringBuilder valueWithSeparatorDash = new StringBuilder("Test123.--");

        // When/Then
        assertEquals("Test123.", Utils.removeLastSeparator(valueWithSeparatorDot, "."));
        assertEquals("Test123.-", Utils.removeLastSeparator(valueWithSeparatorDash, "-"));
    }

    /**
     * Test <code>shouldCheckItIsNumber</code> checks that value is a number,
     */

    @Test
    public void shouldCheckItIsNumber() {

        // When/Then
        assertFalse(Utils.isNumber("q"));
        assertFalse(Utils.isNumber("!"));
        assertFalse(Utils.isNumber("w"));
        assertTrue(Utils.isNumber("3"));
        assertTrue(Utils.isNumber("11"));
        assertTrue(Utils.isNumber("1"));
    }

    /**
     * Test <code>shouldValidateUserStringValue</code> checks that the user value (<code>String</code>) is correct.
     */

    @Test
    public void shouldValidateUserStringValue() {

        // Given
        String validateStringFalse = "sd";
        String validateStringTrue = "1";

        // When/Then
        assertFalse(Utils.validateUserValue(validateStringFalse));
        assertTrue(Utils.validateUserValue(validateStringTrue));
    }

    /**
     * Test <code>shouldValidateUserIntValue</code> checks that the user value (<code>int</code>) is correct.
     */

    @Test
    public void shouldValidateUserIntValue() {
        // Given
        int validateIntFalse = 1;
        int validateIntTrue = 5;

        // When/Then
        assertFalse(Utils.validateUserValue(validateIntFalse));
        assertTrue(Utils.validateUserValue(validateIntTrue));
    }
}
