package HW4;
import static org.junit.Assert.*;

import org.junit.Test;

public class Examples {

    public Examples() {
    }

    HeapChecker HT = new HeapChecker();

    // placeholder empty heaps and binary trees for quick typing
    MtHeap mth = new MtHeap();

    // default test, one entry
    DataHeap myHeap = new DataHeap(5);

    // multiple left nodes
    DataHeap myHeap2 = new DataHeap(2,
            new DataHeap(3,
                    new DataHeap(5),
                    mth),
            mth);

    // multiple right nodes
    DataHeap myHeap3 = new DataHeap(2, mth,
            new DataHeap(3,
                    mth,
                    new DataHeap(5)));

    // nodes on both sides and deeper tree
    DataHeap myHeap4 = new DataHeap(2,
            new DataHeap(5, new DataHeap(10), new DataHeap(20)),
            new DataHeap(3, new DataHeap(39), new DataHeap(50)));

    // test cases for addEltValidator:

    // default check if the function works (adds 0 to two one element lists)
    @Test
    public void checkEltValidator1() {
        assertTrue(HT.addEltValidator(myHeap, 0, myHeap.addElt(0)));
    }

    // function works with multiple left values
    @Test
    public void checkEltValidator2() {
        assertTrue(HT.addEltValidator(myHeap2, 0, myHeap2.addElt(0)));
    }

    // function works with multiple right values
    @Test
    public void checkEltValidator3() {
        assertTrue(HT.addEltValidator(myHeap3, 0, myHeap3.addElt(0)));
    }

    // function works with nodes on both sides
    @Test
    public void checkEltValidator4() {
        assertTrue(HT.addEltValidator(myHeap4, 0, myHeap4.addElt(0)));
    }

    // added number is bigger than number below
    @Test
    public void checkEltValidator5() {
        assertFalse(HT.addEltValidator(myHeap, 6, myHeap.addElt(6)));
    }

    // added number is bigger than a grandchild
    @Test
    public void checkEltValidator6() {
        assertFalse(HT.addEltValidator(myHeap4, 4, myHeap4.addElt(4)));
    }

    // test cases for remMinEltValidator

    // default check if the function works (remove the minElement from a one element
    // heap)
    @Test
    public void checkRemEltValidator1() {
        assertTrue(HT.remMinEltValidator(myHeap, myHeap.remMinElt()));
    }

    // function works with multiple left values
    @Test
    public void checkRemEltValidator2() {
        assertTrue(HT.remMinEltValidator(myHeap2, myHeap2.remMinElt()));
    }

    // function works with multiple right values
    @Test
    public void checkRemEltValidator3() {
        assertTrue(HT.remMinEltValidator(myHeap3, myHeap3.remMinElt()));
    }

    // function works with nodes on both sides
    @Test
    public void checkRemEltValidator4() {
        assertTrue(HT.remMinEltValidator(myHeap4, myHeap4.remMinElt()));
    }

    // Works on empty heaps, returns an empty heap
    @Test
    public void checkRemEltValidator5() {
        assertTrue(HT.remMinEltValidator(new MtHeap(), new MtHeap()));
    }
}