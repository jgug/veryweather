
package app.com.vshkl.veryweather.currentweather.weather;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Conditions {

    @Expose
    private Coord coord;
    @Expose
    private Sys sys;
    @Expose
    private List<Weather> weather = new ArrayList<Weather>();
    @Expose
    private String base;
    @Expose
    private Main main;
    @Expose
    private Wind wind;
    @Expose
    private Rain rain;
    @Expose
    private Snow snow;
    @Expose
    private Clouds clouds;
    @Expose
    private int dt;
    @Expose
    private int id;
    @Expose
    private String name;
    @Expose
    private int cod;

    /**
     * @return The coord
     */
    public Coord getCoord() {
        return coord;
    }

    /**
     * @param coord The coord
     */
    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    /**
     * @return The sys
     */
    public Sys getSys() {
        return sys;
    }

    /**
     * @param sys The sys
     */
    public void setSys(Sys sys) {
        this.sys = sys;
    }

    /**
     * @return The weather
     */
    public List<Weather> getWeather() {
        return weather;
    }

    /**
     * @param weather The weather
     */
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    /**
     * @return The base
     */
    public String getBase() {
        return base;
    }

    /**
     * @param base The base
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     * @return The main
     */
    public Main getMain() {
        return main;
    }

    /**
     * @param main The main
     */
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * @return The wind
     */
    public Wind getWind() {
        return wind;
    }

    /**
     * @param wind The wind
     */
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    /**
     * @return The rain
     */
    public Rain getRain() {
        return rain;
    }

    /**
     * @param rain The rain
     */
    public void setRain(Rain rain) {
        this.rain = rain;
    }

    /**
     * @return The snow
     */
    public Snow getSnow() {
        return snow;
    }

    /**
     * @param snow The snow
     */
    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    /**
     * @return The clouds
     */
    public Clouds getClouds() {
        return clouds;
    }

    /**
     * @param clouds The clouds
     */
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    /**
     * @return The dt
     */
    public int getDt() {
        return dt;
    }

    /**
     * @param dt The dt
     */
    public void setDt(int dt) {
        this.dt = dt;
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
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The cod
     */
    public int getCod() {
        return cod;
    }

    /**
     * @param cod The cod
     */
    public void setCod(int cod) {
        this.cod = cod;
    }
}
