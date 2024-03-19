import org.junit.Assert; // make sure to use junit 4!!!
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

public class Examples0 {

    // base case
    @Test
    public void testTotalKittens() {
        int[] litters = { 5, 3 };
        assertEquals(8, Rescue.totalKittens(litters));
    }

    // tests with empty list
    @Test
    public void testTotalKittensEmpty() {
        int[] litters = {};
        assertEquals(0, Rescue.totalKittens(litters));
    }

    // tests with negative numbers
    @Test
    public void testTotalKittensNegative() {
        int[] litters = { -1, 3 };
        assertEquals(3, Rescue.totalKittens(litters));
    }

    // tests with a single random number
    @Test
    public void testTotalKittensRandom() {
        int c = (int) (Math.random() * 20);
        int[] litters = { c };
        assertEquals(c, Rescue.totalKittens(litters));
    }

    // base case
    @Test
    public void testAveragePuppyAge() {
        double[] ages = { 2, 4 };
        assertEquals(3, Rescue.averagePuppyAge(ages), .01);
    }

    // tests with empty list
    @Test
    public void testAveragePuppyAgeEmpty() {
        double[] ages = {};
        assertEquals(0.0, Rescue.averagePuppyAge(ages), .01);
    }

    // tests with negative numbers
    @Test
    public void testAveragePuppyAgeNegative() {
        double[] ages = { -2, 4 };
        assertEquals(2, Rescue.averagePuppyAge(ages), .01);
    }

    // base case
    @Test
    public void testHonorablyTitledTrue() {
        assertTrue(Rescue.honorablyTitled("Prince Bites-a-lot, MD"));
    }

    // base case 2
    @Test
    public void testHonorablyTitledTruePeriod() {
        assertTrue(Rescue.honorablyTitled("Dr. Fluffykins, MD"));
    }

    //works on an empty string
    @Test
    public void testHonorablyTitledFalseEmpty() {
        assertFalse(Rescue.honorablyTitled(""));
    }
    // tests to make sure both title and credential need to be present
    @Test
    public void testHonorablyTitledFalseMissingTitle() {
        assertFalse(Rescue.honorablyTitled("Bites-a-lot, MD"));
    }

    // tests to make sure both title and credential need to be present
    @Test
    public void testHonorablyTitledFalseMissingCredit() {
        assertFalse(Rescue.honorablyTitled("Prince Bites-a-lot"));
    }

    // checks that the method doesn't just look for the presence of a comma and
    // period in the name
    @Test
    public void testHonorablyTitledFalseLatePeriod() {
        assertFalse(Rescue.honorablyTitled("Bites-a-lot, Esq."));
    }

    // checks that only valid titles are accepted,
    // and that an unknown title, with the presence of a period and comma doesn't
    // always return true
    @Test
    public void testHonorablyTitledFalseBadTitle() {
        assertFalse(Rescue.honorablyTitled("Charles Todd, Esq."));
    }

    // Titles are one of "Prince", "Princess", "Duke" "Dutchess" "Baron" "Baroness"
    // "Count" "Countess" or "Judge"
    @Test
    public void testHonorablyTitledFalseRoyal1() {
        assertTrue(Rescue.honorablyTitled("Prince Todd, Esq."));
    }

    @Test
    public void testHonorablyTitledFalseRoyal2() {
        assertTrue(Rescue.honorablyTitled("Princess Todd, Esq."));
    }

    @Test
    public void testHonorablyTitledFalseRoyal3() {
        assertTrue(Rescue.honorablyTitled("Duke Todd, Esq."));
    }

    @Test
    public void testHonorablyTitledFalseRoyal4() {
        assertTrue(Rescue.honorablyTitled("Dutchess Todd, Esq."));
    }

    @Test
    public void testHonorablyTitledFalseRoyal5() {
        assertTrue(Rescue.honorablyTitled("Baron Todd, Esq."));
    }

    @Test
    public void testHonorablyTitledFalseRoyal6() {
        assertTrue(Rescue.honorablyTitled("Baroness Todd, Esq."));
    }

    @Test
    public void testHonorablyTitledFalseRoyal7() {
        assertTrue(Rescue.honorablyTitled("Count Todd, Esq."));
    }

    @Test
    public void testHonorablyTitledFalseRoyal8() {
        assertTrue(Rescue.honorablyTitled("Countess Todd, Esq."));
    }

    @Test
    public void testHonorablyTitledFalseRoyal9() {
        assertTrue(Rescue.honorablyTitled("Judge Todd, Esq."));
    }

    // Makes sure there's a space between the title and name
    @Test
    public void testHonorablyTitledFalseSpaces() {
        assertFalse(Rescue.honorablyTitled("PrinceTodd, Esq."));
    }

    // checks that credentials have a comma in front
    @Test
    public void testHonorablyTitledFalseBadCred() {
        assertFalse(Rescue.honorablyTitled("Prince Todd MD"));
    }

    // base case
    @Test
    public void testChinchillaFeed() {
        assertEquals("Chinchilla: 4 lbs. of pellets | 13 oz. of hay | 22 units of dried fruit",
                Rescue.chinchillaFeed(4, 13, 22));
    }

    // tests with negative numbers
    @Test
    public void testChinchillaFeedUnknown() {
        assertEquals("Chinchilla: unknown lbs. of pellets | unknown oz. of hay | unknown units of dried fruit",
                Rescue.chinchillaFeed(-1, -1, -1));
    }

    // base case
    @Test
    public void testHeardingCats() {
        LinkedList<Coord0> i = new LinkedList<>();
        Coord0 j = new Coord0(0, 0);
        i.add(j);
        i.add(new Coord0(10, 10));
        assertEquals(j, Rescue.heardingCats(i, new Coord0(1, 0)));
    }

    // tests with empty list
    @Test
    public void testHeardingCatsEmpty() {
        LinkedList<Coord0> i = new LinkedList<>();
        assertEquals(null, Rescue.heardingCats(i, new Coord0(1, 0)));
    }

    // tests with a distance tie between coords, returns the later one
    @Test
    public void testHeardingCatsTie() {
        LinkedList<Coord0> i = new LinkedList<>();
        Coord0 j = new Coord0(0, 1);
        Coord0 k = new Coord0(1, 0);
        i.add(j);
        i.add(k);
        assertEquals(k, Rescue.heardingCats(i, new Coord0(0, 0)));
    }

    // base case
    @Test
    public void testGoatBloat() {
        ArrayList<Double> a = new ArrayList<>();
        a.add(1.0);
        a.add(2.0);
        a.add(3.0);
        ArrayList<Double> b = new ArrayList<>(3);
        b.add(1.0);
        b.add(1.0);
        b.add(1.0);
        assertEquals(1, Rescue.goatBloat(a, b, 1));
    }

    // tests with different numbers of weights
    @Test
    public void testGoatBloatUneven() {
        ArrayList<Double> a = new ArrayList<>();
        a.add(1.0);
        a.add(2.0);
        ArrayList<Double> b = new ArrayList<>(3);
        b.add(1.0);
        b.add(1.0);
        b.add(1.0);
        assertEquals(0, Rescue.goatBloat(a, b, 1));
    }

    // tests with different numbers of targets
    @Test
    public void testGoatBloatUneven2() {
        ArrayList<Double> a = new ArrayList<>();
        a.add(1.0);
        a.add(2.0);
        a.add(3.0);
        ArrayList<Double> b = new ArrayList<>(3);
        b.add(1.0);
        b.add(1.0);
        assertEquals(0, Rescue.goatBloat(a, b, 1));
    }

    // tests with negative numbers
    @Test
    public void testGoatBloatNegative() {
        ArrayList<Double> a = new ArrayList<>();
        a.add(1.0);
        a.add(2.0);
        a.add(3.0);
        ArrayList<Double> b = new ArrayList<>(3);
        b.add(-1.0);
        b.add(1.0);
        b.add(-1.0);
        assertEquals(0, Rescue.goatBloat(a, b, 1));
    }
}
