package expression;

/**
 * Created by Awelijuh on 28.03.2017.
 */
public class Variable extends Number {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    public int evaluate(int x) {
        if (name == "x") {
            return x;
        }
        return 0;
    }

    public double evaluate(double x) {
        if (name == "x") {
            return x;
        }
        return 0;
    }

    public int evaluate(int x, int y, int z) {
        if (name == "x") {
            return x;
        } else if (name == "y") {
            return y;
        } else if (name == "z") {
            return z;
        }
        return 0;
    }



}
