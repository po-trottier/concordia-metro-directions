import models.Subway;
import helpers.SubwayLoader;
import helpers.SubwayPrinter;

import java.io.*;
import java.util.*;

/**
 * The type Subway tester runs the logic to get the directions and route pricing between two stations.
 */
public class SubwayTester
{
    /**
     * The entry point of application.
     *
     * To run this application, the user should include both the start station and the end station in the given order.
     * Example: <code>java SubwayTester "Snowdon" "Guy Concordia"</code>
     *
     * @param args the input arguments should include both the start station and the end station in the given order.
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: SubwayTester \"startStation\" \"endStation\" ");
            System.exit(-1);
        }
        try {
            SubwayLoader loader = new SubwayLoader();
            String subwayFilePath = "MontrealSubway.txt";
			Subway city = loader.loadFromFile(new File(subwayFilePath));
			
			String start = args[0];
			String end =  args[1];
            
            if (!city.hasStation(start)) {
                System.err.println(start + " is not a station in Montreal");
                System.exit(-1);
            } else if (!city.hasStation(end)) {
                System.err.println(end + " is not a station in Montreal");
                System.exit(-1);
            }
            
            List route = city.getDirections(start, end);
            File file = new File("./submission/output.txt");

            SubwayPrinter printer = new SubwayPrinter(System.out, file);
            printer.printDirections(route);
        }
        catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
