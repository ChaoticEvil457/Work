public class Food {
    String type;
    double grams;

    public Food(String type, double grams) {
        this.type = type;
        this.grams = grams;
    }

    // eat 1/4 less when on a diet
    public void diet() {
        this.grams -= this.grams * 0.25;
    }

    // eat 1/4 more when fattening up
    public void fatten() {
        this.grams += this.grams * 0.25;
    }
}
