public interface ISet {
    /**
     * Adds an element to the set
     * 
     * @param s Element being added to the set
     * @return Returns a set containing the new element
     */
    public ISet addElt(String s);

    /**
     * Checks if an element exists in the set
     * 
     * @param s Element which is being searched for
     * @return returns true if the element exists, and false otherwise
     */
    public boolean hasElt(String s);

    /**
     * @return returns the size of the set
     */
    public int size();
}
