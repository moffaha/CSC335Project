/**
 *  Author: Harvey Moffat
 *  30/07/23
 *  A class to read data from a CSV file and construct a graph based on the data.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public void readCSV(Graph graph) {
        String line = "";
        String splitBy = ",";
        try {
            // parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("test.csv"));
            while ((line = br.readLine()) != null) {   // returns a Boolean value
                String[] data = line.split(splitBy);    // use comma as separator
                String nodeID = data[0];
                String neighborID = data[1];
                int weight = Integer.parseInt(data[2]);

                Node node = graph.getNode(nodeID);
                if (node == null) {
                    node = graph.addNode(nodeID);
                }

                Node neighbor = graph.getNode(neighborID);
                if (neighbor == null) {
                    neighbor = graph.addNode(neighborID);
                }

                graph.addEdge(node, neighbor, weight);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
