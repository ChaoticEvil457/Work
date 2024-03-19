This program creates, prints, and deletes a Binary Tree made of words

In order to compile, run
g++ -Wall -o countWords BinaryTree.cpp TreeNode.cpp countWords.cpp -lm
or run
make
then run ./countWords output input1 input2 ... inputn
where output is the output file and input1 through inputn are the input files
This program reads values from the given files and adds them to a Binary Tree data structure.
It then prints the tree in alphabetical order to the given output file with the number of times each word appeard
Then deletes the tree.