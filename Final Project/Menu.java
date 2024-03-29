/**
 *  Harvey Moffat
 *
 *  24/10/23
 *
 *  A class to add functionality to the display window
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;


public class Menu extends JFrame implements ActionListener, KeyListener {
    // class variables
    JMenuBar menuBar;
    JMenu menu, submenu;
    JMenuItem menuItem;
    JTextField textField;
    JTextField inputField; // Added JTextField for user input
    JButton selectButton; // Button to select the starting node

    Graph graph; // Reference to the graph
    File file;//Reference to file reader
    Color neutral = new Color (238,238,238);

    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "Quit":
                System.exit(0); // close the window when the Quit menu item is selected
                break;
            case "Dark Grey":
                // Change the background color to dark grey
                getContentPane().setBackground(Color.DARK_GRAY);
                break;
            case "Grey":
                getContentPane().setBackground(Color.GRAY);
                break;
            case "Light Grey":
                getContentPane().setBackground(Color.LIGHT_GRAY);
                break;
            case "White":
                getContentPane().setBackground(Color.WHITE);
                break;
            case "Neutral":
                getContentPane().setBackground(neutral);
                break;
            case "How-To":
                // Display a JOptionPane with tips and tricks
                String howToMessage = "Open the View menu to change the background colour.\n"
                        + "Enter the node you would like to start from to get distances to the other nodes.\n"
                        + "To change the file, go into the ReadCSV class and change the file name on line 13 \n";
                JOptionPane.showMessageDialog(null, howToMessage, "How-To", JOptionPane.INFORMATION_MESSAGE);
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
                        String textFieldText = textField.getText();
                        // Check if the text field contains the "Enter starting node:" text
                        if (!textFieldText.equals("Enter starting node:")) {
                            // Find the index of ":" to determine if it's a distance display text field
                            int indexTo = textFieldText.indexOf(":");
                            if (indexTo != -1) {
                                // Extract the destination node ID from the text field
                                String destinationNode = textFieldText.substring(textFieldText.indexOf(" to ") + 4, indexTo);
                                // Update the text field with the new distance value
                                textField.setText("Distance from " + input + " to " + destinationNode + ": " + Dijkstra.shortestPath(graph, selectedNode).get(graph.getNode(destinationNode)));
                            }
                        }
                    }
                }
            } else {
                // Display an error message if the selected node is not found
                JOptionPane.showMessageDialog(this, "Node not found. Please enter a valid node ID.", "Invalid Node", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public Menu(int width, int height) {
        // set the title
        setTitle("Dijkstra's Menu");
        this.getContentPane().setPreferredSize(new Dimension(width, height));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        graph = new Graph(); // Create a new graph

        // Read data from CSV file and construct the graph
        ReadCSV readCSV = new ReadCSV();
        readCSV.readCSV(graph, file);

        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        // adding dropdown menu one
        menu = new JMenu("File");
        menuBar.add(menu);

        // adding the dropdown menu option
        menuItem = new JMenuItem("Quit");
        menuItem.addActionListener(this);
        menu.add(menuItem);


        // adding dropdown menu two
        menu = new JMenu("View");
        menuBar.add(menu);

        submenu = new JMenu("Background Colour");
        menu.add(submenu);

        menuItem = new JMenuItem("Dark Grey");
        menuItem.addActionListener(this);
        submenu.add(menuItem);

        menuItem = new JMenuItem("Grey");
        menuItem.addActionListener(this);
        submenu.add(menuItem);

        menuItem = new JMenuItem("Light Grey");
        menuItem.addActionListener(this);
        submenu.add(menuItem);
        // Add a menu item to change the background color to white
        menuItem = new JMenuItem("White");
        menuItem.addActionListener(this);
        submenu.add(menuItem);

        menuItem = new JMenuItem("Neutral");
        menuItem.addActionListener(this);
        submenu.add(menuItem);

        menu = new JMenu("Help");
        menuBar.add(menu);

        menuItem = new JMenuItem("How-To");
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
        textField = new JTextField("Enter starting node:");
        textField.setBounds(50, y, 150, 30);
        textField.setEditable(false);
        add(textField);

        // Add the input field for the user to choose the starting node
        inputField = new JTextField();
        inputField.setBounds(200,y,50,30);
        inputField.addKeyListener(this);
        add(inputField);

        // Add the select button
        selectButton = new JButton("Select");
        selectButton.setBounds(260, y, 70, 30);
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

}