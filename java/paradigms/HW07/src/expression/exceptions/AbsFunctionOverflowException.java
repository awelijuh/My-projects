package expression.exceptions;

/**
 * Created by Awelijuh on 25.04.2017.
 */
public class AbsFunctionOverflowException extends FunctionOverflowException {
    public AbsFunctionOverflowException(int x) {
        super("abs", x);
    }
}
