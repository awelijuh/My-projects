package expression;


import expression.exceptions.AddOperationOverflowException;

/**
 * Created by Awelijuh on 28.03.2017.
 */
public class CheckedAdd extends Operation {

    public CheckedAdd(TripleExpression firstExpression, TripleExpression secondExpression) {
        super(firstExpression, secondExpression);
    }

    protected int calculate(int firstValue, int secondValue) {
        int result = firstValue + secondValue;
        if (((firstValue ^ result) & (secondValue ^ result)) < 0) {
            throw new AddOperationOverflowException(firstValue, secondValue);
        }
        return result;
    }




}
