package expression.exceptions;

/**
 * Created by Awelijuh on 26.04.2017.
 */
public class NotArgumentExpressionParserException extends ParserException {
    public NotArgumentExpressionParserException(String ex, int pos) {
        super("Not found the argument for the operation ", ex, pos);
    }
}
