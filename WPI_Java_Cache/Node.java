public class Node {
    private Node prev;
    private Node next;
    private Object key;
    private Object val;

    public Node(Object key, Object val) {// constructor
        this.key = key;
        this.val = val;
    }

    //////////
    public Node getNextNode() {// get stored next node
        return next;
    }

    public void setNextNode(Node n) {
        next = n;
    }

    //////////
    public Node getPrevNode() {// get stored previous node
        return prev;
    }

    public void setPrevNode(Node n) {
        prev = n;
    }

    public Object getKey() {
        return key;
    }

    public Object getVal() {
        return val;
    }
}
