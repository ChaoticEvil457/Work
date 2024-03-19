package HW4;

public class HeapChecker {

    /**
     * Checks if the given binary tree is equal to the given heap with an additional
     * element added
     * 
     * @param hOrig  Given heap
     * @param elt    Given additional element
     * @param hAdded Given binary tree
     * @return returns true if the heap with the given element added is a valid
     *         tree, and false otherwise
     */
    boolean addEltValidator(IHeap hOrig, int elt, IBinTree hAdded) {
        // if both left and right are null, then the current hOrig is an MtHeap meaning
        // there are no more elements to check
        if (hOrig.getLeft() == null && hOrig.getRight() == null) {
            return true;
        }
        // checks makes sure that each element in hAdded is either also in the heap, or
        // is the element being added
        // Additionally checks to make sure that all elements in the heap are bigger
        // than the given element being added to the top
        if (!hAdded.hasElt(hOrig.getData()) || hOrig.getData() < elt) {
            return false;
        }

        // checks the right and left side of the current iteration of hOrig
        return addEltValidator(hOrig.getRight(), elt, hAdded) && addEltValidator(hOrig.getLeft(), elt, hAdded);
    }

    /**
     * Helper method
     * 
     * @param hOrig  given heap
     * @param hAdded top element
     * @return returns true if remMinEltValidator2 is true
     */

    boolean remMinEltValidator(IHeap hOrig, IBinTree hAdded) {
        return remMinEltValidator2(hOrig, hOrig.getData(), hAdded);
    }

    /**
     * Checks if the given heap with the minumum element removes is a valid binary
     * tree
     * 
     * @param hOrig  Given heap
     * @param elt    top element
     * @param hAdded Given binary tree
     * @return returns true if the heap with the given element removed is a valid
     *         tree, and false otherwise
     */
    boolean remMinEltValidator2(IHeap hOrig, int elt, IBinTree hAdded) {
        // if both left and right are null, then the current hOrig is an MtHeap meaning
        // there are no more elements to check
        if (hOrig.getLeft() == null && hOrig.getRight() == null) {
            return true;
        }
        // checks to make sure each element besides elt is in the given binary tree
        if ((!hAdded.hasElt(hOrig.getData()) && hOrig.getData() != elt) || hAdded.hasElt(elt)) {
            return false;
        }

        // checks the right and left side of the current iteration of hOrig
        return remMinEltValidator2(hOrig.getRight(), elt, hAdded) && remMinEltValidator2(hOrig.getLeft(), elt, hAdded);
    }
}
