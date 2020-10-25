import helpers.OutputPrinter;
import models.Subway;
import helpers.SubwayLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The type Load tester tests that the Subway Station file is loaded correctly and contains the right content.
 */
public class LoadTester
{
    /**
     * The entry point of the tests.
     *
     * Running this application will run a suite of Unit Tests to make sure the Subway Stations file is valid.
     *
     * @param args the input arguments (should be empty)
     */
    public static void main(String[] args) {
        OutputPrinter writer = null;
        try {
            File file = new File("./submission/tests.output.txt");
            writer = new OutputPrinter(System.out, file);
            writer.clear();

            testSubwayMethods(writer);
            testLoadingFile(writer);
        } catch (IOException e) {
            e.printStackTrace(System.out);
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

    private static void testSubwayMethods(OutputPrinter writer) {
        try {
            writer.writeln("Testing Subway Methods");

            Subway city = new Subway();
            if (!city.hasStation("Test")) {
                writer.writeln("... empty subway test passed successfully.");
            } else {
                writer.writeln("... empty subway test FAILED.");
                System.exit(-1);
            }

            city.addStation("Test");
            if (city.hasStation("Test")) {
                writer.writeln("... adding station test passed successfully.");
            } else {
                writer.writeln("... adding station test FAILED.");
                System.exit(-1);
            }

            if (!city.hasConnection("Test", "Test2", "Line")) {
                writer.writeln("... empty subway connections test passed successfully.");
            } else {
                writer.writeln("... empty subway connections test FAILED.");
                System.exit(-1);
            }

            city.addStation("Test2");
            city.addConnection("Test", "Test2", "Line");
            if (city.hasConnection("Test", "Test2", "Line")) {
                writer.writeln("... adding connection test passed successfully.");
            } else {
                writer.writeln("... adding connection test FAILED.");
                System.exit(-1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private static void testLoadingFile(OutputPrinter writer) {
        try {
            SubwayLoader loader = new SubwayLoader();
            String subwayFilePath = "MontrealSubway.txt";
			Subway city = loader.loadFromFile(new File(subwayFilePath));

            writer.writeln("\nTesting stations");
            if (    city.hasStation("Guy Concordia") &&
                    city.hasStation("Snowdon") &&
                    city.hasStation("Berri UQAM")) {
                writer.writeln("... station test passed successfully.");
            }
            else
            {
                writer.writeln("... station test FAILED.");
                System.exit(-1);
            }

            writer.writeln("\nTesting connections...");
            if (city.hasConnection("Atwater", "Guy Concordia", "Green Line") &&
                city.hasConnection("Cote Vertu", "Du College", "Orange Line") &&
                city.hasConnection("Snowdon", "Cote des Neiges", "Blue Line")) {
                writer.writeln("... connections test passed successfully.");
            }
            else
            {
                writer.writeln("... connections test FAILED.");
                System.exit(-1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
