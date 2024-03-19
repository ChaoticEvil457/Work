/* Copyright (C) Steven Miller - All Rights Reserved
 * All material for this assignment (“content”) is protected by copyright under U.S. Copyright laws and is the property
 * of your professor or the party credited as the provider of the content. You may not copy, reproduce, distribute,
 * publish, display, perform, transmit, or in any way exploit any such content, nor may you distribute any part of this
 * content over any network, including a local area network, sell or offer it for sale, or use such content to construct
 * any kind of database. Westchester Community College's Brightspace and OneDrive (unshared) instance is excluded. You
 * may not alter or remove any copyright or other notice from copies of the content. Copying or storing any content
 * except as provided above is expressly prohibited without prior written permission from the copyright holder.
*/

#ifndef PROJECT_WAREHOUSE_ORDERS_H
#define PROJECT_WAREHOUSE_ORDERS_H

#include <string>
#include <ostream>
#include "inventory.h"
#include "order.h"

namespace DS {

    class Orders {
    public:
        Orders() = delete; //At the very least, need to know the shared inventory pointer
        explicit Orders(Inventory * pInventory) : inventory(pInventory), lastOrderNumber(0), physical_capacity(0),
                                                    orderCount(0), data(nullptr), currentOrder(nullptr) {}
        //Copy Constructor
        Orders(const Orders& in);

        //Destructor
        ~Orders() { delete [] data; }

        //Mutator Functions
        Inventory& getInventory() { return *inventory; }
        Orders& operator=(const Orders& in);

        Order * insert(const std::string& customerName);

        Order * append(const std::string& customerName);

        double shipPendingOrders();

        //Precondition: not any
        //Postcondition: When current is valid, removes empty or shipped Orders from storage from the current Order to the end.
        //  If current Order is invalid, removes ALL Orders that are empty or already shipped.
        //  current Order is invalidated if the current Order was removed. Returns the number of orders removed
        size_t compact();

        //Manipulating the current Order
        Order * reset(Order * address = nullptr);
        Order * getCurrent() { return currentOrder; }
        Order * previous();
        Order * next();

        //Precondition: Current Order is valid
        //Postcondition: Order is deleted
        void deleteCurrent();

        void reserve(size_t newSize);

        //Assessor Functions
        [[nodiscard]] size_t capacity() const { return physical_capacity; }
        [[nodiscard]] size_t size() const { return orderCount; }
        [[nodiscard]] bool isCurrentValid() const { return currentOrder != nullptr; }

    private:
        Inventory * inventory;
        size_t lastOrderNumber;
        size_t physical_capacity;
        size_t orderCount;
        Order * data;
        Order * currentOrder;
    };

    inline std::ostream& operator<<(std::ostream& out, const Orders& orders_in) {
        //In Order to output we need to make a copy so that we can move the current pointer (non const)
        //Yes, this is NOT ideal, the better approach is to create an iterator, which we will not see until later
        //Note: You will want to avoid outputting Orders until all your copy and assignment operators are working
        Orders o(orders_in);
        for ( o.reset() ; o.isCurrentValid() ; o.next() ) {
            out << *o.getCurrent();
        }
        return out;
    }
}

#endif //PROJECT_WAREHOUSE_ORDERS_H
