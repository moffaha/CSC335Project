/**
 *  Harvey Moffat
 *
 *  06/06/23
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
            case "Quit" : System.exit(0);//close the window when the Quit menu item is selected
        }
    }

    public void paint(Graphics g){
        JPanel panel = new JPanel();
        Graphics2D g2 =  (Graphics2D)g;

        Font font = new Font("Serif",Font.PLAIN,96);
        g2.setFont(font);
        g2.drawString("Hello Window",10,10);
    }

    public Menu(int width, int height) {

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

        //pack code and send it to the front of the screen
        this.pack();
        this.toFront();
        this.setVisible(true);

    }

}