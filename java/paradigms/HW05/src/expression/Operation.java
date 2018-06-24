package expression;

/**
 * Created by Awelijuh on 28.03.2017.
 */
abstract public class Operation extends AbstractExpression {
    protected CommonExpression firstExpression;
    protected CommonExpression secondExpression;

    abstract protected int calculate(int firstValue, int secondValue);
    abstract protected double calculate(double firstValue, double secondValue);

    public int evaluate(int x) {
        return calculate(firstExpression.evaluate(x), secondExpression.evaluate(x));
    }

    public double evaluate(double x) {
        return calculate(firstExpression.evaluate(x), secondExpression.evaluate(x));
    }

    public int evaluate(int x, int y, int z) {
        return calculate(firstExpression.evaluate(x, y, z), secondExpression.evaluate(x, y, z));
    }


}
