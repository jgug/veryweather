
package app.com.vshkl.veryweather.currentweather.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {

    @Expose
    private double temp;
    @SerializedName("temp_min")
    @Expose
    private double tempMin;
    @SerializedName("temp_max")
    @Expose
    private double tempMax;
    @Expose
    private double pressure;
    @Expose
    private int humidity;

    /**
     * @return The temp
     */
    public double getTemp() {
        return temp;
    }

    /**
     * @param temp The temp
     */
    public void setTemp(double temp) {
        this.temp = temp;
    }

    /**
     * @return The tempMin
     */
    public double getTempMin() {
        return tempMin;
    }

    /**
     * @param tempMin The temp_min
     */
    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    /**
     * @return The tempMax
     */
    public double getTempMax() {
        return tempMax;
    }

    /**
     * @param tempMax The temp_max
     */
    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    /**
     * @return The pressure
     */
    public double getPressure() {
        return pressure;
    }

    /**
     * @param pressure The pressure
     */
    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    /**
     * @return The humidity
     */
    public int getHumidity() {
        return humidity;
    }

    /**
     * @param humidity The humidity
     */
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

}
