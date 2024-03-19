#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>
#include "functions.h"
#include "numbers.h"
//#include "student.cpp"

using namespace DS;

int main() {
    const size_t MIN_SIZE = 2;
    const size_t MAX_SIZE = 10000;
    const size_t MAX_INNER = 100;
    const size_t MAX_NUMBER = 500;

    //Seed the random generator based on time
    //BIGOH SRAND: O(1)
    //It is constant since timer(0) returns the current system time from the OS
    //and srand basically copies this number to a static variable maintained internally
    //and it does not matter if the current time is 1am or 4pm, the number of operations
    //is the same
    srand(time(0));

    //Fill in a vector of random size with random numbers
    std::vector<long> nl(rand() % (MAX_SIZE - MIN_SIZE) + MIN_SIZE);
    for ( size_t i = 0 ; i < nl.size() ; ++i )
        nl[i] = rand() % MAX_NUMBER;

    //BIGOH SUMONE: O()
    std::cout << "Sum: " << sumArrayOfLong(nl.data(), nl.size()) << std::endl;

    //Create and fill in a vector of numbers where numbers is
    //a custom class which also contains a vector of long
    //Basically, a multidimensional array, however,
    //each row will have a variable length
    std::vector<numbers> vn(rand() % (MAX_SIZE - MIN_SIZE) + MIN_SIZE);
    for ( size_t i = 0 ; i < vn.size() ; ++i ) {
        size_t numbers_count = rand() % MAX_INNER;
        for (size_t j = 0; j < numbers_count; ++j)
            vn[i].append(rand() % MAX_NUMBER);
    }

    //BIGOH SUMTWO: O()
    std::cout << "Sum: " << sumArrayOfNumbers(vn.data(), vn.size()) << std::endl;

    //BIGOH UNIQUE: O()
    std::cout << "Unique: " << std::boolalpha << vn.at(0).unique(vn.at(1)) << std::endl;

    //Sort the numbers so that we can run median
    //WE ignore the cost of the sort when coming up with the BIGOH for median
    vn[0].sort();

    //BIGOH MEDIAN: O()
    std::cout << "Median: " << vn[0].median() << std::endl;

    return EXIT_SUCCESS;
}
