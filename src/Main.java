/** Author: Harvey Moffat
 *
 *  20/07/23
 *
 *  Creates window and runs algorithm
 */
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph();// Create a new graph

        // Create three nodes (A, B, and C) and add them to the graph
        Node nodeA = graph.addNode("A");
        Node nodeB = graph.addNode("B");
        Node nodeC = graph.addNode("C");

        // Add edges with weights between the nodes to form a connected graph
        graph.addEdge(nodeA, nodeB, 1);
        graph.addEdge(nodeB, nodeC, 3);
        graph.addEdge(nodeA, nodeC, 5);

        // Use Dijkstra's algorithm to find the shortest paths from node A to all the other nodes
        Map<Node, Integer> distances = Dijkstra.shortestPath(graph, nodeA);
        System.out.println("Distance from A to B: " + distances.get(nodeB));// Print the shortest distances from node A to nodes B and C
        System.out.println("Distance from A to C: " + distances.get(nodeC));
    }
}
