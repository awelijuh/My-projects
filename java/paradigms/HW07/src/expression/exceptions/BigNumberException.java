package expression.exceptions;

/**
 * Created by Awelijuh on 26.04.2017.
 */
public class BigNumberException extends ParserException {
    public BigNumberException(String s, String ex, int pos) {
        super("The number is too " + (s.charAt(0) == '-' ? "small" : "big") + "\"" + s + "\"", ex, pos);
    }
}
