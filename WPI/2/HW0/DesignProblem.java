/* I forgot to attatch this file when submitting the homework
 * When encoding an old spreadsheet of newborn animal data, we encode the information as a 2D array of numbers.
In this case, the temperature readings of the newborns is kept in a double[][].
Design a static function and (recommended) a methodless data object to solve the following problem:
Given a 2D array of doubles of all the temperature readings where each outer array (row) represents a newborn and each inner array (column) represents a temp reading, produce a result that easily shows us the min and max temp for each newborn.

There is no single right answer, and so you will be graded on how well you document and test your solution to show that it works.

You may make a non-static answer if you like by making a class with methods, but you are not required too (Classes with stateful methods is the goal of HW1 and beyond).

 */
public class DesignProblem {

    /**
     * minAndMaxTemps takes in a list of double lists and returns a list of
     * formatted strings showing the minimum and maximum temperatures for each
     * newborn
     * 
     * @param tempList a list of double lists with all recorded newborn temperatures
     * @return a list of formatted strings, or an error for no given entries
     */
    public static String[] minAndMaxTemps(double[][] tempList) {
        if (tempList.length == 0) {
            return new String[] { "No Entries In The Given List" };
        }
        double minTemp;// placeholder for current min temperature
        double maxTemp;// placeholder for current max temperature
        String[] result = new String[tempList.length];// holds results
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].length != 0) {

                minTemp = tempList[i][0];// starts at the first value
                maxTemp = tempList[i][0];
                for (int j = 1; j < tempList[i].length; j++) {
                    if (tempList[i][j] < minTemp) {// checks each value for a smaller value
                        minTemp = tempList[i][j];
                    }
                    if (tempList[i][j] > maxTemp) {// checks for a bigger value
                        maxTemp = tempList[i][j];
                    }
                }
                result[i] = "Entry " + (i + 1) + ": Minimum Temperature: " + minTemp + " | Maximum Temperature: "
                        + maxTemp;
            } else {
                result[i] = "No Values Given For Entry " + (i + 1);
            }
        }
        return result;
    }
}
