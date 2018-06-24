//
// Created by Awelijuh on 07.10.2017.
//

#include "SymbolRectangle.h"
#include <cstdio>

SymbolRectangle::SymbolRectangle(std::vector<std::vector<bool> > &s, int scale) {
    this->s = s;
    calculateSize();
    increaseScale(scale);
}

SymbolRectangle::SymbolRectangle(SymbolRectangle &symbolRectangle, int scale) {
    this->s = symbolRectangle.s;

    calculateSize();
    increaseScale(scale);
}

void SymbolRectangle::print(char symbolTrue, char symbolFalse) {
    for (size_t i = 0 ; i < s.size(); i++) {
        for (size_t j = 0; j < s[i].size(); j++) {
            printf("%c",s[i][j] ? symbolTrue : symbolFalse);
        }
        printf("\n");
    }
}

void SymbolRectangle::addToRight(SymbolRectangle symbolRectangle) {
    increaseSize(std::max(symbolRectangle.row, row) - row, 0);
    symbolRectangle.increaseSize(std::max(symbolRectangle.row, row) - symbolRectangle.row, 0);
    for (size_t i = 0; i < s.size(); i++) {
        s[i].push_back(false);
        for (size_t j = 0; j < symbolRectangle.s[i].size(); j++) {
            s[i].push_back(symbolRectangle.s[i][j]);
        }
    }
    column += symbolRectangle.column + 1;
}

void SymbolRectangle::addToDown(SymbolRectangle symbolRectangle) {
    increaseSize(0, std::max(symbolRectangle.column, column) - column);
    symbolRectangle.increaseSize(0, std::max(symbolRectangle.column, column) - symbolRectangle.column);
    for (size_t i = 0; i < symbolRectangle.row; i++) {
        s.push_back(symbolRectangle.s[i]);
    }
    row += symbolRectangle.row;
}

void SymbolRectangle::increaseScale(int d) {
    if (d == 0) {
        return;
    }
    std::vector<std::vector<bool> > e;
    for (size_t i = 0; i < row; i++) {
        for (size_t m = 0; m < d; m++) {
            e.push_back(std::vector<bool>());
            for (size_t j = 0; j < column; j++) {
                for (size_t m = 0; m < d; m++) {
                    e.back().push_back(s[i][j]);
                }
            }
        }
    }
    row *= d;
    column *= d;
    s = e;
}

void SymbolRectangle::calculateSize() {
    row = s.size();
    column = 0;
    for (size_t i = 0; i < s.size(); i++) {
        column = std::max(column, (int)s[i].size());
    }
}

void SymbolRectangle::increaseSize(int x, int y) {
    column += y;
    for (size_t i = 0; i < row; i++) {
        for (int j = 0; j < y; j++) {
            s[i].push_back(false);
        }
    }
    row += x;
    for (int i = 0; i < x; i++) {
        s.push_back(std::vector<bool>(column, false));
    }

}

SymbolRectangle::SymbolRectangle() {
    row = 0;
    column = 0;
}

int SymbolRectangle::getRow() {
    return row;
}

int SymbolRectangle::getColumn() {
    return column;
}

