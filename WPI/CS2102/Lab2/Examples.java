package Lab2;

import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {

    public Examples() {
    }

    /*
     * // This shows what a test case looks like
     * 
     * @Test
     * public void simpleCheck() {
     * assertEquals(4, 4);
     * }
     */
    @Test
    public void checkFishLengthA() {// small fish isn't normal
        assertEquals(false, new Fish(0, 0).isNormalSize());
    }

    @Test
    public void checkFishLengthB() {// normal fish
        assertEquals(true, new Fish(4, 0).isNormalSize());
    }

    @Test
    public void checkFishLengthC() {// way too big
        assertEquals(false, new Fish(100, 0).isNormalSize());
    }

    @Test
    public void checkSharkLengthA() {// small shark isn't normal
        assertEquals(false, new Shark(0, 0).isNormalSize());
    }

    @Test
    public void checkSharkLengthB() {// normal
        assertEquals(true, new Shark(7, 0).isNormalSize());
    }

    @Test
    public void checkSharkLengthC() {// way too big
        assertEquals(false, new Shark(100, 0).isNormalSize());
    }

    @Test
    public void checkSharkLengthD() {// sharks are bigger than fish
        assertEquals(false, new Shark(4, 0).isNormalSize());
    }

    @Test
    public void checkDangerBoaA() {// safe boa, eats mice
        assertEquals(false, new Boa("Charles", 20, "Mice").isDangerToPeople());
    }

    @Test
    public void checkDangerBoaB() {// dangerous boa eats people
        assertEquals(true, new Boa("Charles", 20, "People").isDangerToPeople());
    }

    @Test
    public void checkDangerSharkA() {// dangerous shark has attacked
        assertEquals(true, new Shark(20, 3).isDangerToPeople());
    }

    @Test
    public void checkDangerSharkB() {// safe shark hasn't attacked
        assertEquals(false, new Shark(20, 0).isDangerToPeople());
    }

    @Test
    public void checkDangerFish() {// fish aren't dangerous
        assertEquals(false, new Fish(20, 0).isDangerToPeople());
    }

}