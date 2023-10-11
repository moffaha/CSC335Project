/**
 *  Author: Harvey Moffat
 *  30/07/23
 *  A class to manage a graph with nodes and edges.
 */

import java.util.Map;
import java.util.HashMap;

public class Graph {
    private Map<String, Node> nodes = new HashMap<>();

    // Method to add a new node to the graph with the given ID
    public Node addNode(String id) {
        Node node = new Node(id);
        nodes.put(id, node);
        return node;
    }

    // Method to retrieve a node from the graph based on its ID
    public Node getNode(String id) {
        return nodes.get(id);
    }

    // Method to get the entire map of nodes in the graph
    public Map<String, Node> getNodes() {
        return nodes;
    }

    // Method to add an edge between two nodes in the graph with a given weight
    public void addEdge(Node from, Node to, int weight) {
        Edge edge = new Edge(from, to, weight);
        from.addEdge(edge);
    }
}
