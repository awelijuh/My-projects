package expression.exceptions;

/**
 * Created by Awelijuh on 26.04.2017.
 */
public class OperationOverflowException extends OverflowException{
    OperationOverflowException(String name, int first, int second) {
        super("(" + Integer.toString(first) + " " + name + " " + Integer.toString(second) + ")");
    }

}
