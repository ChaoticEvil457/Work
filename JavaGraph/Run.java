package JavaGraph;

public class Run {
    public static void main(String[] args){
        Vertex v = new Vertex("v",0);
        Vertex a = new Vertex("a",1);
        Vertex e = new Vertex("e",2);
        v.addEdge(a);
        v.addEdge(e);
        Graph g = new Graph(v);
        g.addVertex(v);
        g.addVertex(a);
        g.addVertex(e);
        System.out.print("  ");
        for (int i = 0; i <= v.getRay().size(); i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        g.printMatrix(g);
    }
}