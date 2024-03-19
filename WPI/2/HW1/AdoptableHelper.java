public abstract class AdoptableHelper extends Adoptable {

    // checks if a title and/or credential has been bestowed
    boolean hasTitle = false;
    boolean hasCredential = false;

    // constructor
    public AdoptableHelper(String name, Double age, Double currentWeight, Coord whereabouts) {
        super(name, age, currentWeight, whereabouts);
    }

    /**
     * returns the animal's name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * returns true if the animal is both titled and credentialed
     */
    @Override
    public Boolean honorablyTitled() {
        return hasTitle && hasCredential;
    }

    /**
     * Adds a title to the animal's name, or replaces its title if it already has
     * one
     */
    @Override
    public void bestowTitle(String title) {
        if (hasTitle) {
            for (int i = 0; i < name.length() - 1; i++) {
                if (name.charAt(i) == ' ') {
                    name = name.substring(i + 1);// removes the previous title
                    i = name.length();
                }
            }
        }
        hasTitle = true;
        name = title + " " + name;
    }

    /**
     * Adds a credential to the animal's name, or replaces its credential if it
     * already has one
     */
    @Override
    public void bestowCredential(String credential) {
        if (hasCredential) {
            name = name + " " + credential;
        } else {
            hasCredential = true;
            name = name + ", " + credential;
        }
    }

}
