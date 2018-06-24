package expression.parser;

import expression.*;

/**
 * Created by Awelijuh on 09.04.2017.
 */
public class ExpressionParser implements Parser {

    private enum Lexeme {
        VAR, CON, PLUS, MINUS, MUL, DIV, READY, SQUARE, ABS, OPEN, CLOSE, LEFT, RIGHT,
        MOD, SQRT, MIN, MAX
    }

    private Lexeme lexeme;
    private int pos, endPos;
    private String expression;

    public TripleExpression parse(String expression) {
        pos = 0;
        endPos = -1;
        expression += " ";
        this.expression = expression;
        next();
        return parsingFour();
    }


    private void next() {
        pos = endPos + 1;
        while (pos < expression.length() && Character.isWhitespace(expression.charAt(pos))) {
            pos++;
        }
        if (pos == expression.length()) {
            lexeme = Lexeme.READY;
            return;
        }

        char c = expression.charAt(pos);

        endPos = pos;
        if (Character.isDigit(c)) {
            grabNumber();
        } else if (Character.isAlphabetic(c)) {
            identifyWord();
        } else {
            identifyOprerator();
        }

    }

    private void identifyOprerator() {
        switch (expression.charAt(pos)) {
            case '+':
                lexeme = Lexeme.PLUS;
                break;
            case '-':
                lexeme = Lexeme.MINUS;
                break;
            case '*':
                lexeme = Lexeme.MUL;
                break;
            case '/':
                lexeme = Lexeme.DIV;
                break;
            case '(':
                lexeme = Lexeme.OPEN;
                break;
            case ')':
                lexeme = Lexeme.CLOSE;
                break;
            case '<':
                endPos++;
                lexeme = Lexeme.LEFT;
                break;
            case '>':
                endPos++;
                lexeme = Lexeme.RIGHT;
                break;
        }
    }

    private void identifyWord() {
        endPos = pos;
        while (Character.isAlphabetic(expression.charAt(endPos))) {
            endPos++;
        }
        endPos--;
        String s = expression.substring(pos, endPos + 1);

        switch (s) {
            case "abs":
                lexeme = Lexeme.ABS;
                break;
            case "square":
                lexeme = Lexeme.SQUARE;
                break;
            case "mod":
                lexeme = Lexeme.MOD;
                break;
            case "sqrt":
                lexeme = Lexeme.SQRT;
                break;
            case "min":
                lexeme = Lexeme.MIN;
                break;
            case "max":
                lexeme = Lexeme.MAX;
                break;
            default:
                lexeme = Lexeme.VAR;
                break;
        }

    }

    private void grabNumber() {
        endPos = pos;
        while (Character.isDigit(expression.charAt(endPos))) {
            endPos++;
        }
        lexeme = Lexeme.CON;
        endPos--;
    }


    private CommonExpression parsingOne() {
        CommonExpression t = null;
        switch (lexeme) {
            case READY:
                return null;
            case CON:
                t = new Const(valueLexem());
                break;
            case VAR:
                t = new Variable(nameLexem());
                break;
            case MINUS:
                next();
                if (lexeme == Lexeme.CON) {
                    t = new Const(-valueLexem());
                } else {
                    return new UnaryMinus(parsingOne());
                }
                break;
            case ABS:
                next();
                return new Abs(parsingOne());
            case SQRT:
                next();
                return new Sqrt(parsingOne());
            case SQUARE:
                next();
                return new Square(parsingOne());
            case OPEN:
                next();
                t = parsingFour();
                break;
            case CLOSE:
                break;

        }
        next();
        return t;
    }

    private int valueLexem() {
        return Integer.parseUnsignedInt(expression.substring(pos, endPos + 1));
    }

    private String nameLexem() {
        return expression.substring(pos, endPos + 1);
    }

    private CommonExpression parsingTwo() {
        CommonExpression t = parsingOne();
        while (lexeme == Lexeme.MUL || lexeme == Lexeme.DIV || lexeme == Lexeme.MOD) {
            Lexeme l = lexeme;
            next();
            if (l == Lexeme.MUL) {
                t = new Multiply(t, parsingOne());
            } else if (l == Lexeme.DIV) {
                t = new Divide(t, parsingOne());
            } else {
                t = new Module(t, parsingOne());
            }
        }
        return t;
    }

    private CommonExpression parsingThree() {
        CommonExpression t = parsingTwo();
        while (lexeme == Lexeme.PLUS || lexeme == Lexeme.MINUS) {
            Lexeme l = lexeme;
            next();
            if (l == Lexeme.PLUS) {
                t = new Add(t, parsingTwo());
            } else {
                t = new Subtract(t, parsingTwo());
            }
        }
        return t;
    }

    private CommonExpression parsingFour() {
        CommonExpression t = parsingThree();
        while (lexeme == Lexeme.LEFT || lexeme == Lexeme.RIGHT) {
            Lexeme l = lexeme;
            next();
            if (l == Lexeme.LEFT) {
                t = new ShiftLeft(t, parsingThree());
            } else {
                t = new ShiftRight(t, parsingThree());
            }
        }
        return t;

    }







}
