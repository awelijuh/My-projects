package expression;

/**
 * Created by Awelijuh on 28.03.2017.
 */
abstract public class Operation extends AbstractExpression {
    protected TripleExpression firstExpression;
    protected TripleExpression secondExpression;

    Operation(TripleExpression firstExpression, TripleExpression secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }

    abstract protected int calculate(int firstValue, int secondValue);

    public int evaluate(int x, int y, int z) {
        return calculate(firstExpression.evaluate(x, y, z), secondExpression.evaluate(x, y, z));
    }


}
