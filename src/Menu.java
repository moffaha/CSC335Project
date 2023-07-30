/**
 *  Harvey Moffat
 *
 *  30/07/23 V2 same day
 *
 *  A class to add functionality to the display window
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Menu extends JFrame implements ActionListener {
    // class variables
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JTextField textField;

    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "Quit":
                System.exit(0); // close the window when the Quit menu item is selected
        }
    }

    public Menu(int width, int height) {

        // set the title
        setTitle("Menu Test");
        this.getContentPane().setPreferredSize(new Dimension(width, height));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Graph graph = new Graph(); // Create a new graph

        // Read data from CSV file and construct the graph
        ReadCSV readCSV = new ReadCSV();
        readCSV.readCSV(graph);

        // Use Dijkstra's algorithm to find the shortest paths from node A to all the other nodes
        Node nodeA = graph.getNode("A");
        Map<Node, Integer> distances = Dijkstra.shortestPath(graph, nodeA);

        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        // adding dropdown menu one
        menu = new JMenu("File");
        menuBar.add(menu);

        // adding the dropdown menu options
        menuItem = new JMenuItem("First Menu Item");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuItem = new JMenuItem("Second Menu Item");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        // adding dropdown menu two
        menu = new JMenu("View");
        menuBar.add(menu);

        // adding the dropdown menu option
        menuItem = new JMenuItem("Quit");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        // Sort the distances map based on the node IDs in alphabetical order
        java.util.List<Node> sortedNodes = new ArrayList<>(distances.keySet());
        Collections.sort(sortedNodes, Comparator.comparing(Node::getId));

        // Display the distances from node A to all other nodes dynamically in alphabetical order
        int y = 50;
        for (Node node : sortedNodes) {
            textField = new JTextField("Distance from A to " + node.getId() + ": " + distances.get(node));
            textField.setBounds(50, y, 250, 30);
            textField.setEditable(false);
            add(textField);
            y += 35;
        }
        setLayout(null);

        // pack code and push it to the front of the screen
        this.pack();
        this.toFront();
        this.setVisible(true);
    }
}
