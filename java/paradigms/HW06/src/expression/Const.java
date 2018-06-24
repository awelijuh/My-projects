package expression;

/**
 * Created by Awelijuh on 28.03.2017.
 */
public class Const extends Number {
    private double value;

    public Const(int value) {
        this.value = (double) value;
    }

    public Const(double value) {
        this.value = value;
    }

    public Const(String s) {
        value = Double.parseDouble(s);
    }

    public int evaluate(int x) {
        return (int) value;
    }

    public double evaluate(double x) {
        return value;
    }

    public int evaluate(int x, int y, int z) {
        return (int) value;
    }

    public static boolean isConst(String s, int l, int r) {
        for (int i = l; i< r; i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
