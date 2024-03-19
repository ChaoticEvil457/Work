#include <cassert> //For assert
#include <cstdlib> //For rand
#include "bag1.h"
#include "baglab.h"

namespace DS
{

    bag::value_type bag::grab_random()
    {
        // Remove a random item in the bag
        // Use randint provided in baglab.h to help with the random numbers
        --used;
        value_type randIndex = randint(0, used);
        value_type randVal = data[randIndex];
        data[randIndex] = data[used];
        return randVal;
    }

    size_t emptyBag(DS::bag &nums, const DS::stats &bagStats)
    {
        // Implement assuming grab_random does NOT exist
        // Use stats struct to know the max and min
        // Use randint provided in baglab.h to help with the random numbers
        bag::value_type randVal;
        size_t loops = 0;
        while (nums.size() > 0)
        {
            ++loops;
            randVal = randint(bagStats.min, bagStats.max);
            nums.erase_all(randVal);
        }
        return loops;
    }

    size_t emptyBag(DS::bag &nums)
    {
        // Implement assuming member grab_random exist
        size_t loops = 0;
        while (nums.size() > 0)
        {
            ++loops;
            nums.grab_random();
        }
        return loops;
    }

} // End of DS namespace
