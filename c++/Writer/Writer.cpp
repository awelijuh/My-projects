//
// Created by Awelijuh on 22.09.2017.
//

#include <fstream>
#include <cstring>
#include <algorithm>
#include <iostream>
#include <queue>
#include <stack>
#include "Writer.h"

void Writer::isFileDamaged(std::ifstream &in) {
    if (in.eof()) {
        in.close();
        throw "file \'numbers.txt\' damaged";
    }
}


Writer::Writer() {
    std::ifstream in("numbers.txt");
    if (!in.is_open()) {
        in.close();
        throw "file \'numbers.txt\' not found";
    }

    isFileDamaged(in);
    in >> standard_row;
    isFileDamaged(in);
    in >>standard_column;
    isFileDamaged(in);
    in >> scale;
    isFileDamaged(in);
    in >> symbol;





    while (!in.eof()) {
        char c;
        isFileDamaged(in);
        in >> c;
        if (in.eof())
            break;
        for (int i = 0; i < standard_row; i++) {
            s[c].emplace_back();
            for (int j = 0; j < standard_column; j++) {
                char p;
                isFileDamaged(in);
                in >> p;
                s[c][i].push_back(p - '0');
            }
        }
    }

    s[' '].assign(standard_row, std::vector<bool>(standard_column, false));
    space = (s[' ']);

    in.close();

}

void Writer::putChar(char c) {
    list.push_back(c);
}

void Writer::putInt(int x) {
    std::string q;
    do {
        q.push_back((x % 10) + '0');
        x /= 10;
    } while (x != 0);
    std::reverse(q.begin(), q.end());
    list += q;
}


void Writer::print() {
    for (size_t i = 0; i < list.size(); i++) {
        if (s[list[i]].empty()) {
            std::string t = "symbol \'" + list.substr(i, i + 1) + "\' not found";
            throw t;
        }
    }

    make(scale, symbolRectangle, 0);
    symbolRectangle.print(symbol);
}

void Writer::putString(std::string s) {
    list += s;
}


int Writer::make(int scale, SymbolRectangle& e, int pos) {

    int balance = 0;
    for (int i = pos; i < list.size(); i++) {
        if (list[i] == 'C') {
            int x = i + 2;
            SymbolRectangle l;
            x = make(scale, l, x);
            x++;
            SymbolRectangle r;

            x = make(scale, r, x);

            if (l.getRow() > r.getRow()) {
                r.increaseScale(l.getRow() / r.getRow());
            }
            else {
                l.increaseScale(r.getRow() / l.getRow());
            }

            SymbolRectangle u(s[list[i]], scale);
            e.addToRight(u);
            u = space;
            u.increaseScale(r.getRow() / standard_row);
            r.addToDown(u);
            r.addToDown(l);
            e.increaseScale(r.getRow() / e.getRow());

            e.addToRight(r);
            i = x;
            scale =  e.getRow() / standard_row;
        }
        else if (list[i] == ',' || (balance == 0 && list[i] == ')')) {
            pos = i;
            return i;
        }
        else {
            if (list[i] == '(') {
                balance++;
            }
            else if (list[i] == ')') {
                balance--;
            }
            SymbolRectangle q(s[list[i]], scale);
            e.addToRight(q);
        }

    }
    return list.size();
}


