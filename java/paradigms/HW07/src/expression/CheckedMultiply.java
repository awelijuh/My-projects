package expression;

import expression.exceptions.MultiplyOperationOverflowException;

/**
 * Created by Awelijuh on 28.03.2017.
 */
public class CheckedMultiply extends Operation {

    public CheckedMultiply(TripleExpression firstExpression, TripleExpression secondExpression) {
        super(firstExpression, secondExpression);
    }

    protected int calculate(int firstValue, int secondValue) {
        if (firstValue == 0 || secondValue == 0) {
            return 0;
        }
        if (firstValue > secondValue) {
            return calculate(secondValue, firstValue);
        }

        if (firstValue < 0) {
            if (secondValue < 0) {
                if (firstValue <Integer.MAX_VALUE / secondValue) {
                    throw new MultiplyOperationOverflowException(firstValue, secondValue);
                }
            } else if (secondValue > 0) {
                if (Integer.MIN_VALUE / secondValue > firstValue) {
                    throw new MultiplyOperationOverflowException(firstValue, secondValue);
                }
            }
        } else  if (firstValue > 0) {
            if (firstValue > Integer.MAX_VALUE / secondValue) {
                throw new MultiplyOperationOverflowException(firstValue, secondValue);
            }
        }

        return firstValue * secondValue;
    }


}
