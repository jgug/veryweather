package app.com.vshkl.veryweather.misc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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

    // TODO: Fix typo
    // TODO: Optimize algorithm
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


    public static String getDescriptionById(int value) {
        final Map<Integer, String> weatherConditions = new HashMap<>();

        /* Thunderstorm */
        weatherConditions.put(200, "thunderstorm with light rain");
        weatherConditions.put(201, "thunderstorm with rain");
        weatherConditions.put(202, "thunderstorm with heavy rain");
        weatherConditions.put(210, "light thunderstorm");
        weatherConditions.put(211, "thunderstorm");
        weatherConditions.put(212, "heavy thunderstorm");
        weatherConditions.put(221, "ragged thunderstorm");
        weatherConditions.put(230, "thunderstorm with light drizzle");
        weatherConditions.put(231, "thunderstorm with drizzle");
        weatherConditions.put(232, "thunderstorm with heavy drizzle");

        /* Drizzle */
        weatherConditions.put(300, "light intensity drizzle");
        weatherConditions.put(301, "drizzle");
        weatherConditions.put(302, "heavy intensity drizzle");
        weatherConditions.put(310, "light intensity drizzle rain");
        weatherConditions.put(311, "drizzle rain");
        weatherConditions.put(312, "heavy intensity drizzle rain");
        weatherConditions.put(313, "shower rain and drizzle");
        weatherConditions.put(314, "heavy shower rain and drizzle");
        weatherConditions.put(321, "shower drizzle");

        /* Rain */
        weatherConditions.put(500, "light rain");
        weatherConditions.put(501, "moderate rain");
        weatherConditions.put(502, "heavy intensity rain");
        weatherConditions.put(503, "very heavy rain");
        weatherConditions.put(504, "extreme rain");
        weatherConditions.put(511, "freezing rain");
        weatherConditions.put(520, "light intensity shower rain");
        weatherConditions.put(521, "shower rain");
        weatherConditions.put(522, "heavy intensity shower rain");
        weatherConditions.put(531, "ragged shower rain");

        /* Snow */
        weatherConditions.put(600, "light snow");
        weatherConditions.put(601, "snow");
        weatherConditions.put(602, "heavy snow");
        weatherConditions.put(611, "sleet");
        weatherConditions.put(612, "shower sleet");
        weatherConditions.put(615, "light rain and snow");
        weatherConditions.put(616, "rain and snow");
        weatherConditions.put(620, "light shower snow");
        weatherConditions.put(621, "shower snow");
        weatherConditions.put(622, "heavy shower snow");

        /* Atmosphere */
        weatherConditions.put(701, "mist");
        weatherConditions.put(711, "smoke");
        weatherConditions.put(721, "haze");
        weatherConditions.put(731, "sand, dust whirls");
        weatherConditions.put(741, "fog");
        weatherConditions.put(751, "sand");
        weatherConditions.put(761, "dust");
        weatherConditions.put(762, "volcanic ash");
        weatherConditions.put(771, "squalls");
        weatherConditions.put(781, "tornado");

        /* Clouds */
        weatherConditions.put(800, "clear sky");
        weatherConditions.put(801, "few clouds");
        weatherConditions.put(802, "scattered clouds");
        weatherConditions.put(803, "broken clouds");
        weatherConditions.put(804, "overcast clouds");

        /* Extreme */
        weatherConditions.put(900, "tornado");
        weatherConditions.put(901, "tropical storm");
        weatherConditions.put(902, "hurricane");
        weatherConditions.put(903, "cold");
        weatherConditions.put(904, "hot");
        weatherConditions.put(905, "windy");
        weatherConditions.put(906, "hail");

        /* Additional */
        weatherConditions.put(951, "calm");
        weatherConditions.put(952, "light breeze");
        weatherConditions.put(953, "gentle breeze");
        weatherConditions.put(954, "moderate breeze");
        weatherConditions.put(955, "fresh breeze");
        weatherConditions.put(956, "strong breeze");
        weatherConditions.put(957, "high wind, near gale");
        weatherConditions.put(958, "gale");
        weatherConditions.put(959, "severe gale");
        weatherConditions.put(960, "storm");
        weatherConditions.put(961, "violent storm");
        weatherConditions.put(962, "hurricane");

        return weatherConditions.get(value);
    }

    public static String getTime(long time) {
        Date date = new Date(time * 1000l);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(date);
    }
}
