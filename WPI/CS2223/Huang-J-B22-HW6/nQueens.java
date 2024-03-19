public class nQueens {
    public static void main(String args[]) {
        int[] solution = { 1, 6, 8, 3, 7, 4, 2, 5 };
        System.out.println(isLegalPosition(solution, 8));// should be true
        int[] solution2 = { 1, 6, 8, 3, 0, 0, 0, 0 };
        System.out.println(isLegalPosition(solution2, 8));// should be true
        System.out.println(nextLegalPosition(solution2, 8));// should be 7
        int[] solution3 = { 1, 6, 8, 3, 5, 0, 0, 0 };
        System.out.println(isLegalPosition(solution3, 8));// should be false
        for (int i = 4; i < 14; i++) {// 4 queens to 13 queens
            queenSolution(i);
            System.out.println();
            numSolutions(i);
        }
    }

    /**
     * Prints out the number of solutions for the n queens problem using n queens
     * 
     * @param n number of queens
     */
    public static void numSolutions(int n) {
        int[] board = new int[n];// creates an empty board
        int count = 0;// counts the number of solutions
        for (int i = 0; i < n; i++) {
            board[i] = 0;
        } // fills board with 0s

        for (int i = 0; i < n; i++) {// initial run, gets the first possible solution
            board[i] = nextLegalPosition(board, i);
            if (board[i] == 0 && i != 0) {// backtracking
                i -= 2;
            }
        }
        while (board[0] != -1) {// board[0] is set to -1 if the first position is off the board
            for (int i = n - 1; i < n; i++) {// starting from the end, works backwards checking positions to find new
                                             // solutions
                board[i] = nextLegalPosition(board, i);
                if (board[i] == 0 && i != 0) {// backtracking
                    i -= 2;
                }
            }
            count++;// increases for every solution found, +1, so we just don't count the first one
                    // to even it out
        }
        System.out.println("There are " + count + " solutions to the " + n + "-Queens Problem");// prints the number of
                                                                                                // solutions
    }

    /**
     * Prints out a possible solution to the n queens problem using n queens
     * 
     * @param n number of queens
     */
    public static void queenSolution(int n) {
        int[] board = new int[n];
        for (int i = 0; i < n; i++) {
            board[i] = 0;
        } // board filled with 0s

        for (int i = 0; i < n; i++) {// finds the first possible legal position for each row
            board[i] = nextLegalPosition(board, i);
            if (board[i] == 0) {// if a piece goes over, backtrack
                i -= 2;
            }
        }
        for (int i = 0; i < n; i++) {// prints out the solution
            System.out.print(board[i] + " ");
        }
    }

    /**
     * Checks if the current board contains only legally placed queens
     * 
     * @param board positions of queens
     * @param n     number of queens to check
     * @return returns true if the solution is valid, false otherwise
     */
    public static boolean isLegalPosition(int[] board, int n) {
        if (n == board.length) {
            n = Successor(board, n);// useful when looking at a partial solution
        }
        n--;// adjusts for arrays starting at 0
        for (int i = 0; i < n; i++) {// compare previous rows to the current one
            if (board[n] == board[i]) {// no duplicates (checks rows)
                return false;
            }
            if (board[n] == board[i] - n + i) {// right-left
                                               // diagonal check
                return false;
            }
            if (board[n] == board[i] + n - i) {// left-right
                                               // diagonal check
                return false;
            }

        }

        return true;
    }

    /**
     * Gets the next legal position for a queen
     * 
     * @param board All currently held positions
     * @param n     Number of queens
     * @return Returns the position of the next legal queen placement or 0 if there
     *         isn't a possible placement
     */
    public static int nextLegalPosition(int[] board, int n) {
        int pos = Successor(board, n);// gets position of the value that needs to be changed
        board[pos]++;// moves the queen left one position
        while (!isLegalPosition(board, pos + 1)) {// checks if the piece is placed legally
            board[pos]++;// moves the queen left one position if it's illegal
        }
        if (board[0] > board.length) {// if the first piece goes off the board, return -1 (used for finding number of
                                      // solutions)
            return -1;
        }
        if (board[pos] > board.length) {// if it goes off the board, return 0
            return 0;
        }
        return board[pos];
    }

    /**
     * Finds the next empty value in the list or returns the size of the list if no
     * values are empty
     * 
     * @param board All current queen positions
     * @param n     Total number of queens
     * @return Returns the position of the first 0 or the last position if there
     *         isn't one
     */
    public static int Successor(int[] board, int n) {
        for (int i = 0; i < n; i++) {
            if (board[i] == 0) {
                return i;
            }
        }
        return n;
    }
}
