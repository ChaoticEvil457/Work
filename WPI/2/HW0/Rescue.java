import java.util.ArrayList;
import java.util.LinkedList;

public class Rescue {

    /////////////
    // Autograded
    /**
     * totalKittens takes in a list of litters and returns the sum of all litters
     * 
     * @param litters a list of litters
     * @return the sum of all numbers in the litter, ignoring negatives, or 0 if the
     *         list is empty
     */
    public static int totalKittens(int[] litters) {
        if (litters.length == 0) {
            return 0;
        }
        int c = 0;
        for (int i = 0; i < litters.length; i++) {
            if (litters[i] > 0) {
                c += litters[i];
            }
        }
        return c;
    }

    /**
     * averagePuppyAge takes in a list of puppy ages and returns the average age of
     * that list
     * 
     * @param puppyAges list of puppy ages in months
     * @return the average puppy age ignoring negatives, or zero if the list is
     *         empty
     */
    public static double averagePuppyAge(double[] puppyAges) {
        if (puppyAges.length == 0) {
            return 0;
        }
        double c = 0;
        for (int i = 0; i < puppyAges.length; i++) {
            if (puppyAges[i] > 0) {
                c += puppyAges[i];
            }
        }
        return c / puppyAges.length;
    }

    /**
     * honorablyTitled takes in a name and returns true if it has both a title and
     * credential
     * ("Prince", "Princess", "Duke", "Dutchess", "Baron", "Baroness", "Count",
     * "Countess", "Judge", or a period in the first 5 characters is a valid title)
     * (Any name containing a comma has a valid credential)
     * 
     * @param name string containing the name of the animal
     * @return true if it contains both a title and a credential, false otherwise
     */
    public static boolean honorablyTitled(String name) {
        boolean hasComma = false;
        boolean hasTitle = false;
        String[] valTitles = { "Prince", "Princess", "Duke", "Dutchess", "Baron", "Baroness", "Count", "Countess",
                "Judge" };
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ',') {
                hasComma = true;
            }
            if (i <= 5 && name.charAt(i) == '.') {
                hasTitle = true;
            }
            if (!hasComma && !hasTitle && name.charAt(i) == ' ') {
                String title = name.substring(0, i);
                for (int j = 0; j < valTitles.length; j++) {
                    if (title.equals(valTitles[j])) {
                        hasTitle = true;
                    }
                }
                if (!hasTitle) {
                    return false;
                }
            }
        }
        return hasComma && hasTitle;
    }

    /**
     * Takes in three integers and returns a formatted string
     * 
     * @param pellets pounds of pellets
     * @param hay     ounces of hay
     * @param fruit   units of dried fruit
     * @return "Chinchilla: p lbs. of pellets | h oz. of hay | f units of dried
     *         fruit"
     *         replacing p, h, and f with the above variables, or the word "unknown"
     *         if a negative value is given
     */
    public static String chinchillaFeed(int pellets, int hay, int fruit) {
        String ans = "Chinchilla: ";
        if (pellets < 0) {
            ans += "unknown";
        } else {
            ans += pellets;
        }
        ans += " lbs. of pellets | ";
        if (hay < 0) {
            ans += "unknown";
        } else {
            ans += hay;
        }
        ans += " oz. of hay | ";
        if (fruit < 0) {
            ans += "unknown";
        } else {
            ans += fruit;
        }
        return (ans + " units of dried fruit");
    }

    /**
     * heardingCats takes in a LinkedList of Coords (x,y coordinate pairs) and a
     * location Coord, then returns the closest Coord to the given location Coord
     * 
     * @param catCoords list of x,y coordinate pairing objects
     * @param location  object containing an x,y coordinate pairing
     * @return returns the closest coordinate in catCoords to the location, or null
     *         if catCoords is empty
     */
    public static Coord0 heardingCats(LinkedList<Coord0> catCoords, Coord0 location) {
        if (catCoords.isEmpty()) {
            return null;
        }
        Coord0 closest = catCoords.getFirst();
        double min = Math.sqrt((location.x - closest.x) * (location.x - closest.x)
                + (location.y - closest.y) * (location.y - closest.y));
        double min2;
        for (int i = 0; i < catCoords.size(); i++) {
            min2 = Math.sqrt((location.x - catCoords.get(i).x) * (location.x - catCoords.get(i).x)
                    + (location.y - catCoords.get(i).y) * (location.y - catCoords.get(i).y));
            if (min >= min2) {
                closest = catCoords.get(i);
                min = min2;
            }
        }
        return closest;
    }

    /**
     * goatBloat takes in two lists of Doubles for the current weights of a set of
     * goats and the target weights corresponsing to that set, as well as a Double
     * designating the allowed margin of error, and returns the number of goats
     * outside of the target +- margin of error
     * Ignores entry pairs containing at least one negative value
     * Ignores entries without a pair (currentWeights and targetWeights have
     * different sizes)
     * 
     * @param currentWeights list of goat weights
     * @param targetWeights  list of target goat weights
     * @param errorTolerance allowed margin of error
     * @return number of goats which are outside of the corresponding target weight
     *         +- errorTolerance
     */
    public static int goatBloat(ArrayList<Double> currentWeights, ArrayList<Double> targetWeights,
            double errorTolerance) {
        int fail = 0;
        for (int i = 0; i < currentWeights.size() && i < targetWeights.size(); i++) {
            if (!(currentWeights.get(i) <= 0 || targetWeights.get(i) <= 0)) {
                if (currentWeights.get(i) < targetWeights.get(i) - errorTolerance
                        || currentWeights.get(i) > targetWeights.get(i) + errorTolerance) {
                    fail++;
                }
            }
        }
        return fail;
    }

    /////////////
    // Design
    // get Min and Max temps from a double[][]

}
