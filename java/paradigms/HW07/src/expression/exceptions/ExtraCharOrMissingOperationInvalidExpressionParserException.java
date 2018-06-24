package expression.exceptions;

/**
 * Created by Awelijuh on 26.04.2017.
 */
public class ExtraCharOrMissingOperationInvalidExpressionParserException extends InvalidExpressionParserException {
    public ExtraCharOrMissingOperationInvalidExpressionParserException(String ex, int pos) {
        super("Expression contains extra characters or missing operation " + pos, ex, pos);
    }
}
