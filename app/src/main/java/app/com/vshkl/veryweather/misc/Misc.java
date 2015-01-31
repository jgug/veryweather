package app.com.vshkl.veryweather.misc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Misc {

    public static int toFahrenheit(int value) {
        return value * 9 / 5 + 32;
    }

    public static double toFahrenheit(double value) {
        return value * 9 / 5 + 32;
    }

    public static double atm(double value) {
        return value * 0.00098692326671601;
    }

    public static double mmHg(double value) {
        return value * 0.75006375541921;
    }

    public static double kPa(double value) {
        return value / 10;
    }

    public static double kph(double value) {
        return value * 3.6;
    }

    public static double mph(double value) {
        return value * 2.2369362920544;
    }

    public static String date(int value) {
        Date date = new Date(value * 1000l);
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE,ddMMM");
        dateFormat.setTimeZone(TimeZone.getDefault());
        return dateFormat.format(date);
    }

    public static String degToCompass(double value) {
        String directions[] = {"N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE",
                "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW", "N "};
        return directions[(int) Math.floor(((value + 11.25) % 360) / 22.5)];
    }
}
