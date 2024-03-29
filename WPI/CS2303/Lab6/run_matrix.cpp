#include <iostream>
#include <string>
#include <fstream>
#include "Matrix.h"
#include <iomanip>

using std::string;
void add(Matrix &A, Matrix &B);
void subtract(Matrix &A, Matrix &B);
int main(void)
{

    Matrix A(5);
    Matrix B(5);
    A.readMatrix("data1.txt"); // read first matrix from file by calling function
    B.readMatrix("data2.txt"); // read second matrix from file with readMatrix

    if (A.length != B.length)
    {                                             // must be same dimensions for any of these operations
        printf("This math cannot be performed."); // print error message
    }
    else
    {
        add(A, B); // call function to add arrays and print
                   // Write an overloaded + function that adds 2 matrix objects and returns a new object
                   // Then uncomment the following 2 lines
        Matrix C = A + B;
        cout << "A + B with overload" << endl;
        C.print();
    }

    return 0;
} // end main

/*******************************************************************************
 * void add(Matrix &A, matrix &B){
 *
 * Add two matricies. Must have the same dimensions
 * Output:
 *   Prints A + B to the screen
 ********************************************************************************/
void add(Matrix &A, Matrix &B)
{

    float out1[A.length]; // create array to store output
    for (int i = 0; i < A.length; i++)
    {                                    // loop  over all rows
        out1[i] = A.data[i] + B.data[i]; // add values
    }
    cout << "A + B =" << endl;
    // print values to screen
    for (int i = 0; i < A.length; i++)
    {
        cout << std::setw(8) << out1[i];
    }
    cout << endl;
}