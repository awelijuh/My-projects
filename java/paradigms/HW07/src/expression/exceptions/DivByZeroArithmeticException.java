package expression.exceptions;

/**
 * Created by Awelijuh on 26.04.2017.
 */
public class DivByZeroArithmeticException extends ArithmeticException {
    public DivByZeroArithmeticException(int x, int y) {
        super("Division by zero: (" + Integer.toString(x) + " / " + Integer.toString(y) + ")");
    }
}
