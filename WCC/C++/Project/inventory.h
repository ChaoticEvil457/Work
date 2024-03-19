/* Copyright (C) Steven Miller - All Rights Reserved
 * All material for this assignment (“content”) is protected by copyright under U.S. Copyright laws and is the property
 * of your professor or the party credited as the provider of the content. You may not copy, reproduce, distribute,
 * publish, display, perform, transmit, or in any way exploit any such content, nor may you distribute any part of this
 * content over any network, including a local area network, sell or offer it for sale, or use such content to construct
 * any kind of database. Westchester Community College's Brightspace and OneDrive (unshared) instance is excluded. You
 * may not alter or remove any copyright or other notice from copies of the content. Copying or storing any content
 * except as provided above is expressly prohibited without prior written permission from the copyright holder.
*/

#ifndef PROJECT_WAREHOUSE_INVENTORY_H
#define PROJECT_WAREHOUSE_INVENTORY_H

#include <map>
#include <string>
#include <ostream>
#include "item.h"

namespace DS {

// CLASS PROVIDED: Inventory (a container class for a collection of items)
//
// Basically this is just a wrapper class around std::map for now.
// Later in the semester we may replace this with a custom version.
//
// CONSTRUCTOR for the Inventory class:
// Default constructor only, will start off with an empty inventory
//
// MODIFICATION MEMBER FUNCTIONS for the Inventory class:
// void add(size_t item_sku, const std::string& item_name, double cost, size_t quantity=0);
//Precondition: cost is >=0
//Postcondition: If sku is new, a new item is added to inventory. If sku already exited, the item is replaced.
//
// Item& get(size_t key)
//Precondition: key exists
//Postcondition: Returns the item matching the passed sku
//
// CONSTANT MEMBER FUNCTIONS for the Inventory class:
//
//const Item& get(size_t key) const
//Precondition: key exists
//Postcondition: Returns the item matching the passed sku
//
//const std::map<size_t, Item>& getData() const { return data; }
//Precondition: None
//Postcondition: Returns access to the hash map
//
//
// NONMEMBER FUNCTIONS for the Inventory class:
//   std::ostream& operator<<(std::ostream& out, const Inventory& inventory_in)
//   Precondition: None
//   Postcondition: Each Item is sent to out with a tab separating each Item
//
// VALUE SEMANTICS for the Inventory class:
//   Assignments and the copy constructor may be used with bag objects.
//
// DYNAMIC MEMORY USAGE by Inventory:
//   If there is insufficient dynamic memory, then the following functions throw
//   bad_alloc: The constructors, add, and the assignment operator.


    class Inventory {
    public:

        //Mutators
        void add(size_t item_sku, const std::string& item_name, double cost, size_t quantity=0) {
            data.insert(std::make_pair(item_sku, Item(item_sku, item_name, cost, quantity)));
        }
        Item& get(size_t key) { return data.at(key); }

        //Assessors
        [[nodiscard]] const Item& get(size_t key) const { return data.at(key); }
        [[nodiscard]] const std::map<size_t, Item>& getData() const { return data; }


    private:
        std::map<size_t, Item> data; // The hash map, we will cover this data structure later
    };

    inline std::ostream& operator<<(std::ostream& out, const Inventory& inventory_in) {
        for ( const auto& item : inventory_in.getData() ) {
            out << '\t' << item.second << std::endl;
        }
        return out;
    }

} // DS

#endif //PROJECT_WAREHOUSE_INVENTORY_H
