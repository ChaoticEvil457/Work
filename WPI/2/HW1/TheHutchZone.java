public class TheHutchZone extends IZoneHelper {
    // amount of food held
    int pellets = 0;
    int hay = 0;
    int fruit = 0;

    // constructor
    @Override
    public IZone registerAdoptable(String name, Double age, Double currentWeight, Coord whereabouts) {
        Chinchilla c = new Chinchilla(name, age, currentWeight, whereabouts);
        petList.add(c);
        c.hutch = petList;// the chinchilla object needs the hutch it's in to figure out the delta weight
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
        if (food.equals("pellets")) {
            pellets += quantity;
        } else if (food.equals("hay")) {
            hay += quantity;
        } else if (food.equals("fruit")) {
            fruit += quantity;
        }
        String output = "Chinchilla: ";
        if (pellets < 0) {
            output += "unknown";
        } else {
            output += pellets;
        }
        output += " lbs. of pellets | ";
        if (hay < 0) {
            output += "unknown";
        } else {
            output += hay;
        }
        output += " oz. of hay | ";
        if (fruit < 0) {
            output += "unknown";
        } else {
            output += fruit;
        }
        return output + " units of dried fruit";
    }

}
