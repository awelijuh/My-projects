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
        if (name.equals("x")) {
            return x;
        }
        return 0;
    }

    public double evaluate(double x) {
        if (name.equals("x")) {
            return x;
        }
        return 0;
    }

    public int evaluate(int x, int y, int z) {
        if (name.equals("x")) {
            return x;
        } else if (name.equals("y")) {
            return y;
        } else if (name.equals("z")) {
            return z;
        }
        return 0;
    }


    public static boolean isVariable(String s, int l, int r) {
        return s.length() == 1 && (s.charAt(l) == 'x' || s.charAt(l) == 'y' || s.charAt(l) == 'z');
    }
}
