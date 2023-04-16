package dev.fry.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@SuppressWarnings("all")
class StringUtilsTest {

    /*
     *   remove new line char at end of String
     */
    @Test
    void removeNewLineAtEndOfStringTest() {

        String expectedData = "+ Modems";
        String inputData = expectedData + "\n";

        Assertions.assertEquals(StringUtils.removeNewLineAtEndOfString(inputData), expectedData);
    }
}