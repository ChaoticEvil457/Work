#include <iostream>
#include "items.h"

using namespace std;
using namespace DS;

int main() {

    items a;
    items b(50);
    items c;
    items *p = &b;

    cout << a << endl;
    cout << b << endl;
    cout << c << endl;

    a.set("apple");
    b.set(530);
    c.set(b);

    cout << a << endl;
    cout << b << endl;
    cout << c << endl;
    cout << boolalpha << a.same(&b) << endl;
    cout << boolalpha << a.same(&c) << endl;
    cout << boolalpha << b.same(p) << endl;

    return 0;
}