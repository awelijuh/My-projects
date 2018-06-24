package expression.exceptions;

import expression.parser.ExpressionParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Awelijuh on 26.04.2017.
 */
public class ParserException extends Exception{
    public ParserException(String s, String ex, int pos) {
        super(s + "\n" + ex + "\n" + ExpressionParser.WhiteSpaceGen(pos) + "^");
    }
}
