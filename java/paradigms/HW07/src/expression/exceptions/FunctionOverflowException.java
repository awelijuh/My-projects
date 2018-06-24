package expression.exceptions;

/**
 * Created by Awelijuh on 25.04.2017.
 */
public class FunctionOverflowException extends OverflowException {
    FunctionOverflowException(String name, int value) {
        super("(" + name + " " + Integer.toString(value) + ")");
    }
}
