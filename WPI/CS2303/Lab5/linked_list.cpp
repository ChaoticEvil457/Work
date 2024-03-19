#include <iostream>

using std::cin;
using std::cout;
using std::endl;
class Node
{
public:
    int value; // number of times we've seen key
    int key;
    void set_next(Node *); // get the pointer next
    Node *get_next();      // return the address stored in next
private:
    Node *next;
};

class LinkedList
{
public:
    Node *root;             // root of the linked list
    void add_item(int key); // add item to list
    int length();           // return the length of the list
    void print_list();
};

int main(void)
{

    Node *firstItem = new Node;
    firstItem->value = 1;
    firstItem->key = 12;
    firstItem->set_next(NULL);

    LinkedList this_list;
    this_list.root = firstItem;
    this_list.add_item(32);
    this_list.add_item(10);
    this_list.add_item(12);

    this_list.add_item(15);
    int len = this_list.length();
    cout << "The length of the list is " << len << endl;
    cout << "The full list is: " << endl;
    this_list.print_list();
    return 0;
}

/*********************************************
 * Add item to the linked list, in the right spot
 *
 * Input:
 *   int key: the key to go in the new node
 **********************************************/
void LinkedList::add_item(int key1)
{

    // Check to see if less than root
    if (this->root->key > key1)
    {
        // Create a new item
        Node *new_item = new Node;
        new_item->value = 1;
        new_item->key = key1;
        new_item->set_next(this->root);
        this->root = new_item;
    }
    else
    {

        // start from the beginning and find the end
        Node *current_item = this->root;
        Node *previous_item = this->root;
        while (current_item->key < key1 && current_item->get_next() != NULL)
        {
            previous_item = current_item;
            current_item = current_item->get_next();
        }
        // if the item already exists, increase value by 1
        if (current_item->key == key1)
        {
            current_item->value = current_item->value + 1;
        }
        // if we are at the end of the list, add to the end
        else if (current_item->get_next() == NULL && key1 > current_item->key)
        {
            // Create a new item
            Node *new_item = new Node;
            new_item->value = 1;
            new_item->key = key1;
            new_item->set_next(NULL);
            current_item->set_next(new_item);
        }
        // else add item in middle
        else
        { // removed useless item variable that was trying to set a Node.value for a null pointer
            // Create a new item
            Node *new_item = new Node;
            new_item->value = 1;
            new_item->key = key1;
            new_item->set_next(NULL);

            // Add it to the list
            Node *temp = new Node;                     // create temp variable
            temp->set_next(previous_item->get_next()); // store where current item points to

            previous_item->set_next(new_item); // changed from current_item to new_item
            new_item->set_next(temp->get_next());
            delete temp;
        }
    }
}

/***************************************************
 * Get the lengh of the linked list
 *
 * Return:
 *   returns the lengh of the list
 ***************************************************/
int LinkedList::length()
{

    int list_length = 0; // we are starting the first item
    Node *current_item = this->root;

    // start from the beginning and find the end
    while (current_item->get_next() != NULL)
    {
        current_item = current_item->get_next();
        list_length = list_length + 1;
    }

    return list_length + 1;
}

/***************************************************
 * Print the linked list
 ***************************************************/
void LinkedList::print_list()
{
    Node *start = this->root;
    while (start->get_next() != NULL)
    {
        cout << "(" << start->key << " , " << start->value << "),  ";
        start = start->get_next();
    }

    // Print the last value
    cout << "(" << start->key << " , " << start->value << ")  " << endl;
}

/***************************************************
 * set the value of next
 ***************************************************/
void Node::set_next(Node *a)
{
    this->next = a;
    return;
}

/***************************************************
 * return the value of next
 ***************************************************/
Node *Node::get_next()
{
    return this->next;
}