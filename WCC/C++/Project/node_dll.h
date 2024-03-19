/* Copyright (C) Steven Miller - All Rights Reserved
 * All material for this assignment (“content”) is protected by copyright under U.S. Copyright laws and is the property
 * of your professor or the party credited as the provider of the content. You may not copy, reproduce, distribute,
 * publish, display, perform, transmit, or in any way exploit any such content, nor may you distribute any part of this
 * content over any network, including a local area network, sell or offer it for sale, or use such content to construct
 * any kind of database. Westchester Community College's Brightspace and OneDrive (unshared) instance is excluded. You
 * may not alter or remove any copyright or other notice from copies of the content. Copying or storing any content
 * except as provided above is expressly prohibited without prior written permission from the copyright holder.
*/
/*
Program Name: Doubly Linked List Node
Programmer Name: Prof. Miller
Date Submitted: Not submitted
File Purpose: doubly linked node
Date Updated: 20231021
Purpose for Update: Formatting
Global Variable List: n/a (avoid these)
*/

#ifndef NODE_DLL_H_
#define NODE_DLL_H_

namespace DSDLL {

template <typename T>
class node
{
public:
	typedef T value_type;
	node(value_type d = value_type(), node * n = nullptr, node * p = nullptr) : data_field(d), next_ptr(n), prev_ptr(p) {}

	//Assessor/Getters
	const value_type& getData () const { return data_field; }
	node const * getPrev () const { return prev_ptr; }
	node const * getNext () const { return next_ptr; }
    //Shorter versions of the above two
    node const * prev () const { return prev_ptr; }
    node const * next () const { return next_ptr; }

	//Mutators/Setters
	void setData (const value_type& d) { data_field = d; }
	void setPrev (node * new_link) { prev_ptr = new_link; }
	void setNext (node * new_link) { next_ptr = new_link; }

	//Other
	value_type& data() { return data_field; }
	const value_type& data() const { return data_field; }
	node*& prev () { return prev_ptr; }
	node*& next () { return next_ptr; }

private:
	value_type data_field;
	node* next_ptr;
	node* prev_ptr;
};

} /* namespace DSDLL */

#endif /* NODE_DLL_H_ */
