// A class for storing guests at a (potentially large) event

import java.util.LinkedList;

class EventGuests {

    ISet guests;

    /**
     * Creates a new EventGuests
     * 
     * @param guests takes in a class which implements ISet (and is therefore some
     *               sort of list)
     */
    EventGuests(ISet guests) {
        this.guests = guests;
    }

    /**
     * Creates a new EventGuests
     * 
     * @param guests Special case for LinkedLists, creates a LinkedListEventGuests
     *               object which uses the ISet interface
     */
    EventGuests(LinkedList<String> guests) {
        this.guests = new LinkedListEventGuests(guests);
    }

    /**
     * records a new guest coming and adds them to the set
     * 
     * @param newGuestName Takes in the name of the new guest
     * @return returns itself (EventGuests)
     */

    EventGuests addGuest(String newGuestName) {
        guests = guests.addElt(newGuestName);
        return this;
    }

    /**
     * Checks if a guest is coming
     * 
     * @param name name of the guest you want to find in the set
     * @return returns true if the guest exists, and false otherwise
     */
    boolean isComing(String name) {
        return guests.hasElt(name);
    }

    /**
     * @return returns the size of the set
     */
    int numGuests() {
        return guests.size();
    }

}