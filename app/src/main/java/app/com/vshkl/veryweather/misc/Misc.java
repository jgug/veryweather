package app.com.vshkl.veryweather.misc;

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
}
