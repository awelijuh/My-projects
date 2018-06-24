package expression;
import expression.exceptions.SqrtArithmeticException;
/**
 * Created by Awelijuh on 11.04.2017.
 */
public class CheckedSqrt extends Function {

    public CheckedSqrt(TripleExpression expression) {
        super(expression);
    }

    protected int calculate(int value) {
        if (value < 0) {
            throw new  SqrtArithmeticException(value);
        }
        return sqrt(value);
    }



    int sqrt(int value) {
        if (value == 0) {
            return 0;
        }
        int l = 1;
        int r = Integer.MAX_VALUE >> 1;
        while (l < r) {
            int m = ((l + r) >> 1) + ((l + r) & 1);
            if (Integer.MAX_VALUE / m < m || m * m > value) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        return l;
    }


}
