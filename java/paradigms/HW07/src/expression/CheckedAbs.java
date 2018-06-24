package expression;

import expression.exceptions.AbsFunctionOverflowException;

/**
 * Created by Awelijuh on 11.04.2017.
 */
public class CheckedAbs extends Function {

    public CheckedAbs(TripleExpression expression) {
        super(expression);
    }


    protected int calculate(int value) {
        if (value > 0) {
            return value;
        }
        if (value == Integer.MIN_VALUE) {
            throw new AbsFunctionOverflowException(value);
        }
        return -value;
    }
}
