#include <algorithm> //You may ONLY use copy from this library
#include "assert.h"
#include "darray.h"

namespace DS
{

    // Copy Constructor (does a deep copy)
    darray::darray(const darray &source)
    {
        numberOfItems = source.numberOfItems;
        data = new value_type[numberOfItems];
        std::copy(source.data, source.data + source.numberOfItems, data);
    }

    // Assignment (does a deep copy, watch for self assignment)
    darray &darray::operator=(const darray &source)
    {
        if (&source != this)
        {
            delete[] (data);
            numberOfItems = source.numberOfItems;
            data = new value_type[numberOfItems];
            std::copy(source.data, source.data + source.numberOfItems, data);
        }
        return *this;
    }

    // Precondition: None
    // Postcondition: Physical arrays size is increased by one.
    //   the entry is is added to the array in the position that maintains increasing order.
    //   No memory leaks.
    //   Linear search may be used.
    void darray::insert(value_type entry)
    {
        value_type *temp = new value_type[numberOfItems + 1];
        if (numberOfItems == 0)
        {
            temp[0] = entry;
        }
        else
        {
            for (size_t i = 0, j = 0; i < numberOfItems; i++, j++)
            {
                if (data[i] > entry && j == i)
                {
                    temp[j] = entry;
                    j++;
                    temp[j] = data[i];
                }
                else if (i == numberOfItems - 1 && j == i)
                {
                    temp[j] = data[i];
                    j++;
                    temp[j] = entry;
                }
                else
                {
                    temp[j] = data[i];
                }
            }
        }
        delete[] (data);
        data = temp;
        numberOfItems++;
    }

    // Precondition: Array is at least size index+1
    // Postcondition: Array size is reduced by one with no memory leaks and claiming the least amount of memory.
    //   The new array has the same sequence as before minus the entry at index.
    //   The value of the item removed is returned.
    darray::value_type darray::remove(size_t index)
    {
        assert(numberOfItems > index);
        value_type *temp = new value_type[numberOfItems - 1];
        value_type held = data[index];
        numberOfItems--;
        for (size_t i = 0; i < numberOfItems; i++)
        {
            if (i >= index)
            {
                temp[i] = data[i + 1];
            }
            else
            {
                temp[i] = data[i];
            }
        }
        delete[] (data);
        data = temp;
        return held;
    }

    // Precondition: param is new size, which is one more than current size OR one less than current size
    // Postcondition: array is resized without any memory leaks
    void darray::resize(size_t)
    {
        // TO DO (OPTIONAL helper function)
        // Only implement IF you utilize this function within your implementations above!
    }

} /* namespace DS */
