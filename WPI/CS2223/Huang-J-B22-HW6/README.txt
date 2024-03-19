1)
((1 6 8 3 5 0 0 0),8) returns false because the queen in the first row is directly diagonal to the queen in the 5th row
This can be checks by seeing if any piece is in a position equal to the current column minus the number of rows away it is.
so for this case, it would be 5 (current position) - 4 (the difference of rows between 5 and 1) = 1 which is equal to the 
position of the queen in that row, so it would be false.
Additionally, ((5 0 0 0 1 0 0 0),8) has the same problem, so we also need to check the current position plus
the difference in rows for 1 + 4 = 5 which is equal to the position of the queen in that row so it would be false

2)
The next legal position from a legal position doesn't always add a queen to the next row due to how the data is being
stored and how backtracking works. If there is no possible solution for the current set, it will move back a space and
check for a different solution for the next row. If that doesn't work, it will continue until it finds a legal solution 
and then will revert to moving forwards. In this case, the next legal solution changes the position of a queen in a 
previous row, and resets all queens in front of it.

3)
The given solution to the 8 queens problem is not the first one, the actual first solution is ((1 5 8 6 3 7 2 4) 8)

4)
A solution means a set of positions where no two queens can "see" each other.

The validation function for this problem can be changed so that instead of checking if every row is valid, it only checks if
the last row is valid which changes the efficiency from O(n^2) to O(n). This is important when doing the calculations for
larger numbers of solutions as it drastically increases the processing time.
