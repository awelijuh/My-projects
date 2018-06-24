package expression;


/**
 * Created by Awelijuh on 28.03.2017.
 */
abstract public class AbstractExpression implements CommonExpression {

    abstract public int evaluate(int x);

    abstract public double evaluate(double x);

    abstract public int evaluate(int x, int y, int z);

}
