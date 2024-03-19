1)
x + x2 + x3 = 6
x + x2 + 2x3 = 9
2x + 2x2 + 3x3 = 15 ->

1 1 1  6
1 1 2  9
1 2 3 14

1 1 1 6
0 0 1 3
0 1 2 8


The Forward Elimination method Fails here because it never swaps any rows, so it attempts to divide row 2 by 0

The Better Forward Elimination method solves by swapping the largest absolute pivot value in the current column with the
current top of the matrix in order to avoid the problem of having a 0 in the starting row and column

1 1 1  6
1 1 2  9
1 2 3 14

1 1 1 6
0 0 1 3
0 1 2 8

1 1 1 6
0 1 2 8
0 0 1 3


x1 + x2 + x3 = 6
x2 + 2x3 = 8
x3 = 3

x1 + x2 = 3
x2 = 2
x3 = 3

x1 = 1
x2 = 2
x3 = 3


x1 + x2 + x3 = 6
x1 + x2 + 2x3 = 9
2x1 + 2x2 + 3x3 = 15

1 1 1  6
1 1 2  9
2 2 3  15

2 2 3  15
1 1 1  6
1 1 2  9

1 1 3/2  15/2
1 1 1  6
1 1 2  9

1 1 3/2  15/2
0 0 -1/2  -3/2
0 0 1/2  3/2


The Better Forward Elimination Algorithm fails to provide a solution here because it sees that both values it can see
A[1,1] and A[1,2] are 0, and because neither is bigger, it doesn't swap and just divides the row by 0

This bug can be easily fixed by skipping any columns with only 0s remaining

My solution for the given input is:

 1.00 x1 =  1.00
-2.00 x2 = -6.00
 1.00 x3 =  6.00
 3.00 x4 = 30.00
 1.00 x5 = 15.00
 0.67 x6 = 14.00
 1.00 x7 = 28.00
 1.00 x8 = 36.00
 3.00 x9 = 135.00
-2.50 x10 = -137.50
-1.00 x11 = -66.00
-0.80 x12 = -62.40

 simplified to:

x1 = 1.00
x2 = 3.00
x3 = 6.00
x4 = 10.00
x5 = 15.00
x6 = 21.00
x7 = 28.00
x8 = 36.00
x9 = 45.00
x10 = 55.00
x11 = 66.00
x12 = 78.00

Notably, you need to enter in the size of the maxtrix from the file and the filename.
For this question, enter 13 then input.txt

