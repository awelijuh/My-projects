package expression.exceptions;

/**
 * Created by Awelijuh on 25.04.2017.
 */
public class OverflowException extends ArithmeticException {
    protected OverflowException(String s) {
        super("Overflow: " + s);
    }
}
