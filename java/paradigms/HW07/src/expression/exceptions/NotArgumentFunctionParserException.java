package expression.exceptions;

/**
 * Created by Awelijuh on 26.04.2017.
 */
public class NotArgumentFunctionParserException extends ParserException {
    public NotArgumentFunctionParserException(String s, String ex, int pos) {
        super("Not argument for the operation \"" + s + "\"", ex, pos);
    }
}
