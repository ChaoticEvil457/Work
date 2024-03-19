import java.util.ArrayList;

class HuangJSubirachstuffD22HW2 {
    static int ans = 0;// holds the number of sums that have been found

    public static void main(String[] args) {
        int[] square = { 1, 14, 14, 4, 11, 7, 6, 9, 8, 10, 10, 5, 13, 2, 3, 15 };// given square

        System.out.println(
                "There are " + sumOfFourNumbers(square) + " combinations of 4 numbers which add to 33");
        allSums(square, 0, 0, 33);
        System.out.println("There are " + ans + " combinations of any number of numbers which add to 33");
        System.out.println("Sums for " + 0 + " = " + 0);
        for (int i = 1; i < 133; i++) {
            ans = 0;
            allSums(square, 0, 0, i);
            if (ans > 1360) // can be removed to show all sums, but this gives easy access to the highest
                            // number
                System.out.println("Sums for " + i + " = " + ans);

        }
    }

    /*
     * allSums takes in the given list, a starting sum (always 0), a
     * starting position (always 0), and a target number
     * Sum is an accumulator
     * Target is the number you're trying to reach
     * Pos is the position in the list you start from
     */

    public static void allSums(int[] square, int sum, int pos, int target) {
        if (sum == target) {// if you've hit the target...
            ans++;// adds one to number of possible sums
            return;
        }
        for (int i = pos; i < square.length; i++) {// runs through the list
            if (sum + square[i] <= target) {// if adding the current position in the list doesn't go over the target...
                sum += square[i];// add the number to the target
                allSums(square, sum, i + 1, target);// try to add another number from the list, or add one to found sums
                                                    // if you hit the target
                sum -= square[i];// remove the number to continue looking for combinations
            }
        }
    }

    /*
     * sumOfFourNumbers takes in the given list and returns the number of possible
     * sums with any 4 numbers in the list
     * gets 4 positions in order, then adds all possible combonations of 4 numbers
     * in the list
     */
    public static int sumOfFourNumbers(int[] square) {
        int sum = 0;
        for (int i = 0; i < square.length - 3; i++) {// first position
            for (int j = i + 1; j < square.length - 2; j++) {// second position
                for (int k = j + 1; k < square.length - 1; k++) {// third position
                    for (int l = k + 1; l < square.length; l++) {// fourth position
                        if (square[i] + square[j] + square[k] + square[l] == 33) {// if the sum of positions equals 33
                            sum++;// add one to possible sums
                        }
                    }
                }
            }
        }
        return sum;
    }
}