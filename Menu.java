/**
 *  Harvey Moffat
 *
 *  25/05/23
 *
 *  A class to add functionality to the display window
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;

public class Menu extends JFrame implements ActionListener {
    //class variables
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;

    public void actionPerformed(ActionEvent e) {

        System.out.println(e);
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "Quit" : System.exit(0);
        }
    }


    public Menu(int width, int height) {

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


        this.pack();
        this.toFront();
        this.setVisible(true);

    }

    public void paint(Graphics g){
        g.drawString("Hello Window",10,10);
    }



}