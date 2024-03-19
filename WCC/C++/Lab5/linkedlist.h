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
Program Name: Lab x
Programmer Name: Prof. Miller
Date Submitted: Not submitted
File Purpose: node and linkedList Class Header
Date Updated: n/a
Purpose for Update: n/a
Global Variable List: n/a (avoid these)
*/

#ifndef LINKEDLIST_H
#define LINKEDLIST_H
#include <cstdlib>
#include <sstream> //Used by grader
#include <iostream>
#include "node_ll_int.h"

namespace DS {

class linkedList
{
public:
	typedef DSLLI::node node;
	linkedList () { head = nullptr; };
	virtual ~linkedList () { deleteList(); };

	void insertItem (node::value_type);
	void makeList (const node::value_type [],const size_t& count);
	void deleteList ();

	//The following friend function is implemented in lablinklist.cpp
	friend std::ostream& operator<<(std::ostream&, const linkedList&);

	//Students : Please ignore the following three lines, they are used for grading of this lab
    #ifdef GRADER
    #include "labll_grader.h"
    #endif

private:
	node* head; //points to the first node of the linked list
};

} //end namespace

#endif /* LINKEDLIST_H_ */
