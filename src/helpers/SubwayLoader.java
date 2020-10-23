package helpers;

import models.Subway;

import java.io.File;
import java.io.*;

/**
 * The Subway loader helper is used to lead a subway file into a Java object.
 */
public class SubwayLoader
{
    private final Subway subway;

    /**
     * Instantiates a new Subway loader.
     */
    public SubwayLoader() {
        this.subway = new Subway();
    }

    /**
     * Load a subway layout from a file.
     *
     * @param subwayFile the subway file
     * @return the subway
     * @throws IOException if no file is found or the program can't open a stream to the file
     */
    public Subway loadFromFile(File subwayFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(subwayFile));
        loadStations(subway, reader);
        String lineName = reader.readLine();
        while ((lineName != null) && (lineName.length() > 0)) {
            loadLine(subway, reader, lineName);
            lineName = reader.readLine();
        }
        return subway;
    }
    
    private void loadStations(Subway subway, BufferedReader reader) throws IOException {
        String currentLine;
        currentLine = reader.readLine();
        while (currentLine.length() > 0) {
            subway.addStation(currentLine);
            currentLine = reader.readLine();
        }
    }
    
    private void loadLine(Subway subway, BufferedReader reader, String lineName) throws IOException {
        String station1Name, station2Name;
        station1Name = reader.readLine();
        station2Name = reader.readLine();
        while ((station2Name != null) && (station2Name.length() > 0)) {
            subway.addConnection(station1Name, station2Name, lineName);
            station1Name = station2Name;
            station2Name = reader.readLine();
        }
    }
}
