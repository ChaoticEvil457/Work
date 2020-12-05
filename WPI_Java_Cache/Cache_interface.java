/**
 * CS 2103 2019 B-term (Whitehill)
 * A cache that associates keys with values.
 */
interface Cache_interface<T, U> extends DataProvider_interface<T, U> {
	/**
	 * Returns the number of cache misses since the object's instantiation.
	 * @return the number of cache misses since the object's instantiation.
	 */
	int getNumMisses ();
}
