public class Weight {
    double grams;
    Date date;

    public Weight(double grams, Date date) {
        this.grams = grams;
        this.date = date;
    }

    // isHeavier returns true if the current weight is more than the given weight
    public boolean isHeavier(Weight w) {
        if (this.grams > w.grams) {
            return true;
        }
        return false;
    }

    // mice gain 1/10 of the food eaten as weight (made up)
    public void eat(double grams) {
        this.grams += grams / 10;
    }

    // mice lose 1/100th of their body weight for each minuite they work out (made up)
    public void excercise(double minuites) {
        this.grams -= minuites * (grams / 100.0);
    }
}
