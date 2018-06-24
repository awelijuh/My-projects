package expression;

/**
 * Created by Awelijuh on 11.04.2017.
 */
public class Module extends Operation {

    public Module(CommonExpression firstExpression, CommonExpression secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }

    protected int calculate(int firstValue, int secondValue) {
        return firstValue % secondValue;
    }


    protected double calculate(double firstValue, double secondValue) {
        return 0;
    }
}
