#include "order_bst.h"

namespace DS
{
    /*
         Project 3
         Justin Huang
         Attempt 1
         order_bst.cpp implements unimplemented methods from order_bst.h
     */

    // deep copy of the given Order
    Order::Order(const Order &in)
    {
        items = nullptr;
        inventory = in.inventory;
        orderNumber = in.orderNumber;
        customerName = in.customerName;
        orderStatus = in.orderStatus;
        itemCount = in.itemCount;
        if (itemCount > 0)
        {
            items = tree_copy(in.items);
        }
    }

    // deep copy of the given Order
    Order &Order::operator=(const Order &in)
    {
        inventory = in.inventory;
        orderNumber = in.orderNumber;
        customerName = in.customerName;
        orderStatus = in.orderStatus;
        itemCount = in.itemCount;
        if (itemCount > 0)
        {
            clearItems(items);
            items = tree_copy(in.items);
        }
        else
        {
            items = nullptr;
        }
        return *this;
    }

    // Helper function for quick creation of Item Ordered objects
    ItemOrdered assign(size_t sku, size_t quantity, double price)
    {
        ItemOrdered i = ItemOrdered();
        i.sku = sku, i.orderedQuantity = quantity, i.price = price;
        return i;
    }

    // adds a node to the tree with the given values
    void Order::addItem(size_t sku, size_t quantity, double price)
    {
        if (orderStatus == empty)
        {
            orderStatus = pending; // update status
        }
        ItemOrdered i = assign(sku, quantity, price);
        if (itemCount == 0)
        {
            items = new node(i); // empty tree
            itemCount++;
        }
        else if (sku <= items->data().sku)
        {
            if (items->left() == nullptr)
            {
                items->left() = new node(i); // less than and empty left spot
                itemCount++;
            }
            else
                addItem(i, items->left()); // less than and filled left spot
        }
        else
        {
            if (items->right() == nullptr)
            {
                items->right() = new node(i); // greater than and empty right spot
                itemCount++;
            }
            else
                addItem(i, items->right()); // greater than and filled right spot
        }
    }

    // adds a given ItemOrdered to the tree
    void Order::addItem(const ItemOrdered &item, node *root_ptr)
    {
        if (root_ptr == nullptr)
        {
            addItem(item.sku, item.orderedQuantity, item.price); // empty tree, go to previous method
        }
        else if (item.sku <= root_ptr->data().sku) // less than
        {
            if (root_ptr->left() == nullptr)
            {
                root_ptr->left() = new node(item); // empty left
                itemCount++;
            }
            else
                addItem(item, root_ptr->left()); // filled left, check children
        }
        else // greater than
        {
            if (root_ptr->right() == nullptr)
            {
                root_ptr->right() = new node(item); // empty right
                itemCount++;
            }
            else
                addItem(item, root_ptr->right()); // filled right, check children
        }
    }

    // helper function which recursively checks if there are enough items in inventory
    bool ship(Order::node *root_ptr, Inventory *inventory)
    {
        if (root_ptr == nullptr)
        {
            return true; // no errors, return true
        }

        if (root_ptr->data().orderedQuantity <= inventory->get(root_ptr->data().sku).getQuantity())
        {
            return ship(root_ptr->left(), inventory) && ship(root_ptr->right(), inventory);
        }
        return false; // error, return false
    }

    // helper function which removes items from inventory
    void remItems(Order::node *root_ptr, Inventory *inventory)
    {
        if (root_ptr != nullptr)
        {
            inventory->get(root_ptr->data().sku).pick(root_ptr->data().orderedQuantity);
            remItems(root_ptr->left(), inventory);
            remItems(root_ptr->right(), inventory);
        }
    }

    // ships items in order
    bool Order::shipOrder()
    {
        if (ship(items, inventory))
        {
            remItems(items, inventory);
            orderStatus = shipped;
            return true;
        }
        return false;
    }

    // returns the profit loss for an order
    double Order::getOrderProfitLoss() const
    {
        double tot = 0;
        if (items != nullptr)
        {
            Order l(*this);
            l.items = l.items->left();
            Order r(*this);
            r.items = r.items->right();
            tot += getItemProfitLoss(items->data());
            tot += r.getOrderProfitLoss() + l.getOrderProfitLoss();
            l.clearItems();
            r.clearItems();
            return tot;
        }
        return 0;
    }

    // returns the profit loss for an item
    double Order::getItemProfitLoss(const ItemOrdered &item) const
    {
        return (item.price - inventory->get(item.sku).getCost()) * item.orderedQuantity;
    }

    // deletes all items in the tree
    void Order::clearItems(node *root_ptr)
    {
        if (root_ptr != nullptr)
        {
            clearItems(root_ptr->left());
            clearItems(root_ptr->right());
            delete root_ptr;
            root_ptr = nullptr;
            itemCount = 0;
        }
    }

    // makes a copy of the given bst and returns the root of that copy
    Order::node *Order::tree_copy(const node *root_ptr)
    {
        if (root_ptr == nullptr)
        {
            return nullptr;
        }
        return new node(root_ptr->data(), tree_copy(root_ptr->left()),
                        tree_copy(root_ptr->right()));
    }

    // adds an item to the output
    double Order::outputItem(std::ostream &out, const ItemOrdered &item) const
    {
        double tot = getItemProfitLoss(item);
        out << "\t\t\t" << std::setw(5) << item.orderedQuantity
            << "\t" << std::setw(10) << std::fixed << std::setprecision(2) << std::right << tot
            << "\t" << inventory->get(item.sku).getName()
            << std::endl;
        return tot;
    }

    // adds all items to the output
    double Order::outputItems(std::ostream &out, Order::node *root_ptr) const
    {
        double tot = 0;
        if (root_ptr != nullptr)
        {
            outputItems(out, root_ptr->left());
            tot += outputItem(out, root_ptr->data());
            outputItems(out, root_ptr->right());
        }
        return tot;
    }
}