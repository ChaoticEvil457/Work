public class test {
    public static void main(String[] args) {
        /*
        DoubleLinkedList list = new DoubleLinkedList();
        list.add("hello","hello1");
        list.add("hi","hi1");
        list.print();
        */
        Cache c = new Cache();
        c.get("smurf");
        c.get("smurf");
        c.get("smurf");
        c.get("garfield");
        c.get("smurf");
        c.get("garfield");
        c.getNumMisses();
        
    }
}
