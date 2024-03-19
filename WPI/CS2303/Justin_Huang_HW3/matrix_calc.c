#include <stdio.h>
#include <stdlib.h>

/******************************
matrix_calc.c
Name: Justin Huang
Date: 9/16/22

Gets 2 inputs as a size of matrix A, and creates that matrix with
more user inputs,
Gets 2 inputs as a size of matrix B, and creates that matrix with
more user inputs,
Then preforms some function on those matricies (add, subtract, multiply)
****************************** */


struct matrix // Matrix object has a pointer, number of rows, and number of columns
{
    float *m;
    int rows;
    int cols;
};

typedef struct matrix Matrix; // when defining the object, use uppercase Matrix

void add(Matrix a, Matrix b);  // adds two matricies
void sub(Matrix a, Matrix b);  // subtracts two matricies
void mult(Matrix a, Matrix b); // multiplies two matricies

int main(void)
{
    Matrix a; // declares matrix A and B
    Matrix b;
    printf("What is the size of matrix A:\n");
    scanf("%d%d", &a.rows, &a.cols);               // gets size of matrix A
    a.m = malloc(a.rows * a.cols * sizeof(float)); // allocates memory equal to the size of the matrix * memory size of float
                                                   //(the matrix will have floats)
    printf("Enter the value for A:\n");
    for (int i = 0; i < a.rows * a.cols; i++)
    {
        scanf("%f", &a.m[i]); // gets inputs for matrix A
    }
    printf("What is the size of matrix B:\n");
    scanf("%d%d", &b.rows, &b.cols);               // gets size of matrix B
    b.m = malloc(b.rows * b.cols * sizeof(float)); // allocates memory equal to the size of the matrix * memory size of float
    printf("Enter the value for B:\n");
    for (int i = 0; i < b.rows * b.cols; i++)
    {
        scanf("%f", &b.m[i]); // gets inputs for matrix B
    }
    printf("Would you like to add, subtract or multiply? Please enter a, s or m:\n");
    char opp;
    scanf(" %c", &opp); // gets a character input to decide what opperator to use

    if (opp == 'm' && a.rows == b.cols && a.cols == b.rows)
    { // when multiplying matricies, the number of rows of A must equal columns of B and vice versa
        printf("A * B =");
        mult(a, b); // multiplies matricies
    }
    else if (a.rows == b.rows && a.cols == b.cols)
    { // when adding or subtracting matricies, they must be the same size
        if (opp == 'a')
        {
            printf("A + B =");
            add(a, b); // adds
        }
        if (opp == 's')
        {
            printf("A - B =");
            sub(a, b); // subtracts
        }
    }
    else
    { // invalid inputs print an error statement
        printf("This math cannot be performed.");
    }
    free(a.m); // frees memory
    free(b.m);
}

/******************************
void add(Matrix a, Matrix b);
Takes in two Matrix structures containing a pointer to allocated memory,
and two integers cooresponding to the number of rows and columns in the matrix

adds two matricies together and prints the output matrix
****************************** */

void add(Matrix a, Matrix b)
{
    for (int i = 0; i < a.rows * a.cols; i++)
    {
        if (i % a.cols == 0)
        {
            printf("\n"); // creates a new line for each row of the output matrix
        }
        printf("%10.2f", a.m[i] + b.m[i]); // prints the sum of each position
    }
}

/******************************
void sub(Matrix a, Matrix b);
Takes in two Matrix structures containing a pointer to allocated memory,
and two integers cooresponding to the number of rows and columns in the matrix

subtracts two matricies from each other and prints the output matrix
****************************** */

void sub(Matrix a, Matrix b)
{
    for (int i = 0; i < a.rows * a.cols; i++)
    {
        if (i % a.cols == 0)
        {
            printf("\n"); // new line for each row of output matrix
        }
        printf("%10.2f", a.m[i] - b.m[i]); // prints each position subtracted from one another
    }
}

/******************************
void mult(Matrix a, Matrix b);
Takes in two Matrix structures containing a pointer to allocated memory,
and two integers cooresponding to the number of rows and columns in the matrix

multiplies two matricies together and prints the output matrix
****************************** */

void mult(Matrix a, Matrix b)
{
    float num = 0;                   // temp variable holds sum of individual positions
    for (int i = 0; i < a.rows; i++) // increments A row checked
    {
        for (int j = 0; j < b.cols; j++) // increments B column checked
        {
            for (int k = 0; k < a.cols; k++) // increments A column checked
            {                                // for each row in A, add each value
                                             // in that row multiplied by the corresponding position in B
                num += a.m[i * a.cols + k] * b.m[j + b.cols * k];
            }
            if (j % b.cols == 0)
            {
                printf("\n"); // new line for each row of output matrix
            }
            printf("%10.2f", num); // prints final sum
            num = 0;               // resets temp variable
        }
    }
}