package expression.exceptions;

/**
 * Created by Awelijuh on 26.04.2017.
 */
public class MultiplyOperationOverflowException extends OperationOverflowException{
    public MultiplyOperationOverflowException(int x, int y) {
        super("*", x, y);
    }
}
