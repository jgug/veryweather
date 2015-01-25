
package app.com.vshkl.veryweather.currentweather.weather;

import com.google.gson.annotations.Expose;

public class Coord {

    @Expose
    private double lon;
    @Expose
    private double lat;

    /**
     * @return The lon
     */
    public double getLon() {
        return lon;
    }

    /**
     * @param lon The lon
     */
    public void setLon(double lon) {
        this.lon = lon;
    }

    /**
     * @return The lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * @param lat The lat
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

}
