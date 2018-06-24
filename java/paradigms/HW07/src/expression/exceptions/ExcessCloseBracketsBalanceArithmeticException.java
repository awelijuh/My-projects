package expression.exceptions;

/**
 * Created by Awelijuh on 26.04.2017.
 */
public class ExcessCloseBracketsBalanceArithmeticException extends BracketsBalanceArithmeticException {
    public ExcessCloseBracketsBalanceArithmeticException(String ex, int pos) {
        super("No opening brackets", ex, pos);
    }
}
