/**
 *  Harvey Moffat
 *
 *  08/06/23
 *
 *  A class to add functionality to the display window
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Map;
import java.util.Scanner;

public class Menu extends JFrame implements ActionListener {
    //class variables
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JTextField textField;

    public void actionPerformed(ActionEvent e) {

        System.out.println(e);
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "Quit" : System.exit(0);//close the window when the Quit menu item is selected
        }
    }



    public Menu(int width, int height) {

        Graph graph = new Graph();// Create a new graph
        ReadCSV csvReader = new ReadCSV();
        csvReader.ReadCSV();


        // Create three nodes (A, B, and C) and add them to the graph
        Node nodeA = graph.addNode("A");
        Node nodeB = graph.addNode("B");
        Node nodeC = graph.addNode("C");
        Node nodeD = graph.addNode("D");

        // Add edges with weights between the nodes to form a connected graph
        graph.addEdge(nodeA, nodeB, 1);
        graph.addEdge(nodeB, nodeC, 3);
        graph.addEdge(nodeA, nodeC, 5);


        // Use Dijkstra's algorithm to find the shortest paths from node A to all the other nodes
        Map<Node, Integer> distances = Dijkstra.shortestPath(graph, nodeA);

        //set the title
        setTitle("Menu Test");
        this.getContentPane().setPreferredSize(new Dimension(width,height));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        menuBar=new JMenuBar();
        this.setJMenuBar(menuBar);
        //adding dropdown menu one
        menu = new JMenu("File");
        menuBar.add(menu);

        //adding the dropdown menu options
        menuItem = new JMenuItem("First Menu Item");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuItem = new JMenuItem("Second Menu Item");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        //adding dropdown menu two
        menu = new JMenu("View");
        menuBar.add(menu);

        //adding the dropdown menu option
        menuItem = new JMenuItem("Quit");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        textField = new JTextField("Distance from A to B: " + distances.get(nodeB));// Print the shortest distances from node A to nodes B and C
        textField.setBounds(50,50,200,30);
        textField.setEditable(false);
        add(textField);
        textField = new JTextField("Distance from A to C: " + distances.get(nodeC));
        textField.setBounds(50,85,200,30);
        textField.setEditable(false);
        add(textField);
        setLayout(null);



        //pack code and push it to the front of the screen
        this.pack();
        this.toFront();
        this.setVisible(true);

    }

}