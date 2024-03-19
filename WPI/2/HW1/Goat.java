public class Goat extends AdoptableHelper {

    public Goat(String name, Double age, Double currentWeight, Coord whereabouts) {
        super(name, age, currentWeight, whereabouts);
    }

    /**
     * @return the difference between the current weight and 55000 plus 1000 times its age in years
     */
    @Override
    public Double deltaWeight() {
        return weightRound(Math.abs(this.currentWeight - (55000 + (1000 * (int) (this.age / 12)))), 2);
    }

}
