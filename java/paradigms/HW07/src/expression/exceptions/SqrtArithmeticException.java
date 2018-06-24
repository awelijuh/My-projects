package expression.exceptions;

/**
 * Created by Awelijuh on 26.04.2017.
 */
public class SqrtArithmeticException extends ArithmeticException {
    public SqrtArithmeticException(int x) {
        super("sqrt invalid value: " + Integer.toString(x));
    }
}
