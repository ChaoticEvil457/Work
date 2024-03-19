#include "linkedlist.h"

namespace DS
{
    void linkedList::insertItem(node::value_type data)
    {
        node *cursor = head, *prev_cursor = nullptr;
        while (cursor != nullptr && data > cursor->getData())
        {
            prev_cursor = cursor;
            cursor = cursor->next();
        }
        node *n = new node(data, cursor);
        if (prev_cursor == nullptr)
        {
            head = n;
        }
        else
        {
            prev_cursor->setNext(n);
        }
    }

    void linkedList::makeList(const node::value_type ray[], const size_t &size)
    {
        deleteList();
        if(size == 0){
            return;
        }
        for (size_t i = size - 1; i > 0; i--)
        {
            head = new node(ray[i], head);
        }
        head = new node(ray[0], head);
    }

    void linkedList::deleteList()
    {
        node *temp;
        while (head != nullptr)
        {
            temp = head;
            head = head->next();
            delete temp;
        }
        head = nullptr;
    }

} // end of namespace
