import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class Examples {
    // an EventGuests that uses LinkedLists under the hood

    EventGuests guestsLists = new EventGuests(new LinkedList<String>());

    // an EventGuests that uses BSTs under the hood

    EventGuests guestsBSTs = new EventGuests(new EmptyBST());
    // an EventGuests that uses AVL trees under the hood

    EventGuests guestsAVLs = new EventGuests(new AVLTest());

    @Test
    public void checkAddLL() {// checks if the addGuest function works, and if the isComing function works for
                              // LinkedLists
        guestsLists.addGuest("g1");
        assertTrue(guestsLists.isComing("g1"));
    }

    @Test
    public void checkAddBST() {// checks if the addGuest function works, and if the isComing function works for
                               // BSTs
        guestsBSTs.addGuest("g1");
    }

    @Test
    public void checkSizeLL() {// checks if the numGuests function works for LinkedLists
        guestsLists.addGuest("g1");
        assertEquals(1, guestsLists.numGuests());
    }

    @Test
    public void checkSizeBST() {// checks if the numGuests function works for BSTs
        guestsBSTs.addGuest("g1");
        assertEquals(1, guestsBSTs.numGuests());
    }
}
