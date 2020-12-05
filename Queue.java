public class Queue<T> {
    private int front;
    private int count;
    private T[] array;
    private int size;
    public Queue(){
        front=0;
        size=0;
        array=new int[10];
        count=0;
    }
    public boolean enqueue (T o){
        if(size==capacity){
            return false;
        }
        array[count]=o;
        size++;
        count++;
        return true;

    }
    public int size (){
        return size;
    }
    public T dequeue (){
        T placeholder=array[count];
        array[front]=0;
        for(int i=0;i<array.length;i++){
            array[i] = array[i+1];
        }
        size--;
        return placeholder;
    }
}