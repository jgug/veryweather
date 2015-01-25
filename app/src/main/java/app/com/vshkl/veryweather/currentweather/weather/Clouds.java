
package app.com.vshkl.veryweather.currentweather.weather;

import com.google.gson.annotations.Expose;

public class Clouds {

    @Expose
    private int all;

    /**
     * @return The all
     */
    public int getAll() {
        return all;
    }

    /**
     * @param all The all
     */
    public void setAll(int all) {
        this.all = all;
    }

}
