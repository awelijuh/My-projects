package expression.exceptions;

/**
 * Created by Awelijuh on 26.04.2017.
 */
public class NotSecondArgumentExpressionParserException extends ParserException {
    public NotSecondArgumentExpressionParserException(String s, String ex, int pos) {
        super("Not enough second parameter for the operation \"" + s + "\"", ex, pos);
    }
}
