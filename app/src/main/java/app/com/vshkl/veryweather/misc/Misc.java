package app.com.vshkl.veryweather.misc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import app.com.vshkl.veryweather.R;

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

    public static int setWeatherImage(String value) {
        int resourse = 0;
        switch (value) {
            case "01d":
            case "01n":
                resourse = R.drawable.weather_sunny;
                break;
            case "02d":
            case "02n":
                resourse = R.drawable.weather_mostly_cloudly;
                break;
            case "03d":
            case "03n":
                resourse = R.drawable.weather_cloudy;
                break;
            case "04d":
            case "04n":
                resourse = R.drawable.weather_cloudy;
                break;
            case "09d":
            case "09n":
                resourse = R.drawable.weather_drizzle;
                break;
            case "10d":
            case "10n":
                resourse = R.drawable.weather_slight_drizzle;
                break;
            case "11d":
            case "11n":
                resourse = R.drawable.weather_thunderstorm;
                break;
            case "13d":
            case "13n":
                resourse = R.drawable.weather_show;
                break;
            case "50d":
            case "50n":
                resourse = R.drawable.weather_cloudy;
                break;
        }
        return resourse;
    }
}
