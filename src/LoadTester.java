import models.Subway;
import helpers.SubwayLoader;

import java.io.File;

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
        testSubwayMethods();
        testLoadingFile();
    }

    private static void testSubwayMethods() {
        try {
            System.out.println("\nTesting Subway Methods");

            Subway city = new Subway();
            if (!city.hasStation("Test")) {
                System.out.println("... empty subway test passed successfully.");
            } else {
                System.out.println("... empty subway test FAILED.");
                System.exit(-1);
            }

            city.addStation("Test");
            if (city.hasStation("Test")) {
                System.out.println("... adding station test passed successfully.");
            } else {
                System.out.println("... adding station test FAILED.");
                System.exit(-1);
            }

            if (!city.hasConnection("Test", "Test2", "Line")) {
                System.out.println("... empty subway connections test passed successfully.");
            } else {
                System.out.println("... empty subway connections test FAILED.");
                System.exit(-1);
            }

            city.addStation("Test2");
            city.addConnection("Test", "Test2", "Line");
            if (city.hasConnection("Test", "Test2", "Line")) {
                System.out.println("... adding connection test passed successfully.");
            } else {
                System.out.println("... adding connection test FAILED.");
                System.exit(-1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private static void testLoadingFile() {
        try {
            SubwayLoader loader = new SubwayLoader();
            String subwayFilePath = "MontrealSubway.txt";
			Subway city = loader.loadFromFile(new File(subwayFilePath));

            System.out.println("\nTesting stations");
            if (    city.hasStation("Guy Concordia") &&
                    city.hasStation("Snowdon") &&
                    city.hasStation("Berri UQAM")) {
                System.out.println("... station test passed successfully.");
            }
            else
            {
                System.out.println("...station test FAILED.");
                System.exit(-1);
            }

            System.out.println("\nTesting connections...");
            if (city.hasConnection("Atwater", "Guy Concordia", "Green Line") &&
                city.hasConnection("Cote Vertu", "Du College", "Orange Line") &&
                city.hasConnection("Snowdon", "Cote des Neiges", "Blue Line")) {
                System.out.println("...connections test passed successfully.");
            }
            else
            {
                System.out.println("...connections test FAILED");
                System.exit(-1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
