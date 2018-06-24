package expression.exceptions;

import expression.parser.ExpressionParser;

/**
 * Created by Awelijuh on 26.04.2017.
 */
public class NotFirstArgumentExpressionParserException extends ParserException {
    public NotFirstArgumentExpressionParserException(String s, String ex, int pos) {
        super("Not enough first parameter for the operation \"" + s + "\"", ex, pos);
    }

}
