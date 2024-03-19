#include <cassert> //Testing of preconditions is optional
#include "mystack.h"

namespace DS
{

    template <typename T>
    void mystack<T>::push(const value_type &entry)
    {
        pTop = new node(entry, pTop);
        node_count++;
    }

    template <typename T>
    void mystack<T>::pop()
    {
        node *temp = pTop;
        pTop = pTop->next();
        delete temp;
        node_count--;
    }

} /* end namespace DS */
