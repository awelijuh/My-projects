package expression.exceptions;

/**
 * Created by Awelijuh on 26.04.2017.
 */
public class EmptyBracketsInvalidExpressionParserException extends InvalidExpressionParserException {
    public EmptyBracketsInvalidExpressionParserException(String ex, int pos) {
        super("Empty Brackets ", ex, pos);
    }
}
