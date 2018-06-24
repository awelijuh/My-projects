package expression.parser;

import expression.*;
import expression.exceptions.*;

/**
 * Created by Awelijuh on 09.04.2017.
 */
public class ExpressionParser implements Parser {

    private enum Lexeme {
        VAR, CONST, PLUS, MINUS, MUL, DIV, READY, ABS, OPEN, CLOSE, SQRT, MIN, MAX
    }

    private Lexeme lexeme;
    private int pos, endPos;
    private int prevPos;
    private String expression;

    public TripleExpression parse(String expression) throws UnknownWordParserException, NotSecondArgumentExpressionParserException, InvalidExpressionParserException, BracketsBalanceArithmeticException, NotArgumentExpressionParserException, NotFirstArgumentExpressionParserException, NotArgumentFunctionParserException, BigNumberException {
        pos = 0;
        endPos = -1;
        prevPos = 0;
        expression += " ";
        this.expression = expression;
        next();

        bracketsBalance();

        TripleExpression x = parsingFour();

        if (lexeme != Lexeme.READY) {
            throw new ExtraCharOrMissingOperationInvalidExpressionParserException(expression, pos);
        }
        return x;
    }

    private void bracketsBalance() throws BracketsBalanceArithmeticException {
        int bal = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                bal++;
            } else if (expression.charAt(i) == ')') {
                bal--;
            }
            if (bal < 0) {
                throw new ExcessCloseBracketsBalanceArithmeticException(expression, i);
            }
        }
        if (bal != 0) {
            throw new ExcessOpenBracketsBalanceArithmeticException(expression, expression.length());
        }
    }


    private void next() throws UnknownWordParserException {
        prevPos = pos;
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
            identifyOperator();
        }

    }

    private void identifyOperator() throws UnknownWordParserException {
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
            default:
                throw new UnknownWordParserException(expression.substring(pos, pos + 1), expression, pos);

        }
    }

    private void identifyWord() throws UnknownWordParserException {
        endPos = pos;
        while (Character.isAlphabetic(expression.charAt(endPos))) {
            endPos++;
        }
        endPos--;
        String s = expression.substring(pos, endPos + 1);

        switch (s) {
            case "abs":
                correctWord();
                lexeme = Lexeme.ABS;
                break;
            case "sqrt":
                correctWord();
                lexeme = Lexeme.SQRT;
                break;
            case "min":
                correctWord();
                lexeme = Lexeme.MIN;
                break;
            case "max":
                correctWord();
                lexeme = Lexeme.MAX;
                break;
            case "x":
                lexeme = Lexeme.VAR;
                break;
            case "y":
                lexeme = Lexeme.VAR;
                break;
            case "z":
                lexeme = Lexeme.VAR;
                break;
            default:
                throw new UnknownWordParserException(s, expression, pos);
        }

    }

    private void correctWord() throws UnknownWordParserException {
        if (Character.isDigit(expression.charAt(endPos + 1))) {
            throw new UnknownWordParserException(expression.substring(pos, endPos + 2), expression, pos);
        }
    }

    private void grabNumber() {
        endPos = pos;
        while (Character.isDigit(expression.charAt(endPos))) {
            endPos++;
        }
        lexeme = Lexeme.CONST;
        endPos--;
    }


    private TripleExpression parsingOne() throws UnknownWordParserException, NotSecondArgumentExpressionParserException, InvalidExpressionParserException, NotArgumentExpressionParserException, NotFirstArgumentExpressionParserException, NotArgumentFunctionParserException, BigNumberException {
        TripleExpression t = null;
        switch (lexeme) {
            case CONST:
                t = new Const(valueLexeme(false));
                break;
            case VAR:
                t = new Variable(nameLexeme());
                break;
            case MINUS:
                next();
                if (lexeme == Lexeme.CONST) {
                    t = new Const(valueLexeme(true));
                } else {
                    t = parsingOne();
                    isNotArgument(t, Lexeme.MINUS);
                    return new CheckedNegate(t);
                }
                break;
            case ABS:
                next();
                t = parsingOne();
                isNotArgument(t, Lexeme.ABS);
                return new CheckedAbs(t);
            case SQRT:
                next();
                t = parsingOne();
                isNotArgument(t, Lexeme.SQRT);
                return new CheckedSqrt(t);
            case OPEN:
                next();
                if (lexeme == Lexeme.CLOSE) {
                    throw new EmptyBracketsInvalidExpressionParserException(expression, pos);
                }
                t = parsingFour();
                break;
            case CLOSE:
                break;
            default:
                throw new NotArgumentExpressionParserException(expression, pos);

        }
        next();
        return t;
    }

    private void isNotArgument(TripleExpression t, Lexeme l) throws NotArgumentFunctionParserException {
        if (t == null) {
            throw new NotArgumentFunctionParserException(l.toString(), expression, prevPos);
        }
    }


    private int valueLexeme(boolean b) throws BigNumberException {
        int r;
        String s = (b ? "-" : "") + expression.substring(pos,endPos + 1);
        try {
            r = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new BigNumberException(s, expression, pos);
        }

        return r;
    }

    private String nameLexeme() {
        return expression.substring(pos, endPos + 1);
    }

    private TripleExpression parsingTwo() throws UnknownWordParserException, NotSecondArgumentExpressionParserException, InvalidExpressionParserException, NotArgumentExpressionParserException, NotFirstArgumentExpressionParserException, NotArgumentFunctionParserException, BigNumberException {
        TripleExpression t = parsingOne();
        while (lexeme == Lexeme.MUL || lexeme == Lexeme.DIV) {
            isFirstArgument(t);
            Lexeme l = lexeme;
            next();
            isSecondArgument(l);
            if (l == Lexeme.MUL) {
                t = new CheckedMultiply(t, parsingOne());
            } else {
                t = new CheckedDivide(t, parsingOne());
            }
        }
        return t;
    }

    private TripleExpression parsingThree() throws UnknownWordParserException, NotSecondArgumentExpressionParserException, InvalidExpressionParserException, NotArgumentExpressionParserException, NotFirstArgumentExpressionParserException, NotArgumentFunctionParserException, BigNumberException {
        TripleExpression t = parsingTwo();
        while (lexeme == Lexeme.PLUS || lexeme == Lexeme.MINUS) {
            isFirstArgument(t);
            Lexeme l = lexeme;
            next();
            isSecondArgument(l);
            if (l == Lexeme.PLUS) {
                t = new CheckedAdd(t, parsingTwo());
            } else {
                t = new CheckedSubtract(t, parsingTwo());
            }
        }
        return t;
    }

    private TripleExpression parsingFour() throws UnknownWordParserException, NotSecondArgumentExpressionParserException, InvalidExpressionParserException, NotArgumentExpressionParserException, NotFirstArgumentExpressionParserException, NotArgumentFunctionParserException, BigNumberException {
        TripleExpression t = parsingThree();

        while (lexeme == Lexeme.MAX || lexeme == Lexeme.MIN) {
            isFirstArgument(t);
            Lexeme l = lexeme;
            next();
            isSecondArgument(l);
            if (l == Lexeme.MIN) {
                t = new CheckedMin(t, parsingThree());
            } else {
                t = new CheckedMax(t, parsingThree());
            }
        }
        return t;

    }

    private void isSecondArgument(Lexeme l) throws NotSecondArgumentExpressionParserException {
        if (lexeme == Lexeme.READY || lexeme == Lexeme.CLOSE) {
            throw new NotSecondArgumentExpressionParserException(l.toString(), expression, prevPos);
        }
    }

    private void isFirstArgument(TripleExpression t) throws NotFirstArgumentExpressionParserException {
        if (t == null) {
            throw new NotFirstArgumentExpressionParserException(lexeme.toString(), expression, prevPos);
        }
    }

    public static String WhiteSpaceGen(int k) {
        StringBuilder t = new StringBuilder();
        for (int i = 0; i < k; i++)
            t.append(' ');
        return t.toString();
    }




}
