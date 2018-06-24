package expression.exceptions;

/**
 * Created by Awelijuh on 26.04.2017.
 */
public class DivideOperationOverflowException extends OperationOverflowException {
    public DivideOperationOverflowException(int first, int second) {
        super("/", first, second);
    }
}
