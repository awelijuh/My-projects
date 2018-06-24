package expression;

/**
 * Created by Awelijuh on 11.04.2017.
 */
abstract public class Function extends AbstractExpression {
    CommonExpression expression;

    abstract protected int calculate(int value);
    abstract protected double calculate(double value);

    public int evaluate(int x) {
        return calculate(expression.evaluate(x));
    }

    public double evaluate(double x) {
        return calculate(expression.evaluate(x));
    }

    public int evaluate(int x, int y, int z) {
        return calculate(expression.evaluate(x, y, z));
    }

}
