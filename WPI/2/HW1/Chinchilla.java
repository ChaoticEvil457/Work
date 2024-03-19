import java.util.LinkedList;

public class Chinchilla extends AdoptableHelper {
    LinkedList<Adoptable> hutch;

    // constructor
    public Chinchilla(String name, Double age, Double currentWeight, Coord whereabouts) {
        super(name, age, currentWeight, whereabouts);
    }

    /**
     * @return the magnitude of the weight minus the average weight of each member
     *         of the hutch
     */
    @Override
    public Double deltaWeight() {
        if (hutch.isEmpty()) {
            return 0.0d;
        }
        double c = 0;
        for (int i = 0; i < hutch.size(); i++) {
            c += hutch.get(i).currentWeight;
        }
        return weightRound(Math.abs(this.currentWeight - (c / hutch.size())), 2);
    }

}
