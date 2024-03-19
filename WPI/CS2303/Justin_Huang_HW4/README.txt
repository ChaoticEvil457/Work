This program adds, subtracts, or multiplies two matricies.

In order to run this program, run:
make
or
gcc -Wall -o matrixCalc matrix_calc.c matrix_math.c -lm
Then run the matrixCalc file in the format:
./matrixCalc file1 file2 opperation
where file1 holds the size of matrix A and values in matrix A
and file 2 holds the size of matrix B and values in matrix B
The program will then prompt a character response of a, s or n standing for add, subtract, or average
Afterwards it will print out 

A (+ or -) B(/2 for average) = 
    num1 num2 num3 num4

changing depending on sizes of matricies

Invalid inputs will return an error statement.

I had a slight problem with making the Matrix objects because I didn't make them pointers at first,
But I was able to solve it with an email to the teacher. I completed it Wendsday after the lab