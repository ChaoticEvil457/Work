public class Cat extends AdoptableHelper {

    // consructor
    public Cat(String name, Double age, Double currentWeight, Coord whereabouts) {
        super(name, age, currentWeight, whereabouts);
    }

    /**
     * @return 0 if the cat is under 2 years old. Otherwise the magnitude of the current weight - 4500g
     */
    @Override
    public Double deltaWeight() {
        if (age < 24) {
            return 0.0d;
        }
        return weightRound(Math.abs((this.currentWeight - 4500.0d)), 2);
    }
}
