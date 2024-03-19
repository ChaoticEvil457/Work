import java.util.LinkedList;

public abstract class IZoneHelper implements IZone {

    LinkedList<Adoptable> petList = new LinkedList<>();

    /**
     * @return the number of animals in the zone age 0 to 12 months
     */
    @Override
    public int totalYoungins() {
        int c = 0;
        for (int i = 0; i < petList.size(); i++) {
            if (petList.get(i).age >= 0 && petList.get(i).age <= 12) {
                c++;
            }
        }
        return c;
    }

    /**
     * @return average age of pets in the list
     */
    @Override
    public double averageAge() {
        double c = 0;
        for (int i = 0; i < petList.size(); i++) {
            c += petList.get(i).age;
        }
        return c / petList.size();
    }

    /**
     * finds the closest animal to the given location
     * 
     * @param location the location we're finding an animal close to
     * @return the closest animal to the given coordinate
     */
    @Override
    public Adoptable closestTo(Coord location) {
        if (petList.isEmpty()) {
            return null;
        }
        Adoptable closest = petList.getFirst();
        double min = Math.sqrt((location.x - closest.whereabouts.x) * (location.x - closest.whereabouts.x)
                + (location.y - closest.whereabouts.y) * (location.y - closest.whereabouts.y));
        double min2;
        for (int i = 0; i < petList.size(); i++) {
            min2 = Math.sqrt((location.x - petList.get(i).whereabouts.x) * (location.x - petList.get(i).whereabouts.x)
                    + (location.y - petList.get(i).whereabouts.y) * (location.y - petList.get(i).whereabouts.y));
            if (min >= min2) {
                closest = petList.get(i);
                min = min2;
            }
        }
        return closest;
    }

    /**
     * takes in a threshold and returns a linkedList of all animals which fall up to
     * threshold distance from the target weight
     * 
     * @param threshold the distance a pet is allowed to be from the target weight
     * @return a list of pets theshold distance from the target weight
     */
    @Override
    public LinkedList<Adoptable> weighIn(Double threshold) {
        LinkedList<Adoptable> unhealthy = new LinkedList<>();
        for (int i = 0; i < petList.size(); i++) {
            if (petList.get(i).deltaWeight() > threshold) {
                unhealthy.add(petList.get(i));
            }
        }
        return unhealthy;
    }
}
