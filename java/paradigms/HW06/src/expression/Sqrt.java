package expression;

/**
 * Created by Awelijuh on 11.04.2017.
 */
public class Sqrt extends Function {

    public Sqrt(CommonExpression expression) {
        this.expression = expression;
    }

    protected int calculate(int value) {
        return (int) Math.sqrt((double) value);
    }


    protected double calculate(double value) {
        return Math.sqrt(value);
    }
}
