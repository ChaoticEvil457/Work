#include <iostream>

using std::cout;
using std::cin;
using std::endl;


int main(void){


    int i = 7;
    int j = 2;
    int &r = j;
    j = j + 1;
    cout << r << endl;

    int *n = &r;
    cout << n << " " << j << endl;
}