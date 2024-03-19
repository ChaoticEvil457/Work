
#ifndef LAB_BIG_OH_NUMBERS_H
#define LAB_BIG_OH_NUMBERS_H

#include <vector>
#include <algorithm>    // std::sort

namespace DS {

/*
    CLASS Numbers
    Really just a class that contains a bunch of numbers in a vector

    Value Semantics: Is it safe to use the copy constructor and the assignment operator
    Dynamic Memory Usage: Used by the vector
    Static & Global variable list: none
    Invariant declaration: single private vector of long
*/

    class numbers {
    public:
        //CONSTRUCTOR (both default and value constructor)
        //When n is specified, updates the size of data
        numbers(size_t n=0) { data.resize(n); }

        //Modification Members / Mutator Methods

        //Precondition: i < data.size
        //Postcondtion: A reference to the number at position i is returned
        long& operator[](size_t i) { return data.at(i); }
        const long& operator[](size_t i) const { return data.at(i); }
        long& at(size_t i) { return data.at(i); }
        const long& at(size_t i) const { return data.at(i); }

        //Precondition: n/a
        //Postcondtion: Increase the size of data by one and insert the passed value at the end
        void append(long in) { data.push_back(in); }

        //Precondition: n/a
        //Postcondtion: Sorts the numbers in data to be in numerical order
        //ONLY DRIVER MAY CALL THIS
        //Please DO NOT call this method from any of your functions
        //Since this function alone has a cost of at least O(n log n)
        void sort() { std::sort(data.begin(), data.end()); }

        //Non-Modification Members / Assessor Methods

        //Precondition: n/a
        //Postcondtion: Returns the number of items in data
        size_t size() const { return data.size(); }

        //Precondition: None
        //Postcondition: Returns the sum of all the numbers in the vector
        //TODO BY STUDENT, IMPLEMENT IN student.cpp
        long sum() const;

        //Precondition: None
        //Postcondition: Returns true when NONE of the numbers in this object are contained
        //  within the passed object
        //TODO BY STUDENT, IMPLEMENT IN student.cpp
        bool unique(const numbers&) const;

        //Precondition: Data/Numbers is already SORTED in numerical order and data.size > 0
        //Postcondition: Returns the integer median of the numbers in the collection (data)
        //  Hint: https://www.mathsisfun.com/median.html
        //TODO BY STUDENT, IMPLEMENT IN student.cpp
        long median() const;

    private:
        std::vector<long> data;
    };

}
#endif //LAB_BIG_OH_NUMBERS_H
