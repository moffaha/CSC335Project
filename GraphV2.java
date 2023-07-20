import java.util.HashMap;
import java.util.Map;

public class Graph {
    private Map<String, Node> nodes = new HashMap<>();

    public Node addNode(String id) {
        Node node = new Node(id);
        nodes.put(id, node);
        return node;
    }

    public Node getNode(String id) {
        return nodes.get(id);
    }

    public Map<String, Node> getNodes() {
        return nodes;
    }

    public void addEdge(Node from, Node to, int weight) {
        Edge edge = new Edge(from, to, weight);
        from.addEdge(edge);
    }
}