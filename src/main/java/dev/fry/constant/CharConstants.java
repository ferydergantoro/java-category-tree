package dev.fry.constant;

/**
 * Char Constants for this package.
 */

@SuppressWarnings("all")
public class CharConstants {

    public static final char BACKSLASH = '\\';

    public static final char BACKSPACE = '\b';

    public static final String COMMA = ",";

    /**
     * Starts a comment, the remainder of the line is the comment.
     */
    public static final char COMMENT = '#';

    public static final char CR = '\r';

    /** RFC 4180 defines line breaks as CRLF */
    public static final String CRLF = "\r\n";

    public static final Character DOUBLE_QUOTE_CHAR = Character.valueOf('"');

    public static final String EMPTY = "";

    public static final String[] EMPTY_STRING_ARRAY = {};

    /** The end of stream symbol */
    public static final int END_OF_STREAM = -1;

    public static final char FF = '\f';

    public static final char LF = '\n';

    /**
     * Unicode line separator.
     */
    public static final String LINE_SEPARATOR = "\u2028";

    /**
     * Unicode next line.
     */
    public static final String NEXT_LINE = "\u0085";

    /**
     * Unicode paragraph separator.
     */
    public static final String PARAGRAPH_SEPARATOR = "\u2029";

    public static final char PIPE = '|';

    /** ASCII record separator */
    public static final char RS = 30;

    public static final char SP = ' ';

    public static final String SQL_NULL_STRING = "\\N";

    public static final char TAB = '\t';

    /** Undefined state for the lookahead char */
    public static final int UNDEFINED = -2;

    /** ASCII unit separator */
    public static final char US = 31;
}
