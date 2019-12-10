package JavaGraph;

import java.util.ArrayList;

public class Graph {
    private Vertex v;
    private ArrayList<Vertex> ray;
    public Graph(Vertex v) {
        this.ray = new ArrayList<Vertex>();
        this.v = v;
    }
    public void printMatrix(Graph g) {
        for (int j = 0; j < v.getRay().size(); j++) {
            System.out.print(v.getRay().get(j).getNext().getId());
            for (int i = 0; i <= v.getRay().size(); i++) {
                try {
                    if (v.getRay().get(i).getNext().getId() != v.getId()) {
                        System.out.print(" 1");
                    }
                } catch (Exception e) {
                    System.out.print(" 0");
                }
            }
            System.out.println();
        }
        for(int i = 0; i<v.getRay().size();i++){
        Graph s = new Graph(v.getRay().get(i).getNext());
        printMatrix(s);
        }
    }
    public void addVertex(Vertex e){
        ray.add(e);
    }
}
