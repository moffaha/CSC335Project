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

    public Node(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }
}