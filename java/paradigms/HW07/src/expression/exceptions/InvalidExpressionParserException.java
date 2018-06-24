package expression.exceptions;

/**
 * Created by Awelijuh on 26.04.2017.
 */
public class InvalidExpressionParserException extends ParserException {
    public InvalidExpressionParserException(String s, String ex, int pos) {
        super("Invalid Expression: " + s, ex, pos);
    }
}
