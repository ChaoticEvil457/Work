#include <fstream>
#include <iostream>

using std::cout;
using std::endl;

/******************************
binary_tree_inCpp.cpp
Name: Justin Huang
Date: 10/3/22

Based on provided file binary_tree_inC.c

Binary tree class which reads data from data.txt, adds it to the tree, then prints it in order.
Afterwards, it deletes the tree, printing out the values as it removes them.
****************************** */

// Define the structure for a node
class Node
{
public:
    int data;    // node will store an integer
    Node *left;  // right child
    Node *right; // left child
    Node(int n)  // Node constructor takes in an int and creates a new Node with data n, right NULL, and left NULL
    {
        data = n;
        left = NULL;
        right = NULL;
    }
};
// Function prototypes
Node *insert(Node *head, int num);
void inorder(Node *head);
void delete_tree(Node *head);

int main()
{
    std::ifstream f;
    int input;
    f.open("data.txt"); // opens data.txt

    if (f.is_open()) // makes sure the file opened
    {
        f >> input;                   // gets first input
        Node *root = new Node(input); // creates root node containing the first input
        while (f >> input)            // for each value in the file
        {
            insert(root, input); // add that value to the Tree
        }
        f.close(); // closes the file

        inorder(root);   // prints out the tree in order
        delete_tree(root); // deletes the tree
    }
}
/* ***************************************
 * Node insert(Node *head, int num)
 * Adds a new node in the tree, keeping the
 * tree ordered
 *
 * Input:
 *  root: pointer to top of tree or subtree
 *  int num: value to be added to the tree
 * Returns: the pointer to top of tree or subtree
 * **************************************/
Node *insert(Node *head, int num)
{
    if (head == NULL)
    {
        return new Node(num);
    }
    else if (num < head->data)
    {
        head->left = insert(head->left, num);
    }
    else if (num > head->data)
    {
        head->right = insert(head->right, num);
    }
    return head;
}
/* ***************************************
 * void inorder(Node *head)
 * Prints all nodes of the tree in order
 *
 * Input:
 *  root: pointer to top of tree or subtree
 * Output: Prints values to terminal in a single line
 * **************************************/
void inorder(Node *head)
{
    if (head != NULL)
    {
        inorder(head->left);
        cout << head->data << endl;
        inorder(head->right);
    }
}

/* ***************************************
 * void delete_tree(struct node *root)
 * Deletes all nodes of a tree or subtree
 *
 * Input:
 *  root: pointer to top of tree or subtree
 * **************************************/

void delete_tree(Node *head)
{
    if (head != NULL)
    {
        delete_tree(head->left);
        delete_tree(head->right);
        cout << head->data << endl;
        delete head;
    }
}