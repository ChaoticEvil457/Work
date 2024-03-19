public class GoateryZone extends IZoneHelper {
    // amount of food held
    int substance = 0;

    // constructor
    @Override
    public IZone registerAdoptable(String name, Double age, Double currentWeight, Coord whereabouts) {
        petList.add(new Goat(name, age, currentWeight, whereabouts));
        return this;
    }

    /**
     * takes in a type of food and quantity and returns a formatted string with the
     * change
     * 
     * @param food     type of food
     * @param quantity amount of food
     * @return formatted string containing the new amount of food
     */
    @Override
    public String changeFeed(String food, Integer quantity) {
        substance += quantity;
        if (substance < 0) {
            return "Goat: unknown piles of edible substance";
        }
        return "Goat: " + substance + " piles of edible substance";
    }

}
