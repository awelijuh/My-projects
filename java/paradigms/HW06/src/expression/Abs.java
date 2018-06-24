package expression;

/**
 * Created by Awelijuh on 11.04.2017.
 */
public class Abs extends Function {

    public Abs(CommonExpression expression) {
        this.expression = expression;

    }


    protected int calculate(int value) {
        return value > 0 ? value : -value;
    }


    protected double calculate(double value) {
        return value > 0 ? value : -value;
    }
}
