package expression;

/**
 * Created by Awelijuh on 11.04.2017.
 */
abstract public class Function extends AbstractExpression {
    TripleExpression expression;

    Function(TripleExpression expression) {
        this.expression = expression;
    }

    abstract protected int calculate(int value);


    public int evaluate(int x, int y, int z) {
        return calculate(expression.evaluate(x, y, z));
    }

}
