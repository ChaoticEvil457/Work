This program allows the creation of Matrix Objects using a file input, and contains some convenient functions for
using matrices.

Matrix.h can be included in the header of the file to use the Matrix Object.

Some useful properties are:

A + B; adds Matrix A to Matrix B
A + 2.2; adds 2.2 to Matrix A
2.2 + A; adds 2.2 to Matrix A
cout << A; prints Matrix A with formatting

In order to compile the tests, run
g++ -Wall run_matrix.cpp Matrix.cpp -lm -o runM
then do
./runM