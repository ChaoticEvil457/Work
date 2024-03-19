import org.junit.Assert; // make sure to use junit 4!!!
import org.junit.Test;

import static org.junit.Assert.*;

public class DesignProblemTests {

    // base case, makes sure the program works in the general case
    @Test
    public void designBaseCase() {
        double[][] temps = { { 98.6d, 100.0d, 99.0d },
                { 99.2d, 101.1d },
                { 102.5d, 96.6d, 93.0d, 99.9d } };

        String[] s = DesignProblem.minAndMaxTemps(temps);
        assertEquals("Entry 1: Minimum Temperature: 98.6 | Maximum Temperature: 100.0",
                s[0]);
        assertEquals("Entry 2: Minimum Temperature: 99.2 | Maximum Temperature: 101.1",
                s[1]);
        assertEquals("Entry 3: Minimum Temperature: 93.0 | Maximum Temperature: 102.5",
                s[2]);
    }

    // works when the list is empty
    @Test
    public void designEmpty() {
        double[][] temps = {};
        assertEquals("No Entries In The Given List",
                DesignProblem.minAndMaxTemps(temps)[0]);
    }

    // works when there is an empty list inside of temps (makes sure that other
    // entries still function normally)
    @Test
    public void designEmptyEntry() {
        double[][] temps = { { 98.6d, 100.0d, 99.0d },
                { 99.2d, 101.1d },
                { 102.5d, 96.6d, 93.0d, 99.9d }, {} };
        assertEquals("Entry 1: Minimum Temperature: 98.6 | Maximum Temperature: 100.0",
                DesignProblem.minAndMaxTemps(temps)[0]);
        assertEquals("No Values Given For Entry 4",
                DesignProblem.minAndMaxTemps(temps)[3]);
    }
}
