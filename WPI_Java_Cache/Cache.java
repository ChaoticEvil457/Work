import java.util.HashMap;

import javax.net.ssl.HandshakeCompletedEvent;

public class Cache {
    private DoubleLinkedList list;
    private DataProvider d;
    private int numMisses;

    public Cache() {
        numMisses = 0;
        list = new DoubleLinkedList();
        d = new DataProvider();
    }

    public Object get(Object key) {
        if (list.get(key) == null) {// if the list doesn't contain the node, then store it and check the provider
            list.add(key,d.getVal(key));
            System.out.println(d.getVal(key)+" Miss");
            numMisses+=1;
            return d.getVal(key);
        } else {
            System.out.println(list.get(key));
            return list.get(key);
        }
    }

    public int getNumMisses() {
        return numMisses;
    }
}
