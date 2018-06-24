package expression;

import expression.exceptions.*;
import expression.parser.ExpressionParser;

import java.util.Scanner;

/**
 * Created by Awelijuh on 28.03.2017.
 */
public class Main {

    public static void main(String[] args) throws InvalidExpressionParserException, UnknownWordParserException, NotSecondArgumentExpressionParserException, BracketsBalanceArithmeticException, NotArgumentExpressionParserException, NotFirstArgumentExpressionParserException, NotArgumentFunctionParserException, BigNumberException {
        ExpressionParser p = new ExpressionParser();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        System.out.println(p.parse(s).evaluate(x, y, z));

    }


}
