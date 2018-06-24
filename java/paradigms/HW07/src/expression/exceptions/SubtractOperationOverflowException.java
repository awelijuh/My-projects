package expression.exceptions;

/**
 * Created by Awelijuh on 26.04.2017.
 */
public class SubtractOperationOverflowException extends OperationOverflowException {
    public SubtractOperationOverflowException(int x, int y) {
        super("-", x, y);
    }
}
