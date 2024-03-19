// This file implements the functions
// prototyped in functions.h and numbers.h

#include "functions.h"
#include "numbers.h"

namespace DS
{

    // Precondition: n is the size of the array
    // Postcondition: The sum of all values in the array is returned
    long sumArrayOfLong(const long in[], size_t n)
    {
        long sum = 0;
        for (unsigned int i = 0; i < n; i++)
        {
            sum += in[i];
        }
        return sum;
    }

    // Precondition: n is the size of the array
    // Postcondition: The sum of all values in the numbers array is returned
    // Hint: Make use of the member function sum, however, the cost of sum
    //   must be taken into account when doing your BigOh analysis
    long sumArrayOfNumbers(const numbers in[], size_t n)
    {
        long sum = 0;
        for (unsigned int i = 0; i < n; i++)
        {
            sum += in[i].sum();
        }
        return sum;
    }

    // Implementation of member function numbers::sum
    // I realize that in CP2 this would of gone in numbers.cpp
    // However, for simplicity of uploading to Blackboard,
    // we use one file for all of your work
    // See numbers.h for pre/post
    long numbers::sum() const
    {
        long s = 0;
        for (unsigned int i = 0; i < size(); i++)
        {
            s += data[i];
        }
        return s;
    }

    // Implementation of member function numbers::unique
    // See numbers.h for pre/post
    bool numbers::unique(const numbers &r) const
    {
        for (long l1 : data)
        {
            for (long l2 : r.data)
            {
                if (l1 == l2)
                {
                    return false;
                }
            }
        }
        return true;
    }

    // Implementation of member function numbers::median
    // See numbers.h for pre/post
    long numbers::median() const
    {
        if (size() % 2 == 0)
        {
            return (at(size() / 2 - 1) + at(size() / 2)) / 2;
        }
        else
        {
            return at(size() / 2);
        }
    }
}