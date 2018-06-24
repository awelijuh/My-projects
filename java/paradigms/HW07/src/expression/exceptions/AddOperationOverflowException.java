package expression.exceptions;

/**
 * Created by Awelijuh on 26.04.2017.
 */
public class AddOperationOverflowException extends OperationOverflowException {
    public AddOperationOverflowException(int first, int second) {
        super("+", first, second);
    }

}
