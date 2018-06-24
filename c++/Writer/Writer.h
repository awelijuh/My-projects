//
// Created by Awelijuh on 22.09.2017.
//

#ifndef WRITER_WRITER_H
#define WRITER_WRITER_H


#include <string>
#include <vector>
#include "SymbolRectangle.h"

class Writer {
private:
    std::vector<std::vector<bool> > s[256];

    SymbolRectangle space;
    int standard_row;
    int standard_column;
    int scale;
    char symbol;
    SymbolRectangle symbolRectangle;
    std::string list;
    int make(int scale, SymbolRectangle &symbolRectangle1, int pos);
    void isFileDamaged(std::ifstream &in);

public:
    Writer();
    void putInt(int x);
    void putChar(char c);
    void putString(std::string s);
    void print();


};


#endif //WRITER_WRITER_H
