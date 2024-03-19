#include <string>
#include "BinaryTree.h"

/******************************
BinaryTree.cpp
Name: Justin Huang
Date: 10/3/22

Defines the functions for the BinaryTree class in BinaryTree.h
****************************** */

void del(TreeNode *r);                // deletes nodes
TreeNode *add(TreeNode *r, string a); // adds nodes

/******************************
BinaryTree::BinaryTree(string a);
Defines BinaryTree(string a) of the BinaryTree class in BinaryTree.h

BinaryTree constructor that takes in a string
Creates a TreeNode containing the given string.
****************************** */

BinaryTree::BinaryTree(string a) // initializes the tree
{
    root = new TreeNode(a);
}

/******************************
void BinaryTree::deleteTree();
Defines deleteTree() of the BinaryTree class in BinaryTree.h

Deletes all nodes in the tree, and the tree itself
****************************** */

void BinaryTree::deleteTree() // deletes entire tree
{
    del(root);  // calls the delete function defined below
    free(this); // deletes the tree itself
}

/******************************
void del(TreeNode *r);
Takes in a TreeNode pointer and deletes all nodes in a BinaryTree

Recursively checks if there are nodes to the left and right of the current node.
Calls the function again for each of those existing nodes,
then deletes the node from the tree
****************************** */

void del(TreeNode *r) // deletes each node from the tree
{
    if (r != NULL)
    {
        del(r->get_left());// deletes nodes attached on the left
        del(r->get_right());// deletes nodes attached on the right
        r->remove_Node();// removes the current node
    }
}

/******************************
void BinaryTree::addNode(string a);
Defines addNode(string a) of the BinaryTree class in BinaryTree.h

Turns the given string lowercase, then checks if it already exists in the BinaryTree
If the string exists, increment it's count by one
Otherwise, create a new TreeNode containing the given string in the correct position
****************************** */

void BinaryTree::addNode(string a) // Adds node with word a to the tree
{
    for (int i = 0; i < (int)a.size(); i++) // for the size of the word
    {
        if (a.at(i) <= 'Z' && a.at(i) >= 'A') // if there is an upper case letter
        {
            a.at(i) = tolower(a.at(i)); // make it a lower case letter
        }
    }
    add(root, a); // calls the add function, defined below
}

/******************************
void add(TreeNode *r, string a);
Takes in a TreeNode pointer and a string and adds the string to the BinaryTree
Returns either a new TreeNode containing a, or TreeNode r

Recursively checks if the given string is before or after the string stored in the given TreeNode
If the current TreeNode is NULL, it returns a new TreeNode
Otherwise if it's before, it adds the return (if there is one) to the left
If it's after, it adds the return (if there is one) to the right
If the current TreeNode's word is the same as the given string, it increases the count variable in that
TreeNode by one
****************************** */

TreeNode *add(TreeNode *r, string a)
{
    if (r == NULL) // checks if root is NULL
    {
        return new TreeNode(a); // if so, makes a new node
    }
    else if (a < r->get_word()) // if a is before the stored word in the alphabet
    {
        r->add_left(add(r->get_left(), a)); // check the left word and set the left pointer to the result
    }
    else if (a > r->get_word()) // if a is after the stored word in the alphabet
    {
        r->add_right(add(r->get_right(), a)); // check the right word and set the right pointer to the result
    }
    else // otherwise a is the word stored in r
    {
        r->increase_count(); // increase the count for r
    }
    return r;
}

/******************************
void BinaryTree::inOrder(std::ofstream &file1);
Defines addNode(std::ofstream &file1) of the BinaryTree class in BinaryTree.h

Calls the inOrder function in TreeNode.cpp which prints the tree in order to the file
****************************** */

void BinaryTree::inOrder(std::ofstream &file1) // prints tree to file in order
{
    root->inOrder(file1);
}