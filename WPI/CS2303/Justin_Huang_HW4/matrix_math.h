#include <stdio.h>
#include <stdlib.h>

struct matrix // Matrix object has a pointer and a size
{
    float *data;
    int size;
};

typedef struct matrix Matrix; // when defining the object, use uppercase Matrix

Matrix *readMatrix(char *file); // allocates file values to a matrix
int deleteMatrix(Matrix *a);   // deletes a matrix
void add(Matrix a, Matrix b);  // adds two matrices
void sub(Matrix a, Matrix b);  // subtracts two matrices
void avg(Matrix a, Matrix b); // multiplies two matrices