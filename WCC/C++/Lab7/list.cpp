#include "list.h"

namespace DS
{
    template <typename T>

    list<T>::~list()
    {
        while (head != nullptr)
        {
            node *deleteMe = head;
            head = head->next();
            delete deleteMe;
        }
    }
    // Insert at cursor or at head when cursor is null    template <typename T>
    template <typename T>
    void list<T>::insert(const value_type &value, node *cursor)
    {
        if (head == nullptr || cursor == nullptr || cursor == head)
        {

            head = new node(value, head);
            if (tail == nullptr)
                tail = head;
        }
        else
        {

            cursor->prev() = cursor->prev()->next() = new node(value, cursor, cursor->prev());
            if (tail->next() != nullptr)
                tail = tail->next();
        }
    }

} /* namespace DS */
