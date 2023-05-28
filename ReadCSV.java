/**
 *  Harvey Moffat
 *
 *  29/05/23
 *
 *  A class to read and print a CSV file
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV
{
    public static void main(String[] args)
    {
        String line = "";
        String splitBy = ",";
        try
        {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("CSVDemo.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] node = line.split(splitBy);    // use comma as separator
                System.out.println(node[0] + " " + node[1] + " " + node[2] );
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}  