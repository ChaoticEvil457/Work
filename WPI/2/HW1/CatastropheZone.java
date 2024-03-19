public class CatastropheZone extends IZoneHelper {
    // amount of food held
    int dry = 0;
    int wet = 0;

    // constructor
    @Override
    public IZone registerAdoptable(String name, Double age, Double currentWeight, Coord whereabouts) {
        petList.add(new Cat(name, age, currentWeight, whereabouts));
        return this;
    }

    /**
     * takes in a string food and an integer quantity then adds the quantity to the
     * respective type of food if it exists and returns a formatted string
     * 
     * @param food     type of food
     * @param quantity change in food
     * @return formatted string showing the new quantities for each food type
     */
    @Override
    public String changeFeed(String food, Integer quantity) {
        if (food.equals("wet")) {
            wet += quantity;
        } else if (food.equals("dry")) {
            dry += quantity;
        }
        String output = "Cat: ";
        if (dry < 0) {
            output += "unknown";
        } else {
            output += dry;
        }
        output += " lbs. of dry food | ";
        if (wet < 0) {
            output += "unknown";
        } else {
            output += wet;
        }
        return output + " cans of wet food";
    }
}
