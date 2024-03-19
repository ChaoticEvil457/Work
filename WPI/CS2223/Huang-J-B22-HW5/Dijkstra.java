import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dijkstra {
    public static int SIZE;

    public static void main(String args[]) throws FileNotFoundException {
        File f = new File("DijkstraInput.txt");// input file
        Scanner scan = new Scanner(f);// reads from file
        Scanner keyboard = new Scanner(System.in);// user input
        SIZE = scan.nextInt();// gets the size of the nxn matrix
        int[][] graph = new int[SIZE][SIZE];// creates a matrix
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                graph[i][j] = scan.nextInt();// Stores the data from the input file
            }
        }
        String[] vertexList = { "A", "J", "M", "R", "K", "S", "I", "N", "T", "D" };// hard coded, names of vertices
        System.out.println("Which two vertices would you like to find a path between?\nValid vertices are:");// prompts
                                                                                                             // input
        for (int i = 0; i < SIZE; i++) {// prints out valid vertices
            System.out.print(vertexList[i] + " ");
        }
        System.out.println();
        shortestPath(graph, keyboard.next().toUpperCase(), keyboard.next().toUpperCase(), vertexList);
        scan.close();// closes scanners
        keyboard.close();
    }

    /**
     * Helper method which parses user input into a printable solution
     * 
     * @param graph      Data taken from given file
     * @param from       Start vertex
     * @param to         End vertex
     * @param vertexList List of all vertex names
     */
    public static void shortestPath(int[][] graph, String from, String to, String[] vertexList) {
        int startPos = 0;
        int endPos = 0;
        for (int i = 0; i < vertexList.length; i++) {// gets the position of the start and end vertices
            if (vertexList[i].equals(from)) {
                startPos = i;
            } else if (vertexList[i].equals(to)) {
                endPos = i;
            }
        }
        System.out.println(// prints output
                "The distance from " + from + " to " + to + " using the shortest path is\n"
                        + dijkstra(graph, startPos, endPos, vertexList));
    }

    /**
     * Gets the shortest path between two vertices and attatches it to an existing
     * shortest path, or forms a new one, depending on which is shorter
     * 
     * @param graph      Data taken from input file
     * @param startPos   Start vertex position
     * @param endPos     End vertex position
     * @param vertexList List of vertex names
     * @return Returns a formatted string containing the path taken and distance for
     *         the shortest path
     */
    public static String dijkstra(int[][] graph, int startPos, int endPos, String[] vertexList) {
        String[] sequences = new String[SIZE];// holds the path taken for each shortest path
        boolean[] set = new boolean[SIZE];// remembers if the current node has already been added to a path
        int[] dist = new int[SIZE];// stores the shortest distance to each node
        for (int i = 0; i < SIZE; i++) {// fills the lists above with initial values
            dist[i] = Integer.MAX_VALUE;
            set[i] = false;
            sequences[i] = "";
        }
        dist[startPos] = 0;// distance from starting position to itself is 0
        for (int i = 0; i < SIZE - 1; i++) {// SIZE-1 because we already have the starting distance
            int minPos = minDistance(dist, set);// gets the position of the distance from the starting position to the
                                                // nearest vertex
            set[minPos] = true;// marks the vertex as used
            for (int j = 0; j < SIZE; j++) {// looks at edges between vertices
                if (!set[j] && graph[minPos][j] != 0 && dist[minPos] != Integer.MAX_VALUE
                        && dist[minPos] + graph[minPos][j] < dist[j]) {// Checks that the vertex hasn't been used, it
                                                                       // isn't invalid (0 meaning no connection), it
                                                                       // isn't MAX_VALUE (initial position, means that
                                                                       // it has been processed at least once), and the
                                                                       // current distance is less than the min distance
                                                                       // + the current edge distance
                    dist[j] = dist[minPos] + graph[minPos][j];// sets the distance to the new min distance
                    sequences[j] = sequences[minPos] + vertexList[minPos] + " - ";// stores the sequence to get there
                }
            }
        }
        // returns a formatted string containing the path and distance
        return "" + sequences[endPos] + vertexList[endPos] + "\nWith a total distance of " + dist[endPos];
    }

    /**
     * Returns the position of the minimum distance between an unused vertex and the
     * current vertex
     * 
     * @param dist List of distances
     * @param set  Checks if the vertex has been used
     * @return Returns the position of the minimum vertex
     */
    public static int minDistance(int dist[], boolean set[]) {
        int min = Integer.MAX_VALUE;
        int minPos = -1;
        for (int i = 0; i < SIZE; i++) {
            if (!set[i] && dist[i] <= min) {// makes sure the value hasn't been used and that the distance is less than
                                            // the min
                min = dist[i];// stores the minimum value
                minPos = i;// stores the minimum position
            }
        }
        return minPos;
    }
}