package expression;

import expression.parser.ExpressionParser;
import expression.parser.Parser;

/**
 * Created by Awelijuh on 28.03.2017.
 */
public class Main {

    public static void main(String[] args) {
        ExpressionParser p = new ExpressionParser();
        System.out.print(p.parse("(square x) - 2 * x + 1").evaluate(3,0,0));

    }


}
