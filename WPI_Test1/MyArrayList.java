import java.util.HashMap; // Not required but potentially useful
//import static org.junit.Assert.*;
//import org.junit.Before;
//import org.junit.Test;
//import java.util.*;
// !!!!
// Do not import anything else!
// !!!!

public class MyArrayList<T> {
	private static final int INITIAL_CAPACITY = 512;

	@SuppressWarnings("unchecked")
	private T[] _data = (T[]) new Object[INITIAL_CAPACITY];
	private int _numElements = 0;

	// Do not change this method
	public int size() {
		return _numElements;
	}

	// Do not change this method
	public T get(int index) {
		return _data[index];
	}

	// Do not change this method
	private void growArray() {
		@SuppressWarnings("unchecked")
		final T[] newArray = (T[]) new Object[_data.length * 2];
		for (int i = 0; i < _data.length; i++) {
			newArray[i] = _data[i];
		}
		_data = newArray;
	}

	// Do not change this method
	public void add(T obj) {
		if (_numElements == _data.length) {
			growArray();
		}
		_data[_numElements] = obj;
		_numElements++;
	}

	/**
	 * This method checks for duplicate elements (using equals()) inside the array's
	 * underlying storage _data; if it finds any, it removes the duplicates so that
	 * only one instance of each object -- specifically, the first instance of each
	 * object in the list -- remains in the array. The order of all other elements
	 * must remain the same. No specific time-cost is required for this method.
	 */
	public void condense() {
		for (int i = 0; i < _numElements - 1; i++) {
			for (int j = i + 1; j < _numElements - 1; j++) {
				if (_data[i].equals(_data[j])) {
					for (int h = j; h < _numElements - 1; h++) {
						_data[h] = _data[h + 1];
					}
					i = 0;
					_numElements--;
				}
			}
		}
	}
}
