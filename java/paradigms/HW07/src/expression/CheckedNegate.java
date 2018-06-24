package expression;

import expression.exceptions.UnaryMinusFunctionOverflowException;

/**
 * Created by Awelijuh on 11.04.2017.
 */
public class CheckedNegate extends Function {

    public CheckedNegate(TripleExpression expression) {
        super(expression);
    }

    protected int calculate(int value) {
        if (value == Integer.MIN_VALUE) {
            throw new UnaryMinusFunctionOverflowException(value);
        }
        return -value;
    }

}
