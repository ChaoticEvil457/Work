package Lab2;

interface IAnimal {
    boolean isNormalSize();
}

abstract class AbsAnimal implements IAnimal {
    int length;

    AbsAnimal(int length) {
        this.length = length;
    }

    // determines whether this.length lies between given bounds
    boolean isLenWithin(int low, int high) {
        return low <= this.length && this.length <= high;
    }

    boolean isDangerToPeople() {
        return false;
    }
}

class Dillo extends AbsAnimal {
    boolean isDead;

    Dillo(int length, boolean isDead) {
        super(length);
        this.isDead = isDead;
    }

    // determines whether Dillo is dead and longer than 60
    boolean canShelter() {
        return (this.isDead && this.length > 60);
    }

    // determines whether this dillo's length is between 2 and 3
    public boolean isNormalSize() {
        return isLenWithin(2, 3);
    }
}

class Boa extends AbsAnimal {
    String name;
    String eats;

    Boa(String name, int length, String eats) {
        super(length);
        this.name = name;
        this.eats = eats;
    }

    // determines whether this boa's length is between 5 and 10
    public boolean isNormalSize() {
        return isLenWithin(5, 10);
    }

    public boolean isDangerToPeople() {
        if (eats.equalsIgnoreCase("people")) {
            return true;
        }
        return false;
    }
}

class Fish extends AbsAnimal {
    double salinity;

    Fish(int length, double salinity) {
        super(length);
        this.salinity = salinity;
    }

    public boolean isNormalSize() {
        return isLenWithin(3, 15);
    }
}

class Shark extends Fish {
    int attacks;

    Shark(int length, int attacks) {
        super(length, 35); // 35 grams per liter is average ocean salinity
        this.attacks = attacks;
    }

    public boolean isNormalSize() {
        return isLenWithin(6, 15);
    }

    public boolean isDangerToPeople() {
        if (attacks > 0) {
            return true;
        }
        return false;
    }
}