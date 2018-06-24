package expression;


/**
 * Created by Awelijuh on 28.03.2017.
 */
public class Add extends Operation {

    public Add(CommonExpression firstExpression, CommonExpression secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }

    protected int calculate(int firstValue, int secondValue) {
        return firstValue + secondValue;
    }

    protected double calculate(double firstValue, double secondValue) {
        return firstValue + secondValue;
    }


}
