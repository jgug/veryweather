
package app.com.vshkl.veryweather.forecastweather.forecast;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class ListForecast {

    @Expose
    private Integer dt;
    @Expose
    private Temp temp;
    @Expose
    private Double pressure;
    @Expose
    private Integer humidity;
    @Expose
    private List<Weather> weather = new ArrayList<Weather>();
    @Expose
    private Double speed;
    @Expose
    private Integer deg;
    @Expose
    private Integer clouds;
    @Expose
    private Double snow;
    @Expose
    private Integer rain;

    /**
     * @return The dt
     */
    public Integer getDt() {
        return dt;
    }

    /**
     * @param dt The dt
     */
    public void setDt(Integer dt) {
        this.dt = dt;
    }

    /**
     * @return The temp
     */
    public Temp getTemp() {
        return temp;
    }

    /**
     * @param temp The temp
     */
    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    /**
     * @return The pressure
     */
    public Double getPressure() {
        return pressure;
    }

    /**
     * @param pressure The pressure
     */
    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    /**
     * @return The humidity
     */
    public Integer getHumidity() {
        return humidity;
    }

    /**
     * @param humidity The humidity
     */
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    /**
     * @return The weather
     */
    public java.util.List<Weather> getWeather() {
        return weather;
    }

    /**
     * @param weather The weather
     */
    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    /**
     * @return The speed
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     * @param speed The speed
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     * @return The deg
     */
    public Integer getDeg() {
        return deg;
    }

    /**
     * @param deg The deg
     */
    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    /**
     * @return The clouds
     */
    public Integer getClouds() {
        return clouds;
    }

    /**
     * @param clouds The clouds
     */
    public void setClouds(Integer clouds) {
        this.clouds = clouds;
    }

    /**
     * @return The snow
     */
    public Double getSnow() {
        return snow;
    }

    /**
     * @param snow The snow
     */
    public void setSnow(Double snow) {
        this.snow = snow;
    }

    /**
     * @return The rain
     */
    public Integer getRain() {
        return rain;
    }

    /**
     * @param rain The rain
     */
    public void setRain(Integer rain) {
        this.rain = rain;
    }

}
