import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

public class Examples {
    Mouse m1 = new Mouse(new Food("Grass", 10),
            new Workout(1, 10),
            new Weight(10,
                    new Date(1, 1, 1)));
    Mouse m2 = new Mouse(new Food("Grass", 30),
            new Workout(3, 30),
            new Weight(30,
                    new Date(2, 2, 2)));

    @Test
    public void checkIsHeavier() {
        assertEquals(false, m1.weight.isHeavier(m2.weight));
    }

    @Test
    public void checkIsHeavier2() {
        assertEquals(true, m2.weight.isHeavier(m1.weight));
    }

    @Test
    public void checkWeigh() {
        assertEquals(10.0 - (10.0 / 10) + 1, m1.weigh(new Date(1, 1, 1)), 0.1);
    }

    @Test
    public void checkWeigh2() {//man this mouse lost 24 pounds. my algorithms are awful
        assertEquals(30.0 - 90.0 * (30.0 / 100.0) + 3, m2.weigh(new Date(1, 1, 1)), 0.1);
    }

    LinkedList<Double> testList = new LinkedList<Double>();
    Planning p = new Planning();

    @Test
    public void planTest1() {
        testList.add(1.0);
        testList.add(-2.0);
        testList.add(5.0);
        testList.add(-999.0);
        testList.add(8.0);
        assertEquals(3.0, p.rainfall(testList), 0.1);
    }

    @Test
    public void planTest2() {
        testList.add(1.0);
        testList.add(5.0);
        testList.add(-999.0);
        assertEquals(3.0, p.rainfall(testList), 0.1);
    }

    @Test
    public void planTest3() {
        testList.add(-2.0);
        testList.add(-999.0);
        testList.add(8.0);
        assertEquals(0, p.rainfall(testList), 0.1);
    }
}
