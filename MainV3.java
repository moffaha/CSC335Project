/** Author: Harvey Moffat
 *
 *  20/07/23
 *
 *  Creates window and runs algorithm
 */
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Node nodeA = graph.addNode("A");
        Node nodeB = graph.addNode("B");
        Node nodeC = graph.addNode("C");

        graph.addEdge(nodeA, nodeB, 1);
        graph.addEdge(nodeB, nodeC, 3);
        graph.addEdge(nodeA, nodeC, 5);

        Map<Node, Integer> distances = Dijkstra.shortestPath(graph, nodeA);
        System.out.println("Distance from A to B: " + distances.get(nodeB));
        System.out.println("Distance from A to C: " + distances.get(nodeC));
    }
}
