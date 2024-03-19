
#include <iostream>
#include "bst_tree.h"
using namespace std;
using namespace DS;


//These two functions cannot be template functions
//since template functions will ONLY be created if a call exists to the function at compile time
//Modified every node of the BST by adding two to it
void addTwo(int& v) {
    v += 2;
}
//n is passed as is to each in_order call
void addN(int& v, const int& n) {
    v += n;
}

int main() {

    bst_tree<int> bst;

	bst.insert(5);
	bst.insert(15);
	bst.insert(25);
	bst.insert(22);
	bst.insert(-29);
	bst.insert(29);
	bst.insert(2);
	bst.insert(19);
	bst.insert(30);
	bst.insert(40);
	bst.insert(4);
	bst.insert(-34);

    bst.printTree();

	cout << "Height:" << bst.height() << endl;
	cout << "Inorder:" << bst.toString() << endl;

	cout << (bst.in_bst(15) ? "Yes" : "No") << endl;
	cout << (bst.in_bst(30) ? "Yes" : "No") << endl;

    bst.printTree();
	cout << "==================" << endl;
	bst.bst_remove(25);
    bst.printTree();
	cout << "==================" << endl;
	bst.bst_remove(29);
    bst.printTree();
	cout << "==================" << endl;
	bst.bst_remove(5);
    bst.printTree();
	cout << "==================" << endl;

	//Add two to EVERY node in the BST
	bst.in_order(&addTwo);
    cout << "==================" << endl;
    bst.printTree();

    //Add the number four to EVERY node in the BST
    int four = 4;
    bst.in_order(&addN, four);
    cout << "==================" << endl;
    bst.printTree();

    return 0;
}
