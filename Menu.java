/**
 *  Harvey Moffat
 *
 *  15/05/23
 *
 *  description
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

        menu = new JMenu("File");
        menuBar.add(menu);


        menuItem = new JMenuItem("First Menu Item");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuItem = new JMenuItem("Second Menu Item");
        menuItem.addActionListener(this);
        menu.add(menuItem);


        menu = new JMenu("View");
        menuBar.add(menu);

        menuItem = new JMenuItem("Quit");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        this.pack();
        this.toFront();
        this.setVisible(true);
    }


}