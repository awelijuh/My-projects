//
// Created by Awelijuh on 23.09.2017.
//

#include "Calculator.h"
#include <cstdlib>
#include <cstdio>
#include <iostream>

const int NONE = INT_MAX;

int Calculator::calculate(std::string s) {
    expression = s;
    checkBracketsBalance();
    pos = 0;
    prevPos = 0;

    endPos = -1;
    expression += " ";
    next();
    return fourthParse();
}

std::string to_string(int x) {
    char c[10];
    sprintf(c, "%d", x);
    return (std::string)c;
}

void Calculator::next() {
    prevPos = pos;
    pos = endPos + 1;
    Lexem l = lexem;

    while (pos < expression.size() && expression[pos] == ' ') {
        pos++;
    }
    if (pos == expression.size()) {
        lexem = READY;
        return;
    }
    char c = expression[pos];
    endPos = pos;

    if ( '0' <= c && c <= '9') {
        grabNumber();
    }
    else {
        identifyOperator();
    }
    if ((l == CLOSE && lexem == OPEN) || (l == NUMBER && lexem == OPEN) || (l == CLOSE && lexem == NUMBER) || (l == NUMBER && lexem == NUMBER)) {
        throw to_string(pos) + ": Operator not found";
    }

}

void Calculator::grabNumber() {
    endPos = pos;
    while ('0' <= expression[endPos] && expression[endPos] <= '9') {
        endPos++;
    }
    lexem = NUMBER;
    endPos--;
}

void Calculator::identifyOperator() {
    switch (expression[pos]) {
        case '+':
            lexem = PLUS;
            break;
        case '-':
            lexem = MINUS;
            break;
        case '*':
            lexem = MULTIPLY;
            break;
        case '/':
            lexem = DIVIDE;
            break;
        case '(':
            lexem = OPEN;
            break;
        case ')':
            lexem = CLOSE;
            break;
        case 'C':
            lexem = C;
            break;
        case ',':
            lexem = COMMA;
            break;
        default:
            std::string s = to_string(pos) + ": unknown word";
            throw s;
            break;
    }

}

int Calculator::fourthParse() {
    int t = thirdParse();
    isFirstArgument(t);
    while (lexem == PLUS || lexem == MINUS) {
        Lexem  l = lexem;
        next();
        isSecondArgument(lexem);
        if (l == PLUS) {
            t += thirdParse();
        }
        else {
            t -= thirdParse();
        }
    }
    return t;
}

int Calculator::thirdParse() {
    int t = secondParse();
    isFirstArgument(t);
    while (lexem == MULTIPLY || lexem == DIVIDE) {
        Lexem  l = lexem;
        next();
        isSecondArgument(lexem);
        if (l == MULTIPLY) {
            t *= secondParse();
        }
        else {
            t /= secondParse();
        }
    }
    return t;
}

int Calculator::secondParse() {
    int t = firstParse();
    isFirstArgument(t);
    if (lexem == COMMA) {
        next();
        isSecondArgument(lexem);
        t = cnk(t,firstParse());
    }
    return t;
}


int Calculator::firstParse() {
    int t = NONE;
    switch (lexem) {
        case READY:
            break;
        case NUMBER:
            t = valueLexem();

            break;
        case MINUS:
            next();
            if (lexem == NUMBER) {
                t = -valueLexem();
            }
            else {
                int t  = -firstParse();
                isNotArgument(t, prevPos);
                return t;
            }
            break;
        case OPEN:
            next();
            if (lexem == CLOSE) {
                std::string s = to_string(pos) + ": empty brackets";
                throw s;
            }
            t = fourthParse();
            break;
        case C:
            next();
            t = fourthParse();
            break;
        case CLOSE:
            break;
        default:
            isNotArgument(NONE, pos);
    }
    next();
    return t;


}

int Calculator::valueLexem() {
    return atoi(expression.substr(pos, endPos - pos + 1).c_str());
}

int Calculator::cnk(int x, int y) {
    if (x < 0 || y < 0) {
        std::string s = to_string(pos) + ": C(n,k) n < 0 or k < 0";
        throw s;
    }
    int r = 1;
    y = std::max(y, x - y);
    for (int i = y + 1; i <= x; i++) {
        r *= i;
    }
    for (int i = 2; i <= x - y; i++) {
        r /= i;
    }
    return r;
}

void Calculator::isSecondArgument(Calculator::Lexem l) {
    if (l == READY || l == CLOSE) {
        std::string s = to_string(prevPos) + ": not second argument";
        throw s;
    }
}

void Calculator::isNotArgument(int t, int l) {
    if (t == NONE || lexem == READY) {
        throw to_string(l) + ": not argument";
    }
}

void Calculator::isFirstArgument(int l) {
    if (l == NONE) {
        std::string s = to_string(prevPos) + ": not first argument";

        throw s;
    }
}

void Calculator::checkBracketsBalance() {
    int balance = 0;
    int cBalance = 0;
    for (int i = 0; i < expression.size(); i++) {
        if (expression[i] == '(') {
            balance++;
        }
        else if (expression[i] == ')') {
            balance--;
        }
        if (balance < 0) {
            std::string s = to_string(i) + ": open bracket not found";
            std::cout << "\n" << s;
            throw s;
        }
        if (expression[i] == 'C') {
            cBalance++;
        }
        else if (expression[i] == ',') {
            cBalance--;
        }
        if (cBalance < 0) {
            throw to_string(i) + ": C not found";
        }

    }
    if (balance != 0) {
        std::string s = to_string(expression.size()) + ": close bracket not found";

        throw s;
    }
    if (cBalance != 0) {
        throw (std::string)", not found";
    }

}




