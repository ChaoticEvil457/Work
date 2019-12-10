package JavaGraph;

public class Edge {
    private Vertex next;
    private Vertex current;
    private Object data;
    public Edge(Vertex next, Vertex current,Object data){
        this.next=next;
        this.current=current;
        this.data=data;
    }
    public Edge(Vertex next, Vertex current){
        this.next=next;
        this.current=current;
    }
    public Object getData() {
        return data;
    }
    public Vertex getNext() {
        return next;
    }
    public boolean hasNext(){
        if(next==null){
            return false;
        }
        return true;
    }
    public Vertex getCurrent() {
        return current;
    }
    public void setData(Object data) {
        this.data = data;
    }
}
