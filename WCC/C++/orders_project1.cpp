#include "orders.h"
#include <cassert>
namespace DS
{
    // copy constructor
    // performs deep copy with same inventory
    Orders::Orders(const Orders &in)
    {
        inventory = in.inventory;
        lastOrderNumber = in.lastOrderNumber;
        physical_capacity = in.physical_capacity;
        orderCount = in.orderCount;
        data = new Order[in.physical_capacity];
        for (size_t i = 0; i < in.orderCount; i++)
        {
            data[i] = in.data[i];
            if (in.data + i == in.currentOrder)
            { // sets currentOrder to the same position as in.currentOrder
                currentOrder = data + i;
            }
        }
    }

    // assignment operator
    Orders &Orders::operator=(const Orders &in)
    {
        if (this == &in)
        {
            return *this;
        }
        inventory = in.inventory;
        lastOrderNumber = in.lastOrderNumber;
        physical_capacity = in.physical_capacity;
        orderCount = in.orderCount;
        delete[] data;
        data = new Order[in.physical_capacity];
        for (size_t i = 0; i < in.orderCount; i++)
        {
            data[i] = in.data[i];
            if (in.data + i == in.currentOrder)
            { // sets currentOrder to the same position as in.currentOrder
                currentOrder = data + i;
            }
        }
        return *this;
    }

    // inserts the given order into the position before the currentOrder pointer if valid
    // if invalid, inserts the order into the beginning
    Order *Orders::insert(const std::string &customerName)
    {
        Order *temp;
        lastOrderNumber++;
        if (orderCount == 0) // if list is empty, put an order in it
        {
            temp = new Order[1];
            temp[0] = Order(inventory, lastOrderNumber, customerName);
            currentOrder = temp;
            physical_capacity++;
        }
        else
        {
            if (orderCount == physical_capacity) // if list is full, double the size
                physical_capacity *= 2;

            temp = new Order[physical_capacity];
            size_t j = 0;
            if (!isCurrentValid()) // adds value to beginning if current is invalid
            {
                temp[j] = Order(inventory, lastOrderNumber, customerName);
                j++;
                currentOrder = temp; // current order now points to newly added value
            }
            for (size_t i = 0; i < orderCount; i++, j++)
            {
                if (i == j && currentOrder == data + i) // inserts value before currentOrder
                {
                    temp[j] = Order(inventory, lastOrderNumber, customerName);
                    j++;
                    currentOrder = temp + i; // current order now points to newly added value
                }
                temp[j] = data[i];
            }
        }

        delete[] data;
        data = temp;
        orderCount++;
        return currentOrder;
    }

    // appends the given order into the position after the currentOrder pointer if valid
    // if invalid, inserts the order into the beginning
    Order *Orders::append(const std::string &customerName)
    {
        Order *temp;
        lastOrderNumber++;
        if (orderCount == 0) // if list is empty, put an order in it
        {
            temp = new Order[1];
            temp[0] = Order(inventory, lastOrderNumber, customerName);
            currentOrder = temp;
            physical_capacity++;
        }
        else
        {
            if (orderCount == physical_capacity) // if list is full, double the size
                physical_capacity *= 2;

            temp = new Order[physical_capacity];

            for (size_t i = 0, j = 0; i < orderCount; i++, j++)
            {
                temp[j] = data[i];
                if (isCurrentValid() && currentOrder == data + i) // inserts value before currentOrder
                {
                    j++;
                    temp[j] = Order(inventory, lastOrderNumber, customerName);
                    currentOrder = currentOrder - data + temp; // current order now points to newly added value
                }
            }
        }

        delete[] data;
        data = temp;
        orderCount++;
        return currentOrder;
    }

    // changes all orders with valid inventory quantities to shipped
    // returns the total profit/loss of all orders
    double Orders::shipPendingOrders()
    {
        double total = 0;
        for (size_t i = 0; i < orderCount; i++)
        {
            if (data[i].shipOrder())
            {
                total += data[i].getOrderProfitLoss();
            }
        }
        return total;
    }

    // if currentOrder is valid, removes all empty and shipped orders from that position to the end
    // if it isn't valid, remove all empty and shipped orders from data
    // returns number of orders removed
    // sets the currentOrder to nullpointer if it gets removed
    size_t Orders::compact()
    {
        size_t rem = 0; // total removed values
        size_t pos = 0; // position of currentOrder
        size_t ship = 0;
        if (isCurrentValid())
        {
            pos = currentOrder - data;
        }
        for (size_t i = pos; i < physical_capacity; i++)
        {
            if (data[i].getStatus() != pending) // counts removed values
            {
                rem++;
                if (currentOrder == data + i)
                {
                    currentOrder = nullptr; // if currentOrder is removed, delete it
                }
                if (data[i].getStatus() == shipped)
                {
                    ship++;
                }
            }
        }

        Order *temp = new Order[physical_capacity - rem];

        for (size_t i = 0, j = 0; i < physical_capacity; i++)
        {
            if (data[i].getStatus() == pending)
            {
                temp[j] = data[i]; // copies over valid items
                j++;
            }
        }
        delete[] data;
        physical_capacity -= rem;
        orderCount -= ship; // updates all values, deletes old ones
        data = temp;

        if (isCurrentValid())
        {
            currentOrder = data + pos; // puts current order into place if it wasn't removed
        }
        return rem;
    }

    // sets the current order to the passed address, or index 0 if address is nullptr
    // returns currentOrder
    Order *Orders::reset(Order *address)
    {
        assert(address == nullptr || (address >= data && address < data + physical_capacity));
        // address is either nullptr or inside the array data
        if (address == nullptr)
        {
            currentOrder = data;
            return currentOrder;
        }
        currentOrder = address;
        return currentOrder;
    }

    // sets currentOrder to the array position before it and returns currentOrder
    Order *Orders::previous()
    {
        currentOrder--;
        if (currentOrder < data)
        {
            currentOrder = nullptr;
        }
        return currentOrder;
    }

    // sets currentOrder to the arrayPosition after it and returns currentOrder
    Order *Orders::next()
    {
        currentOrder++;
        if (currentOrder >= data + physical_capacity)
        {
            currentOrder = nullptr;
        }
        return currentOrder;
    }

    // deletes the currentOrder
    void Orders::deleteCurrent()
    {
        assert(isCurrentValid());
        Order *temp = new Order[physical_capacity];
        for (size_t i = 0, j = 0; i < orderCount; i++)
        {
            if (data + i != currentOrder)
            {
                temp[j] = data[i]; // copies over non-current values
                j++;
            }
            else
            {
                currentOrder = temp + j - 1; // currentOrder is set to the position before
            }                                // the position it held in data
        }

        orderCount--;
        delete[] data;
        data = temp;
        next(); // currentOrder is moved into the correct position,
        // next function sets it to nullpointer if that location is invalid
    }

    // changes the physical size of the array
    // only changes if the newSize is bigger than the physical_capacity
    void Orders::reserve(size_t newSize)
    {
        if (newSize >= orderCount && newSize <= physical_capacity)
        {
            delete[] (data + newSize);
            physical_capacity = newSize;
        }
    }
}