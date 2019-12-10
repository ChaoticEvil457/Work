package JavaGraph;

import java.util.ArrayList;
public class Vertex{
    private ArrayList<Edge> ray;
    private Object data;
    private int id;
    public Vertex(Object data,int id){
        this.data = data;
        this.id = id;
        ray = new ArrayList<Edge>();
    }
    public void addEdge(Vertex v){
        Edge e = new Edge(v,this,this.data);
        ray.add(e);
    }
    public int getId(){
        return id;
    }
    public ArrayList<Edge> getRay(){
        return ray;
    }
} 