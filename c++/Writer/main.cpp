
#include "Writer.h"
#include <iostream>

using namespace std;

int main() {
    Writer w;
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;
        if (s == "putChar") {
            char c;
            cin >> c;
            w.putChar(c);
        }
        else if (s == "putInt") {
            int x;
            cin >> x;
            w.putInt(x);
        }
        else if (s == "print"){
            w.print();
        }
        else if (s == "putString") {
            string s;
            cin >> s;
            w.putString(s);
        }
        else {
            throw "Error: command \"" + s + "\" not found";
        }

    }


    return 0;
}