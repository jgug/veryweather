
package app.com.vshkl.veryweather.currentweather.weather;

import com.google.gson.annotations.Expose;

public class Sys {

    @Expose
    private int type;
    @Expose
    private int id;
    @Expose
    private double message;
    @Expose
    private String country;
    @Expose
    private int sunrise;
    @Expose
    private int sunset;

    /**
     * @return The type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return The id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return The message
     */
    public double getMessage() {
        return message;
    }

    /**
     * @param message The message
     */
    public void setMessage(double message) {
        this.message = message;
    }

    /**
     * @return The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return The sunrise
     */
    public int getSunrise() {
        return sunrise;
    }

    /**
     * @param sunrise The sunrise
     */
    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    /**
     * @return The sunset
     */
    public int getSunset() {
        return sunset;
    }

    /**
     * @param sunset The sunset
     */
    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

}
