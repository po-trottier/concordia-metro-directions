package models;

/**
 * The type Connection represents the link between two stations. It can also be seen as a displacement between stations.
 */
public class Connection
{
    private final Station station1;
    private final Station station2;
    private final String lineName;

    /**
     * Instantiates a new Connection.
     *
     * @param station1 the first station
     * @param station2 the next station
     * @param lineName the line name
     */
    public Connection(Station station1, Station station2, String lineName)
    {
        this.station1 = station1;
        this.station2 = station2;
        this.lineName = lineName;
    }

    /**
     * Gets the first station.
     *
     * @return the first station
     */
    public Station getStation1()
    {
        return station1;
    }

    /**
     * Gets the next station.
     *
     * @return the next station
     */
    public Station getStation2()
    {
        return station2;
    }

    /**
     * Gets line name.
     *
     * @return the line name
     */
    public String getLineName()
    {
        return lineName;
    }
    
    public String toString()
    {
        return "[" + station1.getName() + ", " + station2.getName() + ", " + lineName + "]";
    }
    
}
