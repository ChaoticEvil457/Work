package Lab1;

import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {
    Song HapBD = new Song("Happy Birthday", 18,new Album("unknown","casual"));
    Song s2 = new Song("12", 3,new Album("null","null"));

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
    public void checkHBLen() {
        assertEquals(18, HapBD.lenInSeconds);//true
    }
    @Test
    public void checkS2Len() {
        assertEquals(3, 2);//false
    }
    @Test
    public void checkHBGenre(){
        assertEquals("casual", HapBD.onAlbum.genre);//true
    }
    @Test
    public void checkS2Genre(){
        assertEquals("null", s2.onAlbum.genre);//true
    }

}