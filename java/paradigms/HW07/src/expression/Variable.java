package expression;

/**
 * Created by Awelijuh on 28.03.2017.
 */
public class Variable extends Number {
    private String name;

    public Variable(String name) {
        this.name = name;
    }



    public int evaluate(int x, int y, int z) {
        switch (name) {
            case "x":
                return x;
            case "y":
                return y;
            case "z":
                return z;
        }
        return 0;
    }


}
