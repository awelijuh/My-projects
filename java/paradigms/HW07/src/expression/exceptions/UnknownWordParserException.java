package expression.exceptions;

/**
 * Created by Awelijuh on 26.04.2017.
 */
public class UnknownWordParserException extends ParserException{
    public UnknownWordParserException(String s, String ex, int pos) {
        super("Unknown Word: \"" + s + "\"", ex, pos);
    }
}
