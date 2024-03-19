// Program Name: Lab 1
// Programmer Name: S. Miller
// Attempt Number: 1
// Purpose: To hold a value or state

#ifndef LAB_CONST_ITEMS_H
#define LAB_CONST_ITEMS_H
#include <ostream>
#include <string>

// CLASS: items
// CONSTRUCTORS:
//   items();
//     Precondition: none
//     Postcondition: New object is created with an initial value of everything
//   items(long);
//     Precondition: none
//     Postcondition: New object is created with an initial value of the passed number
//
// ACCESSORS
//   long get();
//     Precondition: none
//     Postcondition: Returns the current value of the object
//   bool same(items*);
//     Precondition: none
//     Postcondition: Returns true if and only if the passed pointer points to the same
//       object as the current
//
// MUTATORS
//   void reset();
//     Precondition: none
//     Postcondition: Sets the objects value to everything
//   void set(long);
//     Precondition: none
//     Postcondition: Sets the objects value to the passed number
//   void set(std::string s);
//     Precondition: All characters in s are within ascii range
//     Postcondition: Sets the objects value to the sum of all the characters ascii value
//   void set(items&);
//     Precondition: none
//     Postcondition: Sets the objects value to be equivalent as the passed object
//
// NON-MEMBER FUNCTIONS for the items class:
//   std::ostream& operator<<(std::ostream& out, items obj);
//     Precondition: none
//     Postcondition: The current value of the object is sent to the out stream
//
//  VALUE SEMANTICS for the items class:
//    Assignments and the copy constructor may be used with items objects.
//
//  TOTAL ORDER SEMANTICS for the items class:
//    No comparison operators are implemented
//
// DYNAMIC MEMORY usage by the items class:
//   None
//
// INVARIANT OF items:
//   One member variable will hold the value of the class, the value of the object can be
//   any valid integer of long

namespace DS
{

    class items
    {
    public:
        // Constructors
        items()
        {
            set(everything);
        }
        items(long const l)
        {
            set(l);
        }
        // Accessors
        long get() const
        {
            return current;
        }
        bool same(items const *) const;
        // Mutators
        void reset();
        void set(long const);
        void set(std::string const &s);
        void set(items const &);

    private:
        static const long everything = 561027; // Secret value remains the same for ALL objects of items class
        long current;                          // Holds the current value of the object
    };

    std::ostream &operator<<(std::ostream &out, items obj);

}
#endif // LAB_CONST_ITEMS_H