/**
 *  Harvey Moffat
 *
 *  24/07/23
 *
 *  A class to read and print a CSV file
 */


import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public  class ReadCSV {
    public void ReadCSV() {
        String line = "";
        String comma = ","; // use comma as separator

        
        try
        {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("testAlgorithm.CSV"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] node = line.split(comma);
                String[] edge = line.split(comma);
                String[] neighbour = line.split(comma);
                System.out.println(node[0] + " " + edge[1] + " " + neighbour[2]);
            }
        }
        catch (IOException e) //catch errors, E.g. wrong file input
        {
            e.printStackTrace();
        }

    }



}
