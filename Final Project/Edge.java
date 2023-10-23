/**
 *  Author: Harvey Moffat
 *  24/10/23
 *  A class to represent an edge between two nodes in a graph with a given weight.
 */

public class Edge {
    private Node from; // The starting node of the edge.
    private Node to; // The ending node of the edge.
    private int weight; // The weight or cost associated with the edge.

    // Constructor to create an edge between two nodes with a given weight.
    public Edge(Node from, Node to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    // Getter method to retrieve the starting node of the edge.
    public Node getFrom() {
        return from;
    }

    // Getter method to retrieve the ending node of the edge.
    public Node getTo() {
        return to;
    }

    // Getter method to retrieve the weight of the edge.
    public int getWeight() {
        return weight;
    }
}