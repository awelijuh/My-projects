package expression;

/**
 * Created by Awelijuh on 11.04.2017.
 */
public class Square extends Function {

    public Square(CommonExpression expression) {
        this.expression = expression;
    }

    protected int calculate(int value) {
        return value * value;
    }

    protected double calculate(double value) {
        return value * value;
    }
}
