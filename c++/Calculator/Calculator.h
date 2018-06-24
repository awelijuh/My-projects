//
// Created by Awelijuh on 23.09.2017.
//

#ifndef CALCULATOR_PARSER_H
#define CALCULATOR_PARSER_H


#include <string>

class Calculator {
private:
    enum Lexem {PLUS, MINUS, MULTIPLY, DIVIDE, OPEN, CLOSE, READY, NUMBER, C, COMMA};
    Lexem lexem;
    int pos, endPos, prevPos;
    std::string expression;

    void next();
    int fourthParse();
    int thirdParse();
    int firstParse();
    int secondParse();
    void isSecondArgument(Lexem l);
    void isFirstArgument(int l);
    void isNotArgument(int t, int l);
    void checkBracketsBalance();
    int cnk(int x, int y);

    void grabNumber();
    void identifyOperator();

    int valueLexem();



public:
    int calculate(std::string s);


};


#endif //CALCULATOR_PARSER_H
