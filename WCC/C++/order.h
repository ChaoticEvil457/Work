/* Copyright (C) Steven Miller - All Rights Reserved
 * All material for this assignment (“content”) is protected by copyright under U.S. Copyright laws and is the property
 * of your professor or the party credited as the provider of the content. You may not copy, reproduce, distribute,
 * publish, display, perform, transmit, or in any way exploit any such content, nor may you distribute any part of this
 * content over any network, including a local area network, sell or offer it for sale, or use such content to construct
 * any kind of database. Westchester Community College's Brightspace and OneDrive (unshared) instance is excluded. You
 * may not alter or remove any copyright or other notice from copies of the content. Copying or storing any content
 * except as provided above is expressly prohibited without prior written permission from the copyright holder.
*/
//Version 20231015

#ifndef PROJECT_WAREHOUSE_ORDER_H
#define PROJECT_WAREHOUSE_ORDER_H

#include <string>
#include <iomanip>
#include <ostream>
#include <utility>
#include "inventory.h"

namespace DS {

    enum Status {
        empty, //Special Status that should only be used before object is initialized
        pending, //Order has not been fulfilled yet
        shipped //Order was fulfilled, warehouse had Inventory to satisfy Order
    };

    //This struct holds an order.
    //The price here is what the customer is paying for each item
    //The profit is price minus cost
    struct ItemOrdered {
        size_t sku;
        size_t orderedQuantity;
        double price;
        bool operator==(const ItemOrdered& rhs) const { return sku == rhs.sku && orderedQuantity == rhs.orderedQuantity && price == rhs.price; }
        bool operator!=(const ItemOrdered& rhs) const { return !(rhs == *this); }
        bool operator<(const ItemOrdered& rhs) const { return sku == rhs.sku ? (orderedQuantity == rhs.orderedQuantity ? price < rhs.price : orderedQuantity < rhs.orderedQuantity) : sku < rhs.sku; }
    };

    class Order {
    public:
        Order() : inventory(nullptr), orderNumber(0), orderStatus(empty), items(nullptr), itemCount(0) {}
        explicit Order(Inventory * inventory) : inventory(inventory), orderNumber(0), orderStatus(empty), items(nullptr), itemCount(0) {}
        Order(Inventory * inventory, size_t orderNumber, std::string customerName) : inventory(inventory),
                orderNumber(orderNumber), orderStatus(pending), customerName(std::move(customerName)), items(nullptr), itemCount(0) {
        }

        Order(const Order& in);

        ~Order() { delete [] items; }

        //Mutators
        void assign(Inventory * pInventory, size_t number, const std::string& name, Status status=pending);

        Order& operator=(const Order& in);

        void addItem(size_t sku, size_t quantity, double price);

        bool shipOrder();

        //NOTE: This should NOT be inline, however, in order to lesson the file count, it is implemented here
        void toStream(std::ostream& out) const {
            out << "\t[" << orderNumber << "] " << customerName << std::endl
                << "\t\tStatus: " << getStatusString()
                << ", Item count: " << itemCount << std::endl;
            double order_profit = 0;
            if ( itemCount > 0 ) {
                out << "\t\tItems:" << std::endl << "\t\t\tCount\tProfit\t\tName" << std::endl;
                for ( size_t i = 0 ; i < itemCount ; ++i ) {
                    const Item& item_detail = inventory->get(items[i].sku);
                    double item_profit = getItemProfitLoss(i);
                    out << "\t\t\t" << std::setw(5) << items[i].orderedQuantity
                        << "\t" << std::setw(10) << std::fixed << std::setprecision(2) << std::right << item_profit
                        << "\t" << item_detail.getName()
                        << std::endl;
                    order_profit += item_profit;
                }
            }
            out << "\t\tProfit: $" << order_profit << std::endl;
        }

        //Assessor functions
        [[nodiscard]] size_t size() const { return itemCount; }
        [[nodiscard]] Status getStatus() const { return orderStatus; }
        [[nodiscard]] std::string getStatusString() const { return (orderStatus == Status::shipped ? "shipped" : orderStatus == Status::pending ? "pending" : "!INVALID!"); }
        [[nodiscard]] double getOrderProfitLoss() const;


    private:
        Inventory * inventory;
        size_t orderNumber;
        std::string customerName;
        Status orderStatus;
        ItemOrdered* items;
        size_t itemCount;

        [[nodiscard]] double getItemProfitLoss(size_t index) const;
    };

    inline std::ostream& operator<<(std::ostream& out, const Order& order) {
        order.toStream(out);
        return out;
    }


}

#endif //PROJECT_WAREHOUSE_ORDER_H
