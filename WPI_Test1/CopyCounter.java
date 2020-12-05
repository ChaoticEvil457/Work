/* Uncomment if you want to run the unit test:
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
*/
// !!!!
// You may not import anything other than the junit classes!
// !!!!
public class CopyCounter<T> {
	private static final int INITIAL_CAPACITY = 512;
	private int numElements = 0;

	@SuppressWarnings("unchecked")
	private Node<T>[] _array = (Node<T>[]) new Node[INITIAL_CAPACITY];

	private static class Node<T> {
		Node next;
		T val;
		int copies;

		public Node(T val) {
			this.val = val;
			copies = 1;
		}

		
	}

	public CopyCounter() {
		// Implement me (optional)
	}
	public Node get(T obj) {
		if (_array[obj.hashCode() % INITIAL_CAPACITY].val.equals(obj)) {
			return _array[obj.hashCode() % INITIAL_CAPACITY];
		} else if (_array[obj.hashCode() % INITIAL_CAPACITY].next.equals(null)) {
			return null;
		} else {
			return _array[obj.hashCode() % INITIAL_CAPACITY].next;
		}
	}
	/**
	 * When add is called on an object that is not currently stored in the
	 * copy-counter, the object is added and its associated count is set to 1. Each
	 * additional time add is called on that same object (compared using equals),
	 * its count is increased by 1.
	 * 
	 * @param obj the object to add
	 */
	public void add(T obj) {
		if (get(obj).equals(null)) {
			_array[obj.hashCode() % INITIAL_CAPACITY] = new Node<T>(obj);
		} else {
			get(obj).copies++;
		}
	}

	/**
	 * This method reports the number of copies of the specified object that are
	 * currently stored in the collection.
	 * 
	 * @return the number of copies of obj in the collection
	 */
	public int getNumCopies(T obj) {
		if (get(obj).equals(null)) {
			return 0;
		} else {
			return get(obj).copies; // Implement me
		}
	}

	/**
	 * Each time remove is called on that object, its count is decreased by 1. The
	 * remove method also returns the number of remaining copies of the specified
	 * object in the collection. (If the object was not contained in the collection
	 * at all, it should return 0.) When an object's count reaches 0, the object
	 * should be removed from the copy-counter entirely.
	 * 
	 * @param obj the object to add
	 * @return the number of remaining copies of obj in the collection
	 */
	public int remove(T obj) {
		if (!get(obj).equals(null)) {
			if (get(obj).copies != 0) {
				get(obj).copies--;
			}
		}
		return getNumCopies(obj);
	}

	/**
	 * This method returns an object that has the highest associated count among all
	 * objects in the collection. If the collection is empty, this method returns
	 * null.
	 * 
	 * @return an object with the highest associated count or null if collection is
	 *         empty.
	 */
	public T mostFrequentObject() {
		int highestNumCopies = 0;
		T storedVar = null;
		for (int i = 0; i < _array.length; i++) {
			if (!_array[i].equals(null)) {
				if (_array[i].copies > highestNumCopies) {
					highestNumCopies = _array[i].copies;
					storedVar = _array[i].val;
				}
			}
		}
		return storedVar;
	}

	// Uncomment if you want to run the unit test:

	//@Test
	/*
	public void test1() {
		final CopyCounter<Integer> counter = new CopyCounter<Integer>();
		counter.add(1);
		counter.add(2);
		counter.add(1);
		assertEquals((Integer) 1, counter.mostFrequentObject());
		assertEquals(2, counter.getNumCopies(1));
		assertEquals(1, counter.getNumCopies(2));
		counter.remove(1);
		assertEquals(1, counter.getNumCopies(1));
		counter.remove(1);
		assertEquals(0, counter.getNumCopies(1));
	}*/

}
