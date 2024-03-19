import org.junit.Assert; // make sure to use junit 4!!!
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.LinkedList;

public class Examples {

    // tests the getName function
    @Test
    public void testAdorableGetName() {
        Cat c = new Cat("Todd", 12.0d, 13.0d, new Coord(1, 2));
        c.bestowCredential("Esq.");
        c.bestowTitle("Cpt.");
        assertEquals("Cpt. Todd, Esq.", c.getName());
    }

    // tests the honorablyTitled function
    @Test
    public void testAdorableHonorablyTitled() {
        Cat c = new Cat("Todd", 12.0d, 13.0d, new Coord(1, 2));
        c.bestowCredential("Esq.");
        c.bestowTitle("Cpt.");
        assertTrue(c.honorablyTitled());
        c.bestowCredential("2nd");// works when replacing and adding titles
        assertTrue(c.honorablyTitled());
        c.bestowTitle("Duke");
        assertTrue(c.honorablyTitled());
    }

    // tests the bestowTitle function when the subject already has a title
    @Test
    public void testAdorableReplaceTitle() {
        Cat c = new Cat("Todd", 12.0d, 13.0d, new Coord(1, 2));
        c.bestowTitle("Mr.");
        assertEquals("Mr. Todd", c.getName());
        c.bestowTitle("Dr.");
        assertEquals("Dr. Todd", c.getName());
    }

    // tests the bestowCredential function when the subject already has a credential
    @Test
    public void testAdorableReplaceCred() {
        Cat c = new Cat("Todd", 12.0d, 13.0d, new Coord(1, 2));
        c.bestowCredential("2nd");
        assertEquals("Todd, 2nd", c.getName());
        c.bestowCredential("Esq.");
        assertEquals("Todd, 2nd Esq.", c.getName());
    }

    // tests the bestowTitle function
    @Test
    public void testAdorableAddTitle() {
        Cat c = new Cat("Todd", 12.0d, 13.0d, new Coord(1, 2));
        c.bestowTitle("Dr.");
        assertEquals("Dr. Todd", c.getName());
    }

    // tests the bestorCredential function
    @Test
    public void testAdorableAddCred() {
        Cat c = new Cat("Todd", 12.0d, 13.0d, new Coord(1, 2));
        c.bestowCredential("Esq.");
        assertEquals("Todd, Esq.", c.getName());
    }

    // tests the deltaWeight function for cats when above the age threshold and
    // under the target weight
    @Test
    public void testCatDeltaWeightUnder() {
        Cat c = new Cat("Todd", 1222.0d, 4000.0d, new Coord(1, 2));
        assertEquals(500.0d, c.deltaWeight(), .01d);
    }

    // tests the deltaWeight function for cats when above the age threshold and
    // above the target weight
    @Test
    public void testCatDeltaWeightOver() {
        Cat c = new Cat("Todd", 222.0d, 5000.0d, new Coord(1, 2));
        assertEquals(500.0d, c.deltaWeight(), .01d);
    }

    // tests the deltaWeight function for cats when below the age threshold
    @Test
    public void testCatDeltaWeightYoung() {
        Cat c = new Cat("Todd", 0.0d, 5000.0d, new Coord(1, 2));
        assertEquals(0.0d, c.deltaWeight(), .01d);
    }

    // tests the weighIn method for chinchillas
    @Test
    public void testChinchillaDeltaWeighIn() {
        TheHutchZone z = new TheHutchZone();
        z.registerAdoptable("", 0.0d, 1.0d, null);
        z.registerAdoptable("null", 0.0d, 2.0d, null);
        z.registerAdoptable("null", 0.0d, 3.0d, null);
        assertEquals(2, z.weighIn(0d).size());
    }

    // tests the weighIn method for cats
    @Test
    public void testCatDeltaWeighIn() {
        CatastropheZone z = new CatastropheZone();
        z.registerAdoptable("", 222.0d, 1.0d, null);
        z.registerAdoptable("null", 222.0d, 4500.0d, null);
        z.registerAdoptable("null", 0.0d, 3.0d, null);
        assertEquals(1, z.weighIn(0d).size());
    }

    // tests the weighIn method for goats
    @Test
    public void testGoatDeltaWeighIn() {
        CatastropheZone z = new CatastropheZone();
        z.registerAdoptable("", 12.0d, 55000.0d, null);
        z.registerAdoptable("null", 24.0d, 55000.0d, null);
        z.registerAdoptable("null", 0.0d, 55000.0d, null);
        assertEquals(1, z.weighIn(1000d).size());
    }

    // tests the deltaWeight function for goats when below the target
    @Test
    public void testGoatDeltaWeightUnder() {
        Goat c = new Goat("Todd", 24.0d, 56000.0d, new Coord(1, 2));
        assertEquals(1000.0d, c.deltaWeight(), .01d);
    }

    // tests the deltaWeight function for goats when above the target (takes into
    // account changing target due to age)
    @Test
    public void testGoatDeltaWeightOver() {
        Goat c = new Goat("Todd", 12.0d, 57000.0d, new Coord(1, 2));
        assertEquals(1000.0d, c.deltaWeight(), .01d);
    }

    // tests the cat IZone feed change function
    @Test
    public void testCatZoneChangeFeedAdd() {
        CatastropheZone c = new CatastropheZone();
        assertEquals("Cat: 0 lbs. of dry food | 10 cans of wet food", c.changeFeed("wet", 10));
        assertEquals("Cat: 10 lbs. of dry food | 10 cans of wet food", c.changeFeed("dry", 10));
        assertEquals("Cat: 10 lbs. of dry food | 10 cans of wet food", c.changeFeed("wet1", 10000));
    }

    // tests the cat IZone feed change function with negatives
    @Test
    public void testCatZoneChangeFeedRemove() {
        CatastropheZone c = new CatastropheZone();
        assertEquals("Cat: 0 lbs. of dry food | unknown cans of wet food", c.changeFeed("wet", -10));
        assertEquals("Cat: unknown lbs. of dry food | unknown cans of wet food", c.changeFeed("dry", -10));
        assertEquals("Cat: unknown lbs. of dry food | unknown cans of wet food", c.changeFeed("dry1", -10000));
    }

    // tests the Chinchilla IZone feed change function
    @Test
    public void testHutchZoneChangeFeedAdd() {
        TheHutchZone h = new TheHutchZone();
        assertEquals("Chinchilla: 10 lbs. of pellets | 0 oz. of hay | 0 units of dried fruit",
                h.changeFeed("pellets", 10));
        assertEquals("Chinchilla: 10 lbs. of pellets | 10 oz. of hay | 0 units of dried fruit",
                h.changeFeed("hay", 10));
        assertEquals("Chinchilla: 10 lbs. of pellets | 10 oz. of hay | 10 units of dried fruit",
                h.changeFeed("fruit", 10));
        assertEquals("Chinchilla: 10 lbs. of pellets | 10 oz. of hay | 10 units of dried fruit",
                h.changeFeed("wet", 10));
    }

    // tests the Chinchilla IZone feed change function with negatives
    @Test
    public void testHutchZoneChangeFeedRemove() {
        TheHutchZone h = new TheHutchZone();
        assertEquals("Chinchilla: unknown lbs. of pellets | 0 oz. of hay | 0 units of dried fruit",
                h.changeFeed("pellets", -10));
        assertEquals("Chinchilla: unknown lbs. of pellets | unknown oz. of hay | 0 units of dried fruit",
                h.changeFeed("hay", -10));
        assertEquals("Chinchilla: unknown lbs. of pellets | unknown oz. of hay | unknown units of dried fruit",
                h.changeFeed("fruit", -10));
        assertEquals("Chinchilla: unknown lbs. of pellets | unknown oz. of hay | unknown units of dried fruit",
                h.changeFeed("dry", -10));
    }

    // tests the Goat IZone feed change function
    @Test
    public void testGoatZoneChangeFeedAdd() {
        GoateryZone g = new GoateryZone();
        assertEquals("Goat: 100 piles of edible substance", g.changeFeed(null, 100));
        assertEquals("Goat: 0 piles of edible substance", g.changeFeed(null, -100));
    }

    // tests the Goat IZone feed change function with negatives
    @Test
    public void testGoatZoneChangeFeedRemove() {
        GoateryZone g = new GoateryZone();
        assertEquals("Goat: unknown piles of edible substance", g.changeFeed(null, -100));
    }

    // tests the averageAge function in IZone
    @Test
    public void testAverageAge() {
        CatastropheZone c = new CatastropheZone();
        c.registerAdoptable("", 2d, 0d, null);
        c.registerAdoptable("", 1d, 0d, null);
        c.registerAdoptable("", 3d, 0d, null);
        c.registerAdoptable("", -3d, 0d, null);// adds 0 for negative numbers
        assertEquals(6d / 4d, c.averageAge(), 0.01);
    }

    // negative numbers are turned into 0 in the constructors
    @Test
    public void testCatConstructor() {
        Cat c = new Cat("null", -1d, -1d, null);
        assertEquals(0d, c.age, 0.01d);
        assertEquals(0d, c.currentWeight, 0.01d);
    }

    @Test
    public void testChinchillaConstructor() {
        Chinchilla c = new Chinchilla("null", -1d, -1d, null);
        assertEquals(0d, c.age, 0.01d);
        assertEquals(0d, c.currentWeight, 0.01d);
    }

    @Test
    public void testGoatConstructor() {
        Goat c = new Goat("null", -1d, -1d, null);
        assertEquals(0d, c.age, 0.01d);
        assertEquals(0d, c.currentWeight, 0.01d);
    }

    //test averageAge method in IZone
    @Test
    public void testIZoneAverageAge() {
        CatastropheZone c = new CatastropheZone();
        c.registerAdoptable("null", 1d, 2d, null);
        c.registerAdoptable("null", 2d, 2d, null);
        c.registerAdoptable("null", 3d, 2d, null);
        assertEquals(2d, c.averageAge(), 0.01);
    }

    //test totalYoungins method in IZone
    @Test
    public void testIZoneYoungCount() {
        CatastropheZone c = new CatastropheZone();
        c.registerAdoptable("null", 13d, 2d, null);
        c.registerAdoptable("null", 2d, 2d, null);
        c.registerAdoptable("null", 3d, 2d, null);
        assertEquals(2, c.totalYoungins());
    }

    //test closestTo method in IZone
    @Test
    public void testIZoneClosest() {
        CatastropheZone c = new CatastropheZone();
        c.registerAdoptable("null1", 13d, 2d, new Coord(0,0));
        c.registerAdoptable("null2", 2d, 2d, new Coord(1,1));
        c.registerAdoptable("null3", 3d, 2d, new Coord(-1,-1));
        assertEquals("null1", c.closestTo(new Coord(0,0)).name);
    }
}
