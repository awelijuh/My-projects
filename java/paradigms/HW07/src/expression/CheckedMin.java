package expression;

/**
 * Created by Awelijuh on 19.04.2017.
 */
public class CheckedMin extends Operation {

    public CheckedMin(TripleExpression firstExpression, TripleExpression secondExpression) {
        super(firstExpression, secondExpression);
    }


    @Override
    protected int calculate(int firstValue, int secondValue) {
        return firstValue < secondValue ? firstValue : secondValue;
    }

}
