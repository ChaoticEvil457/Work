public class Precinct {
    String name;
    String address;
    int population;

    public Precinct(String name, String address, int population) {
        this.name = name;
        this.address = address;
        this.population = population;
    }

    public String toString() {
        return ("Precinct: " + name + ", Address: " + address + ", Population: " + population);
    }

    public Precinct grow(int amount) {
        return new Precinct(name, address, population + amount);
    }
}
