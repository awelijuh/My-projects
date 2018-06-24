#include <iostream>
#include "Calculator.h"
#include "Writer.h"

int main() {
    Calculator c;
    std::string s;
    Writer x;
    std::getline(std::cin, s);
    x.putString(s);
    x.putChar('=');

    try {
        x.putInt(c.calculate(s));
        x.print();
    } catch (std::string s) {
        std::cout << "\n" << s << "\n";
    }
    std::cin >> s;
    return 0;
}