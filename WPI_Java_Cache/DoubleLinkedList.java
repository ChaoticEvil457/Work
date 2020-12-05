public class DoubleLinkedList {

    Node node;
    int size;

    //////////
    public DoubleLinkedList() {// constructor
        this.size = 0;
    }

    public Object get(Object o) {
        if(node==null){
            return null;
        }
        Node first=node;
        while (node != null) {
            if (node.getKey() == o) {
                return node.getVal();
            } else {
                node = node.getNextNode();
            }
        }
        node=first;
        return null;

    }

    public void remove(Node n) {// remove the first instance of the given node
        if (node == n) {
            node = n;
        }
        if (n.getNextNode() != null) {
            n.getNextNode().setPrevNode(n.getPrevNode());
        }
        if (n.getPrevNode() != null) {
            n.getPrevNode().setNextNode(n.getNextNode());
        }
    }

    public void add(Object o, Object o2) {// adds new data to the end of the list
        Node first = node;
        if (node == null) {
            node = new Node(o, o2);
        } else {
            while (node.getNextNode() != null) {
                node = node.getNextNode();
            }
            Node last = new Node(o, o2);
            node.setNextNode(last);
            last.setPrevNode(node);
            node = first;
            size += 1;
        }
    }

    public int size() {// returns the size of the list
        return size;
    }

    public void print() {
        Node first = node;
        while (node != null) {
            System.out.print(node.getKey() + " : ");
            System.out.println(node.getVal());
            node = node.getNextNode();
        }
        node = first;
    }
    public void setFront(Node n){
        
    }
}