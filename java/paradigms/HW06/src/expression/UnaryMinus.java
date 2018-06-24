package expression;

/**
 * Created by Awelijuh on 11.04.2017.
 */
public class UnaryMinus extends Function {

    public UnaryMinus(CommonExpression expression) {
        this.expression = expression;
    }

    protected int calculate(int value) {
        return -value;
    }

    protected double calculate(double value) {
        return -value;
    }

}
