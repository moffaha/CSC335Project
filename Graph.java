import java.util.HashSet;
import java.util.Set;

/** Author: Harvey Moffat
 *
 *  25/05/23
 *
 *  A class to get and set
 */

public class Graph {

    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }
}

