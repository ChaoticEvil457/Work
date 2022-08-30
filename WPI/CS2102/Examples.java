package WPICS2102;
import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {
    Song HapBD = new Song("Happy Birthday", 18);
    public Examples(){}
    
    /*
    // This shows what a test case looks like
    @Test 
    public void simpleCheck() {
	assertEquals(4, 4);
    }
    */
    public void checkHBLen() {
        assertEquals(18, HapBD.lenInSeconds);
      }
  
}