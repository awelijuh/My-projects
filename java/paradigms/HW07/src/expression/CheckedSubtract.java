package expression;


import expression.exceptions.SubtractOperationOverflowException;

/**
 * Created by Awelijuh on 28.03.2017.
 */
public class CheckedSubtract extends Operation {

    public CheckedSubtract(TripleExpression firstExpression, TripleExpression secondExpression) {
        super(firstExpression, secondExpression);
    }

    protected int calculate(int firstValue, int secondValue) {
        int result = firstValue - secondValue;
        if (((firstValue ^ secondValue) & (firstValue ^ result)) < 0) {
            throw new SubtractOperationOverflowException(firstValue, secondValue);
        }

        return firstValue - secondValue;
    }

}
