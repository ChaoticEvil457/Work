#include "matrix_math.h"

/******************************
Matrix *readMatrix(char *file);
Takes in a list of characters spelling out a file name and returns a pointer to a Matrix

Opens the passed file, allocates memory for a new Matrix object,
initializes the variables inside that object, including making a list of floats,
and then sets that list of floats to the list stored in the file.
Afterwards, it closes the file and returns the Matrix
****************************** */

Matrix *readMatrix(char *file)
{
    FILE *f1 = fopen(file, "r");               // opens file "file"
    Matrix *a = malloc(sizeof(Matrix));        // allocates memory for the Matrix (puts it in the heap)
    fscanf(f1, "%d", &a->size);                // sets the size of the data list equal to the first number in the file
    a->data = malloc(a->size * sizeof(float)); // allocates memory for a float array of size "size"
    for (int i = 0; i < a->size; i++)
    {
        fscanf(f1, "%f", &a->data[i]); // fills the array with inputs from the file
    }
    fclose(f1); // closes the file
    return a;   // returns the created Matrix
}

/******************************
int deleteMatrix(Matrix *a);
Takes in a matrix pointer and returns 1 if the function is successfully run

Frees the float pointer stored in Matrix a and then frees Matrix a
****************************** */

int deleteMatrix(Matrix *a)
{
    free(a->data);//frees the pointer stored in the Matrix object
    free(a);//frees the Matrix a from the heap
    return 1;
}

/******************************
void add(Matrix a, Matrix b);
Takes in two Matrix structures containing a pointer to allocated memory,
and an integer as the size of the matrix

adds two matrices together and prints the output matrix
****************************** */

void add(Matrix a, Matrix b)
{
    printf("A + B =\n");
    for (int i = 0; i < a.size; i++)
    {
        printf("%10.2f", a.data[i] + b.data[i]); // prints the sum of each position
    }
}

/******************************
void sub(Matrix a, Matrix b);
Takes in two Matrix structures containing a pointer to allocated memory,
and an integer as the size of the matrix

subtracts two matrices from each other and prints the output matrix
****************************** */

void sub(Matrix a, Matrix b)
{
    printf("A - B =\n");
    for (int i = 0; i < a.size; i++)
    {
        printf("%10.2f", a.data[i] - b.data[i]); // prints each position subtracted from one another
    }
}

/******************************
void mult(Matrix a, Matrix b);
Takes in two Matrix structures containing a pointer to allocated memory,
and an integer as the size of the matrix

averages the two matrices and prints the output matrix
****************************** */

void avg(Matrix a, Matrix b)
{
    printf("(A + B)/2 =\n");
    for (int i = 0; i < a.size; i++)
    {
        printf("%10.2f", (a.data[i] + b.data[i]) / 2); // prints the average of each position
    }
}