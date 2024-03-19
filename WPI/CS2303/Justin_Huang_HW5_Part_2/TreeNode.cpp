#include "TreeNode.h"
#include <string>

/******************************
TreeNode.cpp
Name: Justin Huang
Date: 10/3/22

Defines the functions for the TreeNode class in TreeNode.h
****************************** */

/******************************
TreeNode::TreeNode(string a);
Defines TreeNode(string a) of the TreeNode class in TreeNode.h

TreeNode constructor that takes in a string, makes the string lowecase,
then defines the stored word as the lowecase version of that string,
the count as 1 (this is the first instance of the given string in the Tree),
sets the right and left pointers to NULL
****************************** */

TreeNode::TreeNode(string a) // Constructor
{
    for (int i = 0; i < (int)a.size(); i++) // runs for the size of the given string
    {
        if (a.at(i) <= 'Z' && a.at(i) >= 'A') // if the current character is uppercase
        {
            a.at(i) = tolower(a.at(i)); // make it lowercase
        }
    }
    word = a;      // sets the stored word to the lowercase version of a
    count = 1;     // sets the number of times the word has been stored to 0
    rightP = NULL; // sets the right pointer to NULL
    leftP = NULL;  // sets the left pointer to NULL
}

/******************************
TreeNode::TreeNode();
Defines TreeNode() of the TreeNode class in TreeNode.h

TreeNode default constructor
****************************** */
TreeNode::TreeNode()
{
}

/******************************
void TreeNode::remove_Node();
Defines remove_Node() of the TreeNode class in TreeNode.h

frees the current Node
****************************** */

void TreeNode::remove_Node() // Deconstructor
{
    delete this;
}

/******************************
void TreeNode::increase_count();
Defines increase_count() of the TreeNode class in TreeNode.h

increases the count of the node by one (we've seen the stored word one additional time)
****************************** */

void TreeNode::increase_count() // increase count by 1
{
    count++;
}

/******************************
int TreeNode::get_count();
Defines get_count() of the TreeNode class in TreeNode.h

returns the count varible in this TreeNode
****************************** */

int TreeNode::get_count() // return the count
{
    return count;
}

/******************************
string TreeNode::get_word();
Defines get_word() of the TreeNode class in TreeNode.h

returns the word varible in this TreeNode
****************************** */

string TreeNode::get_word() // Return word
{
    return word;
}

/******************************
void TreeNode::add_left(TreeNode *subTree);
Defines add_left(TreeNode *subTree) of the TreeNode class in TreeNode.h
takes in a TreeNode
sets the left pointer to the given TreeNode
****************************** */

void TreeNode::add_left(TreeNode *subTree) // add subTree to left
{
    leftP = subTree;
}

/******************************
void TreeNode::add_right(TreeNode *subTree);
Defines add_right(TreeNode *subTree) of the TreeNode class in TreeNode.h
takes in a TreeNode
sets the right pointer to the given TreeNode
****************************** */

void TreeNode::add_right(TreeNode *subTree) // add subTree to right
{
    rightP = subTree;
}

/******************************
TreeNode TreeNode::get_left();
Defines get_left() of the TreeNode class in TreeNode.h

returns a pointer to the TreeNode to the left of the current TreeNode
****************************** */

TreeNode *TreeNode::get_left() // returns left subTree
{
    return leftP;
}

/******************************
TreeNode TreeNode::get_right();
Defines get_right() of the TreeNode class in TreeNode.h

returns a pointer to the TreeNode to the right of the current TreeNode
****************************** */

TreeNode *TreeNode::get_right() // returns right subTree
{
    return rightP;
}

/******************************
void TreeNode::inOrder(std::ofstream &file1);
Defines inOrder(std::ofstream &file1) of the TreeNode class in TreeNode.h
Takes in a file

Checks if the left pointer is null, and if so, prints the currently stored word to the file
Otherwise calls itself on the node to the left of the current node,
and then prints out the currently stored word to the file
Afterwards it checks if the right pointer is null, and if so, calls itself for the right pointer
****************************** */

void TreeNode::inOrder(std::ofstream &file1)
{
    if (leftP != NULL)
    {
        leftP->inOrder(file1); // prints smaller values
    }
    file1 << std::setw(10) << count << "\t"<< word << std::endl; // then prints the current
    if (rightP != NULL)
    {
        rightP->inOrder(file1); // then prints bigger values
    }
}