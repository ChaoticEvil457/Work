import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Code to test an <tt>LRUCache</tt> implementation.
 */
public class CacheTester_interface {
	@Test
	public void leastRecentlyUsedIsCorrect () {
		DataProvider_interface<Integer,String> provider = null; // Need to instantiate an actual DataProvider
		Cache_interface<Integer,String> cache = new LRUCache_interface<Integer,String>(provider, 5);
	}
}
