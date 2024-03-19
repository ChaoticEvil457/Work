/* Copyright (C) Steven Miller - All Rights Reserved
 * All material for this assignment (“content”) is protected by copyright under U.S. Copyright laws and is the property
 * of your professor or the party credited as the provider of the content. You may not copy, reproduce, distribute,
 * publish, display, perform, transmit, or in any way exploit any such content, nor may you distribute any part of this
 * content over any network, including a local area network, sell or offer it for sale, or use such content to construct
 * any kind of database. Westchester Community College's Brightspace and OneDrive (unshared) instance is the one
 * exclusion. You may not alter or remove any copyright or other notice from copies of the content. Copying or storing
 * any content except as provided above is expressly prohibited without prior written permission from the copyright
 * holder.
*/
/*
Programmer Name: Prof. Miller
Date Submitted: Not submitted
File Purpose: single linked node
Date Updated: n/a
Purpose for Update: n/a
Global Variable List: n/a (avoid these)

Stores one data item and has ability to point to another node like itself

Value Semantics declaration:
	Is it safe to use the copy constructor and the assignment operator

Dynamic Memory Usage declaration:
	None explicitly, however, objects of this type are usually on the heap

Static & Global variable list:
	none

Invariant declaration:
	data_field: points to a data item, this class does not check the invariant
		of this data

	next_ptr: should be a valid pointer to a like object or nullptr, however,
		this class does not validate this

*/

#ifndef NODE_LL_I_H_
#define NODE_LL_I_H_

namespace DSLLI {

class node
{
public:
	typedef int value_type;

	//Constructor
	node(value_type d = value_type(), node * n = nullptr) : data_field(d), next_ptr(n) {}

	//Assessor/Getters
	const value_type& getData() const { return data_field; }
	node const * getNext() const { return next_ptr; }

	//Mutators/Setters
	void setData(const value_type& new_data) { data_field = new_data; }
	void setNext(node * new_link) { next_ptr = new_link; }

	//Other
	value_type& data() { return data_field; }
	node*& next() { return next_ptr; }

private:
	value_type data_field;
	node* next_ptr;
};

} /* namespace DSLLI */

#endif /* NODE_LL_I_H_ */
