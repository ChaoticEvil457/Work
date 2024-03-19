
#include <iostream>    // Provides cout and cin
#include <cstdlib>     // Provides EXIT_SUCCESS and srand
#include <ctime>	   // assist to seed to pseudo random generator
#include "bag1.h"      // With value_type defined as an int
#include "baglab.h"
#include "bag1.cpp"
#include "lab3.cpp"

using namespace std;
using namespace DS;

int main(int argc, char const *argv[])
{
    srand(time(nullptr));
    bag nums;
    stats bagStats;

    bagStats = cStrArray2Bag(nums, &argv[1], static_cast<size_t>(argc-1));

    cout << endl;

    cout << "All " << argc-1 << " items removed in " << emptyBag(nums, bagStats) << " tries." << endl;

    //Load the bag again
    cStrArray2Bag(nums, &argv[1], static_cast<size_t>(argc-1));
    cout << "All " << argc-1 << " items removed in " << emptyBag(nums) << " tries." << endl;

    return EXIT_SUCCESS;
}

namespace DS {
    stats cStrArray2Bag(bag& b, const char* values[], size_t size) {
        stats retVal;
        int num;
        if ( size > 0 ) {
            retVal.min = retVal.max = strtol(values[0], nullptr, 10);
            b.insert( retVal.min );
            for (size_t argi=1 ; argi < size ; ++argi ) {
                num = strtol(values[argi], nullptr, 10);
                b.insert( num );
                if ( num < retVal.min )
                    retVal.min = num;
                else if ( num > retVal.max )
                    retVal.max = num;
            }
        }
        return retVal;
    }
    int randint(int a, int b) {
        return rand() % (b - a + 1) + a;
    }
}
