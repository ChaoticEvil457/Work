//============================================================================
// Name        : darray.h
// Author      : S. Miller
//============================================================================

// VALUE SEMANTICS for the darray class:
//    Assignments and the copy constructor may be used with bag objects.
//
// DYNAMIC MEMORY USAGE by the darray:
//   If there is insufficient dynamic memory, then the following functions throw
//   bad_alloc: The constructors, insert, remote, and the assignment operator.

#ifndef DARRAY_H_
#define DARRAY_H_

#include <string>
#include <cstdlib>
#include <ostream>

namespace DS {

class darray {
public:
	typedef std::string value_type;

	//Initialize to empty array
	darray() {
		data = nullptr;
		numberOfItems = 0;
	}

	//Copy Constructor (does a deep copy)
	//REQUIRES IMPLEMENTATION
	darray(const darray&);

	virtual ~darray() {
		if ( data != nullptr )
			delete [] data;
	}

	//Assignment (does a deep copy, watch for self assignment)
	//REQUIRES IMPLEMENTATION
	darray& operator =(const darray&);

	//Precondition: None
	//Postcondition: Physical arrays size is increased by one.
	//	the entry is is added to the array in the position that maintains increasing order.
	//  No memory leaks.
	//  Linear search may be used.
	//REQUIRES IMPLEMENTATION
	void insert(value_type entry);

	//Precondition: Array is at least size index+1
	//Postcondition: Array size is reduced by one with no memory leaks and claiming the least amount of memory.
	//	The new array has the same sequence as before minus the entry at index.
	//REQUIRES IMPLEMENTATION
	value_type remove(size_t index);

	//Return the number of items in the array AND the physical size of the array
	size_t size() const { return numberOfItems; }

	//Precondition: i is a valid index
	//Postcondition: Reference value at index i is returned
	const value_type& operator[](size_t i) const { return data[i]; };

protected:
	value_type * data;
	size_t numberOfItems;

	//Precondition: param is new size, which is one more than current size OR one less than current size
	//Postcondition: array is resized without any memory leaks
	void resize(size_t);
};

} /* namespace DS */

std::ostream& operator<<(std::ostream& out, const DS::darray &src);

#endif /* DARRAY_H_ */
