#include "matrix_math.h"

/******************************
matrix_calc.c
Name: Justin Huang
Date: 9/16/22

Takes in two files and an opperation when the program runs
Has a point to the first file's inputs
Has b point to the second file's inputs
Sets opp equal to the opperation
Then preforms some function on those matrices (add, subtract, average)
****************************** */

int main(int argc, char *argv[])
{
    Matrix *a = readMatrix(argv[1]); // declares matrix A and B as pointers to Matrix objects
    Matrix *b = readMatrix(argv[2]); // uses the first two arguments in the input
    char opp = *argv[3];             // stores the third argument as a character
    if (a->size == b->size)          // checks that the matrices are of the same size
    {
        if (opp == 'n')
        {
            avg(*a, *b); // averages matrices
        }
        else if (opp == 'a')
        {
            add(*a, *b); // adds
        }
        else if (opp == 's')
        {
            sub(*a, *b); // subtracts
        }
    }
    else
    { // invalid inputs print an error statement
        printf("This math cannot be performed.");
    }
    deleteMatrix(a); // frees memory
    deleteMatrix(b);
}
