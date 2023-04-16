package dev.fry.util;

@SuppressWarnings("all")
public class StringUtils {

    public static String removeNewLineAtEndOfString(String s) {
        return s.isEmpty() ? s : s.endsWith("\n") ? s.substring(0, s.length()-1) : s;
    }
}
