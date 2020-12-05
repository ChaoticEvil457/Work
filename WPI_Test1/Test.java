public class Test {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<String>();
        list.add("X");
        list.add("B");
        list.add("M");
        list.add("A");
        list.add("B");
        list.add("X");
        list.add("D");
        list.condense();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
