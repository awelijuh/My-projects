package expression;


import expression.exceptions.DivideOperationOverflowException;
import expression.exceptions.DivByZeroArithmeticException;

/**
 * Created by Awelijuh on 28.03.2017.
 */
public class CheckedDivide extends Operation {

    public CheckedDivide(TripleExpression firstExpression, TripleExpression secondExpression) {
        super(firstExpression, secondExpression);
    }

    protected int calculate(int firstValue, int secondValue) {
        if (secondValue == 0) {
            throw new DivByZeroArithmeticException(firstValue, secondValue);
        }
        if (secondValue == -1 && firstValue == Integer.MIN_VALUE) {
            throw new DivideOperationOverflowException(firstValue, secondValue);
        }
        return firstValue / secondValue;
    }

}
