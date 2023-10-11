/** Author: Harvey Moffat
 *
 *  20/07/23
 *
 *  A class to make nodes for the Dijkstra class
 */

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String id;
    private List<Edge> edges = new ArrayList<>();

    // Constructor to create a new Node with a given ID
    public Node(String id) {
        this.id = id;
    }

    // Getter method to return the ID of the Node
    public String getId() {
        return id;
    }

    // Method to add an edge to the list of edges of the Node
    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    // Getter method to return the list of edges associated with the Node
    public List<Edge> getEdges() {
        return edges;
    }
}
