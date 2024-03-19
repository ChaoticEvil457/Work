#include "TreeNode.h"
#include "BinaryTree.h"
#include <fstream>

using std::ifstream;
using std::ofstream;

/******************************
countWords.cpp
Name: Justin Huang
Date: 10/5/22

Creates a BinaryTree from a number of input files and prints the words out in order
with the number of times the word has appeared to an output file
****************************** */

int main(int argc, char *argv[])
{
    ifstream input;                // input file
    ofstream output;               // output file
    string fin;                    // word
    input.open(argv[2]);           // opens the first input file
    input >> fin;                  // sets the current stored word to the first word in that file
    BinaryTree t(fin);             // creates a BinaryTree containing that word
    for (int i = 2; i < argc; i++) // for each input file
    {
        if (i > 2) // if it's not the first input file
        {
            input.open(argv[i]); // open the file (we already open the first earlier)
        }
        if (input.is_open()) // check if the file is open
        {
            while (input >> fin) // while there are entries in the file
            {
                t.addNode(fin); // add a TreeNode containing that entry
            }
            input.close(); // close the file
        }
    }
    output.open(argv[1]); // open the output file
    t.inOrder(output);    // prints the BinaryTree in order to the output file
    t.deleteTree();       // deletes the tree and all of its nodes
}