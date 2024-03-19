import java.util.LinkedList;

class LinkedListEventGuests implements ISet {

    LinkedList<String> LLEG;// holds a linked list

    /**
     * Constructs a LinkedListEventGuests
     * Holds a new empty LinkedList of Strings
     */
    public LinkedListEventGuests() {
        LLEG = new LinkedList<String>();
    }

    /**
     * Constructs a LinkedListEventGuests
     * 
     * @param LLEG Stored LinkedList
     *             Holds a previously created LinkedList
     */
    public LinkedListEventGuests(LinkedList<String> LLEG) {
        this.LLEG = LLEG;
    }

    /**
     * Adds a given string to the list and returns itself
     * 
     * @param s Given string which is then stored in the list
     * @return returns itself (LinkedListEventGuests)
     */
    public ISet addElt(String s) {
        LLEG.add(s);
        return this;
    }

    /**
     * Finds if a given string is in the list
     * 
     * @param s The string you would like to find
     * @return returns true if the list contains the string, false otherwise
     */
    public boolean hasElt(String s) {
        return LLEG.contains(s);
    }

    /**
     * returns the size of the list
     * 
     * @return returns the size of the list
     */
    public int size() {
        return LLEG.size();
    }

}
