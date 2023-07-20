/** Author: Harvey Moffat
 *
 *  20/07/23
 *
 *  A class to implement Dijkstra's algorithm
 */


import java.util.*;

public class Dijkstra {
    // Method to find the shortest paths from a given source node to all other nodes in the graph
    public static Map<Node, Integer> shortestPath(Graph graph, Node source) {
        Map<Node, Integer> distances = new HashMap<>(); // Map to store the shortest distances from the source to each node
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get)); // Priority queue to track the nodes with the smallest distances

        // Initialization: Set all nodes' distances to infinity (Integer.MAX_VALUE), except the source node with distance 0
        for (Node node : graph.getNodes().values()) {
            if (node == source) {
                distances.put(node, 0);
            } else {
                distances.put(node, Integer.MAX_VALUE);
            }
            queue.add(node);
        }

        // Dijkstra's algorithm main loop
        while (!queue.isEmpty()) {
            Node node = queue.poll(); // Extract the node with the smallest distance from the queue

            // For each adjacent node (node connected by an edge) to the current node
            for (Edge edge : node.getEdges()) {
                Node adjNode = edge.getTo(); // Get the adjacent node
                int distance = distances.get(node) + edge.getWeight(); // Calculate the distance to the adjacent node through the current node

                // If the calculated distance is smaller than the current recorded distance to the adjacent node
                if (distance < distances.get(adjNode)) {
                    queue.remove(adjNode); // Remove the adjacent node from the queue to update its distance
                    distances.put(adjNode, distance); // Update the distance to the adjacent node
                    queue.add(adjNode); // Add the updated adjacent node back to the queue for further exploration
                }
            }
        }

        return distances; // Return the map of shortest distances from the source node to all other nodes
    }
}