//============================================================================
// Name        : lablisttplitr.cpp
// Author      :
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string>
#include "list.h"
#include "list.cpp"

using namespace DS;

template <typename T>
std::ostream &operator<<(std::ostream &out, const list<T> &);

template <typename T>
void addItem(list<T> &, const T &);

int main()
{

    list<int> numbers;

    numbers.insert(12);
    numbers.insert(34);

    std::cout << numbers << std::endl;

    addItem(numbers, 10);

    std::cout << numbers << std::endl;

    list<std::string> names;
    std::string last = " Foo";

    names.insert("Wendy");
    names.insert("Marcus");

    std::cout << names << std::endl;

    addItem(names, last);

    std::cout << names << std::endl;

    return 0;
}

template <typename T>
void addItem(list<T> &container, const T &item)
{
    for (auto it = container.begin(); it != container.end(); ++it)
    {
        *it += item;
    }
}

template <typename T>
std::ostream &operator<<(std::ostream &out, const list<T> &container)
{
    for (auto it = container.cbegin(); it != container.cend(); ++it)
    {
        out << "->[" << *it << "]";
    }
    out << "--X";
    return out;
}
