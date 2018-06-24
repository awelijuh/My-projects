package expression.exceptions;

/**
 * Created by Awelijuh on 26.04.2017.
 */
public class BracketsBalanceArithmeticException extends ParserException{
    public BracketsBalanceArithmeticException(String s, String ex, int pos) {
        super("Balance of the brackets is broken: " + s, ex, pos);
    }
}
