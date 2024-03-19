#include <iostream>
#include <string>
#include <iomanip>

#include "Matrix.h"

Matrix::Matrix(int l1)
{
    length = l1;
    data = new float[length];
}

Matrix::Matrix()
{
    length = 0;
    data = NULL;
}

void Matrix::readMatrix(string fileName)
{
    ifstream input;
    input.open(fileName);

    for (int i = 0; i < length; i++)
    {
        input >> data[i];
    }
    input.close();
}

/*******************************************************************************
 * Matrix operator+(Matrix &B)
 *
 * Allows the adding of matrices in the format
 * A + B
 * Where A and B are Matrix Objects
 ********************************************************************************/

Matrix Matrix::operator+(Matrix &B)
{
    Matrix C;
    C.length = length;
    C.data = (float *)malloc(C.length);
    for (int i = 0; i < C.length; i++)
    {
        C.data[i] = data[i] + B.data[i];
    }
    return C;
}

/*******************************************************************************
 * Matrix operator+(float)
 *
 * Allows the adding of floats in the format of
 * A + 2.2
 * Where A is a Matrix Objects
 ********************************************************************************/

Matrix Matrix::operator+(float f)
{
    Matrix B;
    B.length = length;
    B.data = (float *)malloc(B.length);
    for (int i = 0; i < length; i++)
    {
        B.data[i] = data[i] + f;
    }
    return B;
}

/*******************************************************************************
 * Matrix operator+(float, const Matrix &A)
 *
 * Allows the adding of floats in the format of
 * 2.2 + A
 * Where A is a Matrix Objects
 ********************************************************************************/

Matrix operator+(float f, const Matrix &A)
{
    Matrix B;
    B.length = A.length;
    B.data = (float *)malloc(B.length);
    for (int i = 0; i < A.length; i++)
    {
        B.data[i] = A.data[i] + f;
    }
    return B;
}

/*******************************************************************************
 * ostream& operator<<(ostream& os, const Matrix& A)
 *
 * Allows the printing of a Matrix in the format
 * cout << A
 * Where A is a Matrix Object
 ********************************************************************************/

ostream &operator<<(ostream &os, const Matrix &A)
{
    for (int i = 0; i < A.length; i++)
    {
        os << std::setw(8) << A.data[i];
    }
    return os;
} // Allows cout << A

/*******************************************************************************
 * void print(Matrix& A){
 *
 * Output:
 *   Prints A to the screen
 ********************************************************************************/

void Matrix::print()
{

    // print values to screen
    for (int i = 0; i < length; i++)
    {
        cout << std::setw(8) << data[i];
    }
    printf("\n");
}

/*******************************************************************************
 * Matrix::~Matrix()
 *
 * Deconstructor for Matrix object
 ********************************************************************************/
Matrix::~Matrix()
{
    delete data;
}