import java.util.Scanner;

/* Double Trouble
 * Win condition -> take the last token
 * "Double Trouble" is actually a game called "nim"
 */
class HW1 {
    // there are a set number of tokens,
    // 3 green tokens
    // 7 yellow tokens
    // 5 orange tokens

    public static int green = 3, yellow = 7, orange = 5;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        printBoard();// prints the starting board
        String s;
        int games = 1;
        int aiWins = 0;
        int playerWins = 0;
        int i = 1;
        System.out.println("Would you like to play a tournament? Yes or No");// runs a tournament
        s = scan.next();
        while (!s.equalsIgnoreCase("yes")
                && !s.equalsIgnoreCase("no")) {// prompts for valid input
            System.out.println("Please enter a valid input");
            s = scan.next();
        }
        if (s.equalsIgnoreCase("yes")) {// if you said yes...
            System.out.println("Enter the number of times you will need to win.");
            i = scan.nextInt();// enter the number of wins needed
            while (i < 1) {// reprompts for valid input
                System.out.println("Enter a valid number");
                i = scan.nextInt();
            }
            games = 2 * i - 1;// sets the number of games you'll play
        } else {
            System.out.println("Who will go first? Enter 1 to go first or 2 to let the AI go first");
            s = scan.next();// decides turn order
            while (!s.equals("1") && !s.equals("2")) {// reprompts for invalid inputs
                System.out.println("Please enter a valid input");
                s = scan.next();
            }
        }
        for (int j = 1; j <= games; j++) {
            if (games > 1) {// prints out information if there is a tournament

                System.out.println("\nGame " + j);
                System.out.println("Score: " + Math.max(aiWins, playerWins) + " to " + Math.min(playerWins, aiWins));

                if (aiWins > playerWins) {
                    System.out.println("The AI is winning");
                } else if (playerWins > aiWins) {
                    System.out.println("You are winning");
                } else {
                    System.out.println("The score is currently tied");
                }

                s = "" + ((int) (Math.random() * 2) + 1);// random person goes first

                System.out.println();

                if (s.equals("1")) {
                    System.out.println("You are going first");
                } else {
                    System.out.println("The AI is going first");
                }
                try {// delay to allow reading
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println();
            }
            while (!checkWin()) {
                printBoard();// prints the board
                if (s.equals("1")) {// player goes first
                    playerTurn();// player's turn
                    System.out.println();
                    if (checkWin()) {// checks if the player has won
                        playerWins++;
                        break;
                    }
                }
                try {// delay to allow reading
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                aiTurn();// ai's turn
                if (checkWin()) {// checks if the ai has won
                    aiWins++;
                    break;
                }
                printBoard();// prints the board
                try {// delay to allow reading
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (s.equals("2")) {// ai goes first
                    playerTurn();// player's turn
                    System.out.println();
                    if (checkWin()) {// checks if the player has won
                        playerWins++;
                        break;
                    }
                }
            }
            green = 3;// resets pieces
            yellow = 7;
            orange = 5;
            if (aiWins == i || playerWins == i) {
                break;
            }
        }
        if (games > 1) {// prints tournament winner if you were playing a tournamnet
            if (aiWins > playerWins) {
                System.out.println("The AI won the tournament");
            } else {
                System.out.println("You won the tournament. When the uprising comes, you will be the first to fall.");
            }
        }
        scan.close();// closes the scanner after the game is over
    }

    /*
     * Lets the player make a move
     */
    public static void playerTurn() {
        System.out.println("\nInput the color you would like to take from. (g, y, or o)");
        String s = scan.next();// user input for color

        // reprompts if the color is invalid, or you select a color with no tokens left
        while (!s.equals("g") && !s.equals("y") && !s.equals("o")
                || (s.equals("g") && green == 0) || (s.equals("y") && yellow == 0)
                || (s.equals("o") && orange == 0)) {
            System.out.println("Please select a valid color");
            s = scan.next();// new input
        }
        System.out.println("Input the number of tokens your would like to remove");
        int i = scan.nextInt();// user input for number of tokens

        // reprompts if you try to take too many or too few tokens of the given color
        // this is awkward and I don't like it but I don't know how else to do it. Maybe
        // lambda?
        if (s.equals("g")) {
            while (i > green || i < 1) {
                System.out.println("Please input a valid number of tokens");
                i = scan.nextInt();
            }
        } else if (s.equals("y")) {
            while (i > yellow || i < 1) {
                System.out.println("Please input a valid number of tokens");
                i = scan.nextInt();
            }
        } else {
            while (i > orange || i < 1) {
                System.out.println("Please input a valid number of tokens");
                i = scan.nextInt();
            }
        }
        takeColor(s, i);// removes i tokens from color s
        if (checkWin()) {// checks if the player has won
            System.out.println("You Win");
        }
    }

    /*
     * AI Logic ->
     * If there is one color left, take that color
     * If there are two colors left, continuously make them equal
     * If there are three colors...
     * If any two colors are equal, take the third color
     * If all three colors are equal, take a random color
     * ----other condition
     * Otherwise take 1 from a non-one column if it exists
     * 
     * The other condition needs to force the opponent to make two colors equal
     * So make the colors cancel out? Sum of 2 minus the third = 0?
     * 
     * Looked up the thing, it's nim, use binary, it's really neat
     * It is impossible to win if you make a mistake
     */
    public static void aiTurn() {
        int max = Math.max(Math.max(green, yellow), orange);// finds which color has the most tokens
        int diff = green ^ yellow ^ orange;// Bitwise XOR operation which decides how many to take
        if (diff == 0) {// if the XOR returns 0, the ai has already lost so it just takes one from the
                        // biggest pile
            if (max == green) {
                green--;
            } else if (max == yellow) {
                yellow--;
            } else if (max == orange) {
                orange--;
            }
        } else if (max == green) {// if XOR isn't 0, the ai wins and takes a number equal to the XOR from the
                                  // largest pile
            green ^= diff;
        } else if (max == yellow) {
            yellow ^= diff;

        } else {
            orange ^= diff;
        }
        if (checkWin()) {// checks if the ai has won
            System.out.println("The AI wins");
        }
    }

    /*
     * Takes in a color and number and removes the given number of tokens from the
     * given color global variable
     */
    public static void takeColor(String color, int num) {
        if (color.equals("g")) {
            green -= num;
        } else if (color.equals("y")) {
            yellow -= num;
        } else {
            orange -= num;
        }
    }

    // checks if all tokens are 0 or not
    public static boolean checkWin() {
        if (green + orange + yellow == 0) {// no colors left if all are missing
            return true;
        }
        return false;
    }

    /*
     * Basically hard coded due to the set number of tokens on the board.
     * prints out
     *     g
     *    g g
     *   y y y
     *  y y y y
     * o o o o o
     * and takes into account removed tokens
     */
    public static void printBoard() {
        System.out.print("\n    \u001B[32m");
        for (int i = 0; i < green; i++) {
            if (i == 1) {
                System.out.print("\n   ");
            }
            System.out.print("g ");
        }
        System.out.print("\n  \u001B[33m");
        for (int i = 0; i < yellow; i++) {
            if (i == 3) {
                System.out.print("\n ");
            }
            System.out.print("y ");
        }
        System.out.println("\u001B[31m");
        for (int i = 0; i < orange; i++) {
            System.out.print("o ");
        }
        System.out.println("\u001B[37m");
    }
}