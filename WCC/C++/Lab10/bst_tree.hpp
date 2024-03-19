/* * This file is the implementation to bst_tree * */
#include <cassert>
#include <sstream>
#include "node_btree.h"
#include "bst_tree.h"

namespace DS
{

    template <typename T>
    void bst_tree<T>::bst_insert(const T &newDataItem, node *node_ptr)
    {
        if (node_ptr->data() >= newDataItem)
        {
            if (node_ptr->left() == nullptr)
            {
                node_ptr->left() = new node(newDataItem);
                return;
            }
            bst_insert(newDataItem, node_ptr->left());
        }
        else if (node_ptr->data() < newDataItem)
        {
            if (node_ptr->right() == nullptr)
            {
                node_ptr->right() = new node(newDataItem);
                return;
            }
            bst_insert(newDataItem, node_ptr->right());
        }
    }

    template <typename T>
    long bst_tree<T>::bst_height(const node *node_ptr) const
    {
        if (node_ptr == nullptr)
        {
            return -1;
        }
        return std::max(bst_height(node_ptr->left()) + 1, bst_height(node_ptr->right()) + 1);
    }

    template <typename Item>
    bool bst_tree<Item>::in_bst(const Item &newDataItem, node *node_ptr)
    {
        if (node_ptr == nullptr)
        {
            return false;
        }
        return newDataItem == node_ptr->data() || in_bst(newDataItem, node_ptr->left()) || in_bst(newDataItem, node_ptr->right());
    }

    // Precondition: root_ptr is a root pointer of a binary search tree
    //  or may be NULL for an empty tree).
    // Postcondition: If target was in the tree, then one copy of target
    // has been removed, and root_ptr now points to the root of the new
    // (smaller) binary search tree. In this case the function returns true.
    // If target was not in the tree, then the tree is unchanged (and the
    // function returns false).
    template <typename T>
    bool bst_tree<T>::bst_remove(const T &target, node *&node_ptr)
    {
        // 1 : tree is emtpy
        if (node_ptr == nullptr)
        {
            return false;
        }
        // 2 : Tree not empty, target < than root
        if (target < node_ptr->data())
        {
            return bst_remove(target, node_ptr->left());
        }
        // 3 : tree not empty, target > than root
        if (target > node_ptr->data())
        {
            return bst_remove(target, node_ptr->right());
        }
        // 4 target == root node, do not need to check, if not < or >, than it
        if (target == node_ptr->data())
        {
            // 4a The root node has no left child
            if (node_ptr->left() == nullptr)
            {
                root_ptr = node_ptr->right();
                delete node_ptr;
                return true;
            }
            // 4bThe root does have a left child, remove the max from the left subtree
            else
            {
                bst_remove_max(node_ptr, node_ptr->left()->data());
                return true;
            }
        }
        return false;
    }

    template <typename T>
    void bst_tree<T>::bst_remove_max(node *&root_ptr, T &removed)
    {
        if (root_ptr->right() == nullptr)
        {
            bst_remove(root_ptr->data()->left(), root_ptr->left());
        }
        else
        {
            bst_remove_max(root_ptr->right(), root_ptr->right()->data())
        }
    }

    template <typename T>
    void bst_tree<T>::buildStringStream(const node *p, std::ostringstream &s, bool &firstOutputted) const
    {
        if (p == nullptr)
        {
            return;
        }
        buildStringStream(p->left(), s, firstOutputted);
        if (!firstOutputted)
        {
            firstOutputted = true;
            s << p->data();
        }
        else
        {
            s << ", " << p->data();
        }
        buildStringStream(p->right(), s, firstOutputted);
    }

} // end namespace DS
