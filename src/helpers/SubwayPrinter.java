package helpers;

import models.Connection;

import java.io.*;
import java.util.*;

/**
 * The Subway printer helper is used to print out the directions.
 */
public class SubwayPrinter
{
    private final PrintStream out;
    private final File file;

    /**
     * Instantiates a new Subway printer.
     *
     * @param out  the output stream to write results to
     * @param file the file to write logs to
     */
    public SubwayPrinter(OutputStream out, File file) {
        this.out = new PrintStream(out);
        this.file = file;
    }

    /**
     * Print directions.
     *
     * @param route the route to be printed
     */
    public void printDirections(List route) {
        OutputPrinter writer = null;
        try {
            writer = new OutputPrinter(out, file);
            writer.clear();

            Connection connection = (Connection) route.get(0);
            String currentLine = connection.getLineName();
            String previousLine = currentLine;

            writer.writeln("Start out at " + connection.getStation1().getName() + ".");
            writer.writeln("Get on the " + currentLine + " heading towards " + connection.getStation2().getName() + ".");

            for (int i = 1; i < route.size(); i++) {
                connection = (Connection) route.get(i);
                currentLine = connection.getLineName();
                if (currentLine.equals(previousLine)) {
                    writer.writeln("  Continue past  " + connection.getStation1().getName() + "...");
                }
                else {
                    writer.writeln("When you get to " + connection.getStation1().getName() + ", get off the " + previousLine + ".");
                    writer.writeln("Switch over to the " + currentLine + ", heading towards " + connection.getStation2().getName() + ".");
                    previousLine = currentLine;
                }
            }
            writer.writeln("Get off at " + connection.getStation2().getName() + " and enjoy yourself!");
            writer.writeln("Total cost will be " + route.size() + "$");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
