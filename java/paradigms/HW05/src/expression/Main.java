package expression;

/**
 * Created by Awelijuh on 28.03.2017.
 */
public class Main {

    public static void main(String[] args) {
        Expression expression = new Add(
                new Subtract(
                    new Multiply(
                        new Variable("x"),
                        new Variable("x")
                    ),
                    new Multiply(
                            new Const(2),
                            new Variable("x")
                    )
                ),
                new Const(1)
        );

        System.out.print(expression.evaluate(Integer.parseInt(args[0])));

    }


}
