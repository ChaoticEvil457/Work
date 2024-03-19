import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MostPreciousPath {
    public static int max;// stores the largest scoe
    public static String finalMoves;// stores the moves made
    public static int lastTile;// stores the last tile moved to (Location of Arkenstone)
    public static int firstTile; // stores the starting tile

    public static void main(String[] args) throws FileNotFoundException {
        int size = 8;// size of boards
        int[][] ray = new int[size][size];
        System.out.println("Enter the name of a file");
        Scanner s = new Scanner(System.in);

        File f = new File(s.next());// user file input
        Scanner scan = new Scanner(f);

        for (int i = 0; i < size; i++) {// fills the board with file values
            for (int j = 0; j < size; j++) {
                if (scan.hasNextInt()) {
                    ray[i][j] = scan.nextInt();
                }
            }
        }
        finalMoves = "";// sets global variables to definite values
        lastTile = 0;
        max = 0;
        firstTile = 0;
        for (int i = 0; i < ray.length; i++) {
            gemSum(ray, 0, ray.length - 1, i, "", i + 1);
        }
        System.out.println("Started from tile " + firstTile + "\nThe path taken was:\n" + finalMoves + "\n" + max
                + " gems were gathered\nThe Arkenstone was sealed in vault " + lastTile + ".");// prints out info
        scan.close();
    }

    /**
     * Gets the maximum sum of gems as well as the path taken
     * 
     * @param ray   2D List holding the board and all information
     * @param score Current number of gems collected
     * @param y     Y position
     * @param x     X position
     * @param moves Stores the moves taken
     * @return returns the score
     */
    public static int gemSum(int[][] ray, int score, int y, int x, String moves, int start) {

        if (x < 0 || x >= 8) {// if out of bounds, end the current run
            return -1;
        }
        if (y < 0) {// if you've reached the far end, return the current accumulated score

            return score;
        }
        score += ray[y][x];// adds the current position's value to the score
        if (score > max) {// when you get a new maximum score, it records your moves, starting, and ending
                          // tiles
            max = score;
            finalMoves = moves;
            lastTile = x + 1;
            firstTile = start;
        }
        score = Math.max(// gets the maximum score from each possible path
                Math.max(gemSum(ray, score, y - 1, x, moves + "Forwards\n", start),
                        gemSum(ray, score, y - 1, x - 1, moves + "Diagonal Left\n", start)),
                gemSum(ray, score, y - 1, x + 1, moves + "Diagonal Right\n", start));
        return score;
    }
}
