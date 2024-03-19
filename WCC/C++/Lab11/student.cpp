#include <string>
#include <cstddef>

namespace DS
{

    // Precondition: key is a lowercase string with no padded spaces, max is
    //   the physical size of the hash table
    // Postcondition: Returns the first index that should be tried to enter the
    //   item, it may be a collision, collisions are NOT handled here.
    size_t string_hash(const std::string &key, size_t max)
    {
        size_t tot = 0;
        for (char c : key)
        {
            tot += (size_t)c;
        }
        return tot % 811; // Fix
    }

    // Precondition: None
    // Postcondition: Return the optimal table size that gives us the fewest collisions with the assumption that we will
    //   never have more than 1500 records. Also, keep in mind that a table that is too large can be wasteful.
    size_t phonebookHashTableSize()
    {
        return 1483; // Fix
    }

} // End DS Namespace