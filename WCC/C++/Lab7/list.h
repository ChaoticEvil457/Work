#ifndef LIST_H_
#define LIST_H_

#include <iterator>
#include <cassert>
#include "node_dll.h"

namespace DS
{

    // Mutable Iterator
    template <typename VT>
    class node_iterator : public std::iterator<std::forward_iterator_tag, VT>
    {
    public:
        explicit node_iterator(DSDLL::node<VT> *nd = nullptr) : itr(nd) {}
        // ForwardIterator() : itr(nullptr) {}

        node_iterator &operator++() // Pre-increment
        {
            itr = itr->next();
            return *this;
        }

        node_iterator operator++(int) // Post-increment
        {
            node_iterator<VT> temp = *this;
            itr = itr->next;
            return temp;
        }

        bool operator==(const node_iterator &rhs)
        {
            return rhs.itr == itr;
        }

        bool operator!=(const node_iterator &rhs)
        {
            return rhs.itr != itr;
        }

        VT &operator*() const
        {
            return itr->data();
        }

        // Same as operator*, but allow user to use arrow in addition to *
        VT &operator->() const
        {
            return itr->data();
        }

    private:
        DSDLL::node<VT> *itr;
    };

    // Immutable Iterator
    template <typename VT>
    class node_const_iterator : public std::iterator<std::forward_iterator_tag, const VT>
    {
    public:
        explicit node_const_iterator(DSDLL::node<VT> *nd = nullptr) : itr(nd) {}

        node_const_iterator &operator++() // Pre-increment
        {
            itr = itr->next();
            return *this;
        }

        node_const_iterator operator++(int) // Post-increment
        {
            node_iterator<VT> temp = *this;
            itr = itr->next();
            return temp;
        }

        bool operator==(const node_const_iterator &rhs)
        {
            return rhs.itr == itr;
        }

        bool operator!=(const node_const_iterator &rhs)
        {
            return rhs.itr != itr;
        }

        const VT &operator*() const
        {
            return itr->data();
        }

        // Same as operator*, but allow user to use arrow in addition to *
        const VT &operator->() const
        {
            return itr->data();
        }

    private:
        DSDLL::node<VT> *itr;
    };
    template <typename T>
    class list
    {
    public:
        typedef T value_type;
        typedef DSDLL::node<value_type> node;
        typedef node_iterator<value_type> iterator;
        typedef node_const_iterator<value_type> const_iterator;
        iterator begin() { return iterator(head); }
        iterator end() { return iterator(); }
        const_iterator begin() const { return const_iterator(head); }
        const_iterator end() const { return const_iterator(); }
        const_iterator cbegin() const { return const_iterator(head); }
        const_iterator cend() const { return const_iterator(); }
        list() : head(nullptr), tail(nullptr) {}
        virtual ~list();
        void insert(const value_type &, node * = nullptr);

    private:
        node *head;
        node *tail;
    };
} /* namespace DS */
#endif /* LIST_H_ */
