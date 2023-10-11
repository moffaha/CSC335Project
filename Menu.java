/**
 *  Harvey Moffat
 *
 *  22/09/23
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
    JMenu menu;
    JMenuItem menuItem;
    JTextField textField;
    JTextField inputField; // Added JTextField for user input
    JButton selectButton; // Button to select the starting node
    JTextField endNodeInputField; // Input field for the ending node
    JButton selectEndNodeButton; // Button to select the ending node

    Graph graph; // Reference to the graph
    File file; // Reference to file reader

    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "Quit":
                System.exit(0); // close the window when the Quit menu item is selected
                break;
            case "Load CSV":
                // Create a file dialog for loading a CSV file
                FileDialog fileDialog = new FileDialog(this, "Load CSV File", FileDialog.LOAD);
                fileDialog.setDirectory("H:\\CSC335\\Project\\dijkstras Project");
                fileDialog.setFile("*.csv"); // Set the file filter to only show CSV files
                fileDialog.setVisible(true);

                String selectedFile = fileDialog.getFile();
                String directory = fileDialog.getDirectory();

                if (selectedFile != null && directory != null) {
                    File csvFile = new File(directory, selectedFile);

                    if (csvFile.exists()) {
                        ReadCSV readCSV = new ReadCSV();
                        readCSV.readCSV(graph, file);
                    }
                } else {
                    System.err.println("No CSV file selected.");
                }

                break;
        }

        if (e.getSource() == selectButton) {
            String input = inputField.getText().trim();
            Node selectedNode = graph.getNode(input);
            if (selectedNode != null) {
                for (Component component : getContentPane().getComponents()) {
                    if (component instanceof JTextField) {
                        JTextField textField = (JTextField) component;
                        String textFieldText = textField.getText();
                        if (!textFieldText.equals("Enter starting node:")) {
                            int indexTo = textFieldText.indexOf(":");
                            if (indexTo != -1) {
                                String destinationNode = textFieldText.substring(textFieldText.indexOf(" to ") + 4, indexTo);
                                textField.setText("Distance from " + input + " to " + destinationNode + ": " +
                                        Dijkstra.shortestPath(graph, selectedNode).get(graph.getNode(destinationNode)));
                            }
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Node not found. Please enter a valid node ID.", "Invalid Node", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == selectEndNodeButton) {
            String input = endNodeInputField.getText().trim();
            Node selectedEndNode = graph.getNode(input);
            if (selectedEndNode != null) {
                Node selectedStartNode = graph.getNode(inputField.getText().trim());
                if (selectedStartNode != null) {
                    String distanceText = "Distance from " + selectedStartNode.getId() + " to " + selectedEndNode.getId() + ": " +
                            Dijkstra.shortestPath(graph, selectedStartNode).get(selectedEndNode);
                    JOptionPane.showMessageDialog(this, distanceText, "Distance", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Starting Node not found. Please enter a valid node ID.", "Invalid Node", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ending Node not found. Please enter a valid node ID.", "Invalid Node", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public Menu(int width, int height) {
        setTitle("Dijkstra's Menu");
        this.getContentPane().setPreferredSize(new Dimension(width, height));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        graph = new Graph();
        ReadCSV readCSV = new ReadCSV();
        readCSV.readCSV(graph, file);

        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        menu = new JMenu("File");
        menuBar.add(menu);
        menuItem = new JMenuItem("Load CSV");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menu = new JMenu("View");
        menuBar.add(menu);
        menuItem = new JMenuItem("Quit");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        int y = 50;
        for (Node node : graph.getNodes().values()) {
            textField = new JTextField("Distance from A to " + node.getId() + ": " +
                    Dijkstra.shortestPath(graph, graph.getNode("A")).get(node));
            textField.setBounds(50, y, 250, 30);
            textField.setEditable(false);
            add(textField);
            y += 35;
        }

        textField = new JTextField("Enter starting node:");
        textField.setBounds(50, y, 150, 30);
        textField.setEditable(false);
        add(textField);

        inputField = new JTextField();
        inputField.setBounds(200, y, 50, 30);
        inputField.addKeyListener(this);
        add(inputField);

        selectButton = new JButton("Select");
        selectButton.setBounds(260, y, 70, 30);
        selectButton.addActionListener(this);
        add(selectButton);

        textField = new JTextField("Enter end node:");
        textField.setBounds(50, y + 35, 150, 30);
        textField.setEditable(false);
        add(textField);

        endNodeInputField = new JTextField();
        endNodeInputField.setBounds(200, y + 35, 50, 30);
        endNodeInputField.addKeyListener(this);
        add(endNodeInputField);

        selectEndNodeButton = new JButton("Select");
        selectEndNodeButton.setBounds(260, y + 35, 70, 30);
        selectEndNodeButton.addActionListener(this);
        add(selectEndNodeButton);

        setLayout(null);
        this.pack();
        this.toFront();
        this.setVisible(true);
    }

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
        SwingUtilities.invokeLater(() -> {
            Menu menu = new Menu(400, 400);
        });
    }
}
