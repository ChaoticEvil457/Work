package HW4;
interface IBinTree {
  // determines whether element is in the tree
  boolean hasElt(int e);

  // returns number of nodes in the tree; counts duplicate elements as separate
  // items
  int size();

  // returns depth of longest branch in the tree
  int height();

  // returns the data held in the current node
  int getData();
}
