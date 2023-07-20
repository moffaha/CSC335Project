/** Author: Harvey Moffat
 *
 *  20/07/23
 *
 *  A class to implement Dijkstra's algorithm
 */


import java.util.*;

public class Dijkstra {
    public static Map<Node, Integer> shortestPath(Graph graph, Node source) {
        Map<Node, Integer> distances = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for(Node node : graph.getNodes().values()) {
            if (node == source) {
                distances.put(node, 0);
            } else {
                distances.put(node, Integer.MAX_VALUE);
            }
            queue.add(node);
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (Edge edge : node.getEdges()) {
                Node adjNode = edge.getTo();
                int distance = distances.get(node) + edge.getWeight();

                if (distance < distances.get(adjNode)) {
                    queue.remove(adjNode);
                    distances.put(adjNode, distance);
                    queue.add(adjNode);
                }
            }
        }

        return distances;
    }
}