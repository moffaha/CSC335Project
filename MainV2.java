/** Author: Harvey Moffat
 *
 *  08/06/23
 *
 *  Creates window and runs algorithm
 */
import dijkstra.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.util.Scanner;

public class Main extends JFrame {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        Menu window = new Menu(600, 600);
        Scanner in = new Scanner(System.in);
        ReadCSV readCSV = new ReadCSV();
        // Graph graph = new Graph();
        //  graph.addNode();

        /**
         * System.out.println("Dijkstra's");
        int decision = in.nextInt();
        switch (decision) {

            case 1:
                System.out.println("");
               // Dijkstra.calculateShortestPathFromSource(graph, );

                break;
            default:
                System.out.println("Unknown option");

                break;
        }
        in.close();
         **/
    }
}


