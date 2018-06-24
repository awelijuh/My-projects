#include <stdio.h>
#include <stdbool.h>
#include <time.h>
#include <stdlib.h>

const int scale = 3;
const char symbol = '*';


const int row = 5;
const int column = 3;
bool numbers[11][5][3] = {
    {{1, 1, 1}, {1, 0, 1}, {1, 0, 1}, {1, 0, 1}, {1, 1, 1}},
    {{0, 1, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}},
    {{1, 1, 1}, {0, 0, 1}, {1, 1, 1}, {1, 0, 0}, {1, 1, 1}},
    {{1, 1, 1}, {0, 0, 1}, {1, 1, 1}, {0, 0, 1}, {1, 1, 1}},
    {{1, 0, 1}, {1, 0, 1}, {1, 1, 1}, {0, 0, 1}, {0, 0, 1}},
    {{1, 1, 1}, {1, 0, 0}, {1, 1, 1}, {0, 0, 1}, {1, 1, 1}},
    {{1, 1, 1}, {1, 0, 0}, {1, 1, 1}, {1, 0, 1}, {1, 1, 1}},
    {{1, 1, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}},
    {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}, {1, 0, 1}, {1, 1, 1}},
    {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}, {0, 0, 1}, {1, 1, 1}},
    {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}, {0, 1, 0}, {0, 0, 0}}
};
int t[8];

void print() {
    system("cls");
    for (int i = 0; i < row; i++) {
        for (int m = 0; m < scale; m++) {
            for (int k = 0; k < 8; k++) {
                int x = t[k];
                for (int j = 0; j < column; j++) {
                    for (int m = 0; m < scale; m++) {
                        printf("%c", numbers[x][i][j] ? symbol : ' ');
                    }
                }
                for (int m = 0; m < scale; m++) {
                    printf(" ");
                }
            }
            printf("\n");
        }
    }

}

void memorize_time(time_t x) {
    struct tm *p = localtime(&x);
    t[0] = p->tm_hour / 10;
    t[1] = p->tm_hour % 10;
    t[2] = 10;
    t[3] = p->tm_min / 10;
    t[4] = p->tm_min % 10;
    t[5] = 10;
    t[6] = p->tm_sec / 10;
    t[7] = p->tm_sec % 10;

}

void print_time() {
    time_t x;
    time(&x);
    while (true) {
        while (time(NULL) == x) {}
        time(&x);
        memorize_time(x);
        print();
    }

}


int main() {
    print_time();

    return 0;
}