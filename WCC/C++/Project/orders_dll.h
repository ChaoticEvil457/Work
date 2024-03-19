/* Copyright (C) Steven Miller - All Rights Reserved
 * All material for this assignment (“content”) is protected by copyright under U.S. Copyright laws and is the property
 * of your professor or the party credited as the provider of the content. You may not copy, reproduce, distribute,
 * publish, display, perform, transmit, or in any way exploit any such content, nor may you distribute any part of this
 * content over any network, including a local area network, sell or offer it for sale, or use such content to construct
 * any kind of database. Westchester Community College's Brightspace and OneDrive (unshared) instance is excluded. You
 * may not alter or remove any copyright or other notice from copies of the content. Copying or storing any content
 * except as provided above is expressly prohibited without prior written permission from the copyright holder.
*/
//Version 20231126

#ifndef PROJECT_WAREHOUSE_ORDERS_DLL_H
#define PROJECT_WAREHOUSE_ORDERS_DLL_H

#include <string>
#include <ostream>
#include "inventory.h"
#if PROJECT_VERSION>=3
#include "order_bst.h"
#else
#include "order.h"
#endif
#include "node_dll.h"

namespace DS {


    class Orders {
    public:
        typedef DSDLL::node<Order> node;
        Orders() = delete; //At the very least, need to know the shared inventory pointer
        explicit Orders(Inventory * pInventory)  : inventory(pInventory), lastOrderNumber(0), orderCount(0),
                                                    head(nullptr), tail(nullptr), currentOrder(nullptr) {}
        //Copy Constructor
        Orders(const Orders& in);

        //Destructor
        ~Orders() { clear(); }

        //Mutator Functions
        Inventory& getInventory() { return *inventory; }
        Orders& operator=(const Orders& in);

        Order * insert(const std::string& customerName);

        Order * append(const std::string& customerName);

        double shipPendingOrders();

        size_t compact();

        //Manipulating the current Order
        Order * reset() { return &(currentOrder = head)->data(); };
        Order * getCurrent() { return &currentOrder->data(); }
        Order * previous();
        Order * next();

        void deleteCurrent();

        //Assessor Functions
        [[nodiscard]] size_t size() const { return orderCount; }
        [[nodiscard]] bool isCurrentValid() const { return currentOrder != nullptr; }

    private:
        Inventory * inventory;
        size_t lastOrderNumber;
        size_t orderCount;
        node * head;
        node * tail;
        node * currentOrder;

        void clear();
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

} // DS

#endif //PROJECT_WAREHOUSE_ORDERS_DLL_H
