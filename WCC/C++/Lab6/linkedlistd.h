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
Program Name: Lab 4
Programmer Name: Prof. Miller
Date Submitted: Not submitted
File Purpose: ListNode and linkedList header
Date Updated: n/a
Purpose for Update: n/a
Global Variable List: n/a (avoid these)
*/

#ifndef LINKEDDLIST_H
#define LINKEDDLIST_H
#include <cstdlib>
#include <sstream> //For grader
#include <iostream>
#include "node_dll.h"

namespace DS {

class linkedList
{
public:
	typedef int value_type;
	typedef DSDLL::node<value_type> node;

    //The following are implemented in linkedlistd.cpp
	linkedList ();
	virtual ~linkedList ();
	void insertItem (value_type);
	void makeList (const value_type[],const size_t& count);
	void deleteList ();

	//The following two functions are implemented by student in lab06.cpp
    node* appendAt (const value_type&, node* = nullptr );
    node* insertAt (const value_type&, node* = nullptr);

    //The following friend function is implemented in lablinklist.cpp
	friend std::ostream& operator<<(std::ostream&, const linkedList&);
	friend std::ostream& operator>>(std::ostream&, const linkedList&);

    //Students : Please ignore the following three lines, they are used for grading of this lab
    #ifdef GRADER
    #include "labdll_grader.h"
    #else
    //The following two assessors are for testing purpose and implemented inline
    //Therefore, you do not need to implement in the cpp file
    node* getHead() const { return head; }
    node* getTail() const { return tail; }
    #endif
private:
	node* head;
	node* tail;
};

} //end namespace

#endif /* linkedList_H_ */
