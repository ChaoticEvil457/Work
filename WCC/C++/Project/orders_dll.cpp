#include "orders_dll.h"
#include <cassert>

namespace DS
{
    /*
        Project 2
        Justin Huang
        Attempt 1
        orders.cpp implements unimplemented methods from orders.h
    */

    // performs a deep copy of in, inventory pointer is the same
    Orders::Orders(const Orders &in)
    {
        inventory = in.inventory;
        lastOrderNumber = in.lastOrderNumber;
        orderCount = in.orderCount;
        if (orderCount > 0)
        {
            head = new node(in.head->data());
            tail = currentOrder = head;
            for (auto *cursor = in.head->next(); cursor != nullptr; cursor = cursor->next())
            {
                tail->next() = new node(cursor->data(), nullptr, tail);
                if (cursor == in.currentOrder)
                {
                    currentOrder = tail;
                }
                tail = tail->next();
            }
        }
        else
        {
            head = currentOrder = tail = nullptr;
        }
    }

    // assignment operator performs a deep copy of in
    // returns this
    Orders &Orders::operator=(const Orders &in)
    {
        if (this == &in) // equals itself
        {
            return *this;
        }
        inventory = in.inventory;
        lastOrderNumber = in.lastOrderNumber;
        orderCount = in.orderCount;
        if (orderCount > 0)
        {
            clear();
            head = new node(in.head->data());
            tail = head;
            for (auto *cursor = in.head->next(); cursor != nullptr; cursor = cursor->next())
            {
                tail->next() = new node(cursor->data(), nullptr, tail);
                if (cursor == in.currentOrder)
                {
                    currentOrder = tail;
                }
                tail = tail->next();
            }
        }
        else
        {
            head = tail = currentOrder = nullptr;
        }
        return *this;
    }

    // appends customer to the position after the currentOrder,
    // or at the end if currentOrder is invalid
    // sets currentOrder data to the Order appended
    // returns currentOrder data
    Order *Orders::append(const std::string &customerName)
    {
        lastOrderNumber++;
        Order added = Order(inventory, lastOrderNumber, customerName);
        if (head == nullptr) // list is empty
        {
            head = new node(added);
            tail = currentOrder = head;
        }
        else if (!isCurrentValid() || currentOrder->next() == nullptr) // currentOrder is the tail or invalid
        {
            tail->next() = new node(added, nullptr, tail);
            tail = currentOrder = tail->next();
        }
        else
        {
            currentOrder = new node(added, currentOrder->next(), currentOrder);
            currentOrder->next()->prev() = currentOrder->prev()->next() = currentOrder;
        }
        orderCount++;
        return &currentOrder->data();
    }

    // inserts customer to the position before the currentOrder,
    // or at the beginning if currentOrder is invalid
    // sets currentOrder data to the Order appended
    // returns currentOrder data
    Order *Orders::insert(const std::string &customerName)
    {
        lastOrderNumber++;
        Order added = Order(inventory, lastOrderNumber, customerName);
        if (head == nullptr) // empty list
        {
            head = new node(added);
            tail = currentOrder = head;
        }
        else if (!isCurrentValid() || currentOrder->prev() == nullptr) // current node is head or invalid
        {
            head->prev() = new node(added, head, nullptr);
            head = currentOrder = head->prev();
        }
        else
        {
            currentOrder = new node(added, currentOrder, currentOrder->prev());
            currentOrder->next()->prev() = currentOrder->prev()->next() = currentOrder;
        }
        orderCount++;
        return &currentOrder->data();
    }

    // ships all orders that have sufficient inventory and are pending
    // returns profit/loss of all orders
    double Orders::shipPendingOrders()
    {
        double total = 0;
        for (auto *cursor = currentOrder; cursor != nullptr; cursor = cursor->next())
        {
            total += cursor->data().shipOrder();
        }
        return total;
    }

    // If currentOrder is valid, removes empty or shipped from the current Order to the end
    // If currentOrder is invalid, removes ALL Orders that are empty or already shipped
    // current Order is invalidated if the current Order was removed
    // List size is reduced and nodes are freed
    // Returns the number of orders removed
    size_t Orders::compact()
    {
        if (orderCount == 0)
        {
            return 0;
        }
        size_t removed = 0; // total number of orders removed
        bool remCurr = true;
        auto temp = currentOrder; // saves currentOrder

        if (isCurrentValid() && currentOrder->data().getStatus() == pending)
            remCurr = false; // is the currentOrder deleted during the compact function

        if (!isCurrentValid())
            currentOrder = head;

        while (currentOrder != nullptr)
        {
            if (currentOrder->getData().getStatus() != pending) // order is shipped or empty
            {
                removed++;
                // wasn't sure whether to account for orderSize not including empty orders
                // i didn't because empty orders were a result of using an array, but a linked
                // list will theoretically never have an empty order
                deleteCurrent(); // deletes current node and moves currentOrder forwards;
            }
            else
            {
                currentOrder = currentOrder->next(); // otherwise skips
            }
        }
        if (remCurr)
            currentOrder = nullptr;
        else
            currentOrder = temp;
        return removed;
    }

    // deletes the currentOrder if it's valid
    // currentOrder moves forwards
    void Orders::deleteCurrent()
    {
        if (isCurrentValid())
        {
            orderCount--;
            if (orderCount == 0) // one element left
            {
                delete currentOrder;
                currentOrder = head = tail = nullptr;
            }
            else
            {
                if (currentOrder == head) // deleting the head
                {
                    head = head->next();
                    head->prev() = nullptr;
                }
                else if (currentOrder == tail) // deleting the tail
                {
                    tail = tail->prev();
                    tail->next() = nullptr;
                }
                else
                {
                    currentOrder->next()->prev() = currentOrder->prev();
                    currentOrder->prev()->next() = currentOrder->next();
                }
                auto temp = currentOrder;
                next();
                delete temp;
            }
        }
    }

    // gets order before currentOrder
    // currentOrder moves one back
    Order *Orders::previous()
    {
        if (currentOrder->prev() == nullptr)
        {
            currentOrder = nullptr;
            return nullptr;
        }
        currentOrder = currentOrder->prev();
        return &currentOrder->data();
    }

    // gets order after currentOrder
    // currentOrder moves one forwards
    Order *Orders::next()
    {
        if (currentOrder->next() == nullptr)
        {
            currentOrder = nullptr;
            return nullptr;
        }
        currentOrder = currentOrder->next();
        return &currentOrder->data();
    }
    // deletes all nodes in Orders, sets orderCount to 0, sets head, tail, and currentOrder to nullptr
    void Orders::clear()
    {
        if (orderCount > 1)
        {
            for (node *cursor = head->next(); cursor != nullptr; cursor = cursor->next())
            {
                delete cursor->prev();
            }
        }
        if (orderCount != 0)
        {
            delete tail;
            tail = head = currentOrder = nullptr;
            orderCount = 0;
        }
    }
}