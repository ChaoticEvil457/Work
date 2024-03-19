#include <ostream>
#include <cassert>
#include "linkedlistd.h"

namespace DS
{

    //     Precondition: none
    //     Postcondition: If cursor is null, appends to END of list.
    //      A new node is created with the datum of newdatum.
    //      The new node next points to cursor->next
    //      The new node prev points to cursor
    //      The cursor->next prev points to the new node
    //      The cursor next points to the new node
    //      Returns a pointer to the new node
    linkedList::node *linkedList::appendAt(const value_type &newdatum, node *cursor)
    {
        if (tail == nullptr)
        {
            tail = new node(newdatum, nullptr, nullptr);
            head = cursor = tail;
        }
        else if (cursor == nullptr || cursor->next() == nullptr)
        {
            cursor = tail;
            cursor->setNext(new node(newdatum, nullptr, tail));
            cursor = tail = cursor->next();
        }
        else
        {
            cursor->next()->setPrev(new node(newdatum, cursor->next(), cursor));
            cursor->setNext(cursor->next()->prev());
            cursor = cursor->next();
        }
        return cursor;
    }

    //     Precondition: none
    //     Postcondition: If cursor is null, inserts at START of list.
    //      A new node is created with the datum of newdatum.
    //      The new node next points to cursor
    //      The new node prev points to cursor->prev
    //      The cursor->prev next points to the new node
    //      The cursor prev points to the new node
    //      Returns a pointer to the new node
    linkedList::node *linkedList::insertAt(const value_type &newdatum, node *cursor)
    {
        if (head == nullptr) // empty list
        {
            head = new node(newdatum, nullptr, nullptr);
            tail = cursor = head;
        }
        else if (cursor == nullptr || cursor->prev() == nullptr) // we're at the start of the list,
        {                                                        // or outside the list

            cursor = head;
            cursor->setPrev(new node(newdatum, head, nullptr));
            cursor = head = cursor->prev();
        }
        else
        {
            cursor->prev()->setNext(new node(newdatum, cursor, cursor->prev()));
            cursor->setPrev(cursor->prev()->next());
            cursor = cursor->prev();
        }
        return cursor;
    }
} // end namespace
