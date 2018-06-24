package expression;

/**
 * Created by Awelijuh on 28.03.2017.
 */
public class Const extends Number {
    private int value;

    public Const(int value) {
        this.value = value;
    }

    public int evaluate(int x, int y, int z) {
        return value;
    }


}
