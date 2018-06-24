package expression;

/**
 * Created by Awelijuh on 19.04.2017.
 */
public class CheckedMax extends Operation {

    public CheckedMax(TripleExpression firstExpression, TripleExpression secondExpression) {
        super(firstExpression, secondExpression);
    }

    @Override
    protected int calculate(int firstValue, int secondValue) {
        return firstValue > secondValue ? firstValue : secondValue;
    }

}
