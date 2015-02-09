package app.com.vshkl.veryweather.misc;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WeatherStorage {
    /**
     * Store JSON, passing as string to file
     *
     * @param context  is app context
     * @param filename is name of file to store
     * @param json     is String with JSON
     */
    public static void storeWeather(Context context, String filename, String json) {
        FileOutputStream outputStream;

        try {
            outputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(json.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read JSON from file and return as String
     *
     * @param context
     * @param filename
     * @return Strign with JSON
     */
    public static String readWeather(Context context, String filename) {
        FileInputStream inputStream;
        StringBuilder sb = new StringBuilder();

        try {
            inputStream = context.openFileInput(filename);
            String line;
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    /**
     * Check if file exists
     *
     * @param context
     * @param filename
     * @return
     */
    public static boolean hasFile(Context context, String filename) {
        FileInputStream inputStream;

        try {
            if ((inputStream = context.openFileInput(filename)) != null) {
                return true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}


