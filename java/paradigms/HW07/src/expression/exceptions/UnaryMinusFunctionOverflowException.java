package expression.exceptions;

/**
 * Created by Awelijuh on 26.04.2017.
 */
public class UnaryMinusFunctionOverflowException extends FunctionOverflowException {
    public UnaryMinusFunctionOverflowException(int x) {
        super("-", x);
    }
}
