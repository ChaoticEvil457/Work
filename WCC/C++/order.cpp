#include "order.h"
#include <cassert>

namespace DS
{
/*
    Project 2
    Justin Huang
    Attempt 1
    order.cpp implements a number of functions present in order.h

    Copy Constructor
    Order(const Order& in);
    Precondition: None
    Postcondition: A deep copy of in is done. However, inventory will point to
    the same inventory
    
    sets inventory, orderNumber, customerName, and status of an object
    void assign(Inventory* pInventory, size_t number, const std::string& name,
    Status status=pending);
    Precondition: inventory points to a valid Inventory object, number is
    unique
    Postcondition: Object is updated with passed values, array is not modified

    Assignment Operator
    Order& operator=(const Order& in);
    Precondition: None
    Postcondition: A deep copy of in is done. However, inventory will point to
    the same inventory

    Add an item to the order. The price is what the customer will be paying per item.
    Quantity is the number of items the customer is getting.
    void addItem(size_t sku, size_t quantity, double price)
    Precondition: sku exists in the inventory, price is >=0, and order status
    is pending
    Postcondition: New item is added to the order.

    Ship order IF inventory has enough quantity of each and every item requested.
    bool shipOrder();
    Precondition: Order status is pending
    Postcondition: If inventory has enough to satisfy order, update inventory,
    changes status, and return true. If unable to ship entire order, do
    not update inventory, return false.

    Get profit/loss for whole order
    double getOrderProfitLoss() const;
    Precondition: None
    Postcondition: Return the total profit/loss the order have get when
    shipped

    Get profit/loss for a single item
    double getItemProfitLoss(size_t i) const;
    Precondition: i < itemCount
    Postcondition: Returns the profit/loss of the ith item in the items array
*/

    // copy constructor
    // takes in an order and performs a deep copy of it,
    // but inventory points to the same inventory
    Order::Order(const Order &in)
    {
        assign(in.inventory, in.orderNumber, in.customerName, in.orderStatus);
        itemCount = in.itemCount;
        items = new ItemOrdered[itemCount];
        for (size_t i = 0; i < itemCount; i++)
        {
            items[i] = {in.items[i].sku,
                        in.items[i].orderedQuantity,
                        in.items[i].price};
        }
    }

    // assign takes in an inventory pointer, order number, customer name, and (sometimes) status
    // sets this object's inventory, order number, customer name, and status to the passed value
    void Order::assign(Inventory *pInventory, size_t number, const std::string &name, Status status)
    {
        assert(pInventory != nullptr);
        inventory = pInventory;
        orderNumber = number;
        customerName = name;
        orderStatus = status;
    }

    // assignment operator
    Order &Order::operator=(const Order &in)
    {
        if (this != &in)
        {
            delete[] items;
            itemCount = in.itemCount;
            assign(in.inventory, in.orderNumber, in.customerName, in.orderStatus);
            if (itemCount != 0)
            {
                items = new ItemOrdered[in.itemCount];
                for (size_t i = 0; i < in.itemCount; i++)
                {
                    items[i] = {in.items[i].sku,
                                in.items[i].orderedQuantity,
                                in.items[i].price};
                }
            }
        }
        return *this;
    }

    // addItem takes in the data used to create an item and inserts that item into the item list
    void Order::addItem(size_t sku, size_t quantity, double price)
    {
        ItemOrdered *temp = new ItemOrdered[itemCount + 1];
        for (size_t i = 0; i < itemCount; i++)
        {
            temp[i] = items[i];
        }
        ItemOrdered n = {sku, quantity, price};
        temp[itemCount] = n;
        itemCount++;
        delete[] items;
        items = temp;
    }

    // removes requested items from inventory if there are enough
    // changes status to shipped and returns true
    // returns false and doesn't remove any items if there aren't enough
    bool Order::shipOrder()
    {
        assert(orderStatus == pending);
        for (size_t i = 0; i < itemCount; i++)
        {
            if (inventory->get(items[i].sku).getQuantity() < items[i].orderedQuantity)
            {
                return false;
            }
        }
        for (size_t i = 0; i < itemCount; i++)
        {
            inventory->get(items[i].sku).pick(items[i].orderedQuantity);
        }
        orderStatus = shipped;
        return true;
    }

    // gets the profit/loss for an entire order
    double Order::getOrderProfitLoss() const
    {
        double total = 0;
        for (size_t i = 0; i < itemCount; i++)
        {
            total += getItemProfitLoss(i);
        }
        return total;
    }

    // gets the profit/loss for a single item in the order
    double Order::getItemProfitLoss(size_t index) const
    {
        assert(index < itemCount);
        return (items[index].price - inventory->get(items[index].sku).getCost()) * items[index].orderedQuantity;
    }

}