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

public class Menu extends JFrame implements ActionListener, KeyListener {
    // class variables
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JTextField textField;
    JTextField inputField; // Added JTextField for user input
    JButton selectButton; // Button to select the starting node

    Graph graph; // Reference to the graph

    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "Quit":
                System.exit(0); // close the window when the Quit menu item is selected
                break;
        }

        if (e.getSource() == selectButton) {
            String input = inputField.getText().trim();
            Node selectedNode = graph.getNode(input);
            if (selectedNode != null) {
                // Clear the text fields to update the distances based on the new starting node
                for (Component component : getContentPane().getComponents()) {
                    if (component instanceof JTextField) {
                        JTextField textField = (JTextField) component;
                        textField.setText("Distance from " + input + " to " + textField.getText().substring(textField.getText().indexOf(" to ") + 4) + ": " + Dijkstra.shortestPath(graph, selectedNode).get(graph.getNode(textField.getText().substring(textField.getText().indexOf(" to ") + 4))));
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Node not found. Please enter a valid node ID.", "Invalid Node", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public Menu(int width, int height) {
        // set the title
        setTitle("Menu Test");
        this.getContentPane().setPreferredSize(new Dimension(width, height));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        graph = new Graph(); // Create a new graph

        // Read data from CSV file and construct the graph
        ReadCSV readCSV = new ReadCSV();
        readCSV.readCSV(graph);

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

        // Display the distances from node A to all other nodes dynamically in alphabetical order
        int y = 50;
        for (Node node : graph.getNodes().values()) {
            textField = new JTextField("Distance from A to " + node.getId() + ": " + Dijkstra.shortestPath(graph, graph.getNode("A")).get(node));
            textField.setBounds(50, y, 250, 30);
            textField.setEditable(false);
            add(textField);
            y += 35;
        }

        // Add the input field for the user to choose the starting node
        inputField = new JTextField("Enter starting node:");
        inputField.setBounds(50, y, 150, 30);
        inputField.addKeyListener(this); // Add the KeyListener to the input field
        add(inputField);

        // Add the select button
        selectButton = new JButton("Select");
        selectButton.setBounds(210, y, 90, 30);
        selectButton.addActionListener(this); // Add the ActionListener to the button
        add(selectButton);

        setLayout(null);
        // pack code and push it to the front of the screen
        this.pack();
        this.toFront();
        this.setVisible(true);
    }

    // KeyListener methods
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        Menu window = new Menu(600, 600);
        window.setVisible(true);
    }
}
