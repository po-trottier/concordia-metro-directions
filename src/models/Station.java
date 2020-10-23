package models;

/**
 * The type Station represents a Subway Station.
 */
public class Station
{
    private final String name;

    /**
     * Instantiates a new Station.
     *
     * @param name the name of the station
     */
    public Station(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the station.
     *
     * @return the name of the station
     */
    public String getName() {
        return name;
    }
    
    public boolean equals(Object obj) {
        if (obj instanceof Station) {
            Station otherStation = (Station) obj;
            return otherStation.getName().equalsIgnoreCase(name);
        }
        return false;
    }
    
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }
}
