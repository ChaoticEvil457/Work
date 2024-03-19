// FILE: bag1.h
// CLASS PROVIDED: bag (part of the namespace DS)
//
// TYPEDEF and MEMBER CONSTANTS for the bag class:
//   typedef ____ value_type
//     bag::value_type is the data type of the items in the bag. It may be any of
//     the C++ built-in types (int, char, etc.), or a class with a default
//     constructor, an assignment operator, and operators to
//     test for equality (x == y) and non-equality (x != y).
//
//   typedef ____ size_type
//     bag::size_type is the data type of any variable that keeps track of how many items
//     are in a bag.
//
//   static const size_type CAPACITY = _____
//     bag::CAPACITY is the maximum number of items that a bag can hold.
//
// CONSTRUCTOR for the bag class:
//   bag( )
//     Postcondition: The bag has been initialized as an empty bag.
//
// MODIFICATION MEMBER FUNCTIONS for the bag class:
//   size_type erase_all(const value_type& target);
//     Postcondition: All copies of target have been removed from the bag.
//     The return value is the number of copies removed (which could be zero).
//
//   void erase_one(const value_type& target)
//     Postcondition: If target was in the bag, then one copy has been removed;
//     otherwise the bag is unchanged. A true return value indicates that one
//     copy was removed; false indicates that nothing was removed.
//
//   void insert(const value_type& entry)
//     Precondition:  size( ) < CAPACITY.
//     Postcondition: A new copy of entry has been added to the bag.
//
//   void operator +=(const bag& addend)
//     Precondition:  size( ) + addend.size( ) <= CAPACITY.
//     Postcondition: Each item in addend has been added to this bag.
//
//   void delete_at_index(size_type index)
//     Private internal function
//     Precondition: index < size
//     Postcondition: Item at end of array of copied is copied to index and size is reduced by one
//
//   value_type grab_random();
//     Precondition:  size( ) > 0
//     Postcondition: One random item will be removed and returned from the bag
//   TODO: TO BE IMPLEMENTED BY THE STUDENT
//
// CONSTANT MEMBER FUNCTIONS for the bag class:
//   size_type size( ) const
//     Postcondition: The return value is the total number of items in the bag.
//
//   size_type occurrences(const value_type& target) const
//     Postcondition: The return value is number of times target is in the bag.
//
// NONMEMBER FUNCTIONS for the bag class:
//   bag operator +(const bag& b1, const bag& b2)
//     Precondition:  b1.size( ) + b2.size( ) <= bag::CAPACITY.
//     Postcondition: The bag returned is the union of b1 and b2.
//
// VALUE SEMANTICS for the bag class:
//    Assignments and the copy constructor may be used with bag objects.

#ifndef DS_BAG1_H
#define DS_BAG1_H

#include <cstdlib>  // Provides size_t

namespace DS {
    class bag {
    public:
        // TYPEDEFS and MEMBER CONSTANTS
        typedef int value_type;
        typedef std::size_t size_type;
        static const size_type CAPACITY = 20;

        // CONSTRUCTOR
        bag() { used = 0; } // NOLINT(cppcoreguidelines-pro-type-member-init)

        // MODIFICATION MEMBER FUNCTIONS
        void insert(const value_type &entry);
        bool erase_one(const value_type &target);
        size_type erase_all(const value_type &target);
        void operator+=(const bag &addend);
        value_type grab_random();

        // CONSTANT MEMBER FUNCTIONS
        size_type size() const { return used; }
        size_type occurrences(const value_type &target) const;

        // ONLY FOR GRADER, students should NOT see this version
        value_type* getData() { return data; }
        const value_type* getData() const { return data; }
        // END OF GRADER
    private:
        void delete_at_index(size_type index);
        value_type data[CAPACITY];  // The array to store items
        size_type used;             // How much of array is used
    };

    // NONMEMBER FUNCTIONS for the bag class
    bag operator+(const bag &b1, const bag &b2);
}

#endif
