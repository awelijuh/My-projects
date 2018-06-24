package expression.exceptions;

/**
 * Created by Awelijuh on 26.04.2017.
 */
public class ExcessOpenBracketsBalanceArithmeticException extends BracketsBalanceArithmeticException {
    public ExcessOpenBracketsBalanceArithmeticException(String ex, int pos) {
        super("Not enough closing parentheses", ex, pos);
    }
}
