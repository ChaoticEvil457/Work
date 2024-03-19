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
Programmer Name:
Date Submitted:
File Purpose: linkedList Class Implementation
Date Updated: n/a
Purpose for Update: n/a
Global Variable List: n/a (avoid these)
*/

#include <ostream>
#include <cassert>
#include "linkedlistd.h"

namespace DS {

linkedList::linkedList () {
	head = tail = nullptr;
}

linkedList::~linkedList () {
	deleteList();
}

void linkedList::insertItem (value_type newdatum) {

	node* ccursor = head;
	node* pcursor = nullptr;

	if ( head == nullptr ) {
		insertAt(newdatum,ccursor);
	} else {
		while ( ccursor != nullptr && newdatum > ccursor->getData() ) {
			pcursor = ccursor;
			ccursor = ccursor->next();
		}

		appendAt(newdatum,pcursor);
	}

}

void linkedList::makeList (const value_type items[], const size_t& count) {

	deleteList ();

	if ( count == 0 ) return;

	insertAt(items[0]);

	node* ccursor = head;

	for ( size_t i=1 ; i < count ; ++i ) {
		ccursor = appendAt(items[i],ccursor);
	}

}

void linkedList::deleteList () {

	node* dcursor;

	while ( head != nullptr ) {
		dcursor = head;
		head = head->next();
		delete dcursor;
	}
	head = tail = nullptr;

}

} //end of DS namespace
