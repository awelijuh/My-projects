//
// Created by Awelijuh on 07.10.2017.
//

#ifndef CALCULATOR_SYMBOLRECTANGLE_H
#define CALCULATOR_SYMBOLRECTANGLE_H


#include <string>
#include <vector>

class SymbolRectangle {
private:
    std::vector<std::vector<bool> > s;
    int row;
    int column;
    void calculateSize();

public:
    SymbolRectangle(std::vector<std::vector<bool> > &s, int scale = 1);
    SymbolRectangle(SymbolRectangle &symbolRectangle, int scale = 1);
    SymbolRectangle();
    void print(char symbolTrue, char symbolFalse = ' ');
    void addToRight(SymbolRectangle symbolRectangle);
    void addToDown(SymbolRectangle symbolRectangle);
    void increaseScale(int d);

    void increaseSize(int x, int y);
    int getRow();
    int getColumn();


};


#endif //CALCULATOR_SYMBOLRECTANGLE_H
