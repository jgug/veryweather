package app.com.vshkl.veryweather.currentweather;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import app.com.vshkl.veryweather.R;
import app.com.vshkl.veryweather.currentweather.weather.Conditions;

/**
 * A placeholder fragment containing a simple view.
 *
 * @author Pavel Vashkel
 */
public class CurrentFragment extends Fragment {

    TextView title;
    ImageView icon;
    TextView description;
    TextView temp_now;
    TextView humidity;
    TextView pressure;
    TextView wind;
    TextView clouds;
    TextView sun;

    public CurrentFragment() {
    }

    public void updateCurrentConditions() {
        GetCurrentWeather currentWeather = new GetCurrentWeather();
        currentWeather.execute("625144");
    }

    /**
     * Called when the Fragment is visible to the user.  This is generally
     * tied to Activity.onStart of the containing
     * Activity's lifecycle.
     */
    @Override
    public void onStart() {
        updateCurrentConditions();
        super.onStart();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_current, container, false);

        title = (TextView) rootView.findViewById(R.id.cur_location);
        icon = (ImageView) rootView.findViewById(R.id.cur_icon);
        description = (TextView) rootView.findViewById(R.id.cur_description);
        temp_now = (TextView) rootView.findViewById(R.id.cur_temp_now);
        humidity = (TextView) rootView.findViewById(R.id.cur_humidity);
        pressure = (TextView) rootView.findViewById(R.id.cur_pressure);
        wind = (TextView) rootView.findViewById(R.id.cur_wind);
        clouds = (TextView) rootView.findViewById(R.id.cur_clouds);
        sun = (TextView) rootView.findViewById(R.id.cur_sun);

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.current_conditions, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            updateCurrentConditions();
            Toast.makeText(getActivity(), "Weather updated!", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class GetCurrentWeather extends AsyncTask<String, Void, Conditions> {

        private String getTime(long time) {
            Date date = new Date(time * 1000l);
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            return format.format(date);
        }

        /**
         * Override this method to perform a computation on a background thread. The
         * specified parameters are the parameters passed to {@link #execute}
         * by the caller of this task.
         * <p/>
         * This method can call {@link #publishProgress} to publish updates
         * on the UI thread.
         *
         * @param params The parameters of the task.
         * @return A result, defined by the subclass of this task.
         * @see #onPreExecute()
         * @see #onPostExecute
         * @see #publishProgress
         */
        @Override
        protected Conditions doInBackground(String... params) {
            HttpURLConnection urlConnection = null;
            BufferedReader bufferedReader = null;

            String format = "json";
            String units = "metric";

            Conditions conditions = null;

            try {
                final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?";
                final String QUERY_PARAM = "id";
                final String FORMAT_PARAM = "mode";
                final String UNITS_PARAM = "units";

                Uri buildUri = Uri.parse(BASE_URL).buildUpon()
                        .appendQueryParameter(QUERY_PARAM, params[0])
                        .appendQueryParameter(FORMAT_PARAM, format)
                        .appendQueryParameter(UNITS_PARAM, units)
                        .build();

                URL url = new URL(buildUri.toString());
                Log.v("Current URL", url.toString());

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                if (inputStream == null) {
                    return null;
                }
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                Gson gson = new Gson();
                conditions = gson.fromJson(bufferedReader, Conditions.class);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return conditions;
        }

        /**
         * <p>Runs on the UI thread after {@link #doInBackground}. The
         * specified result is the value returned by {@link #doInBackground}.</p>
         * <p/>
         * <p>This method won't be invoked if the task was cancelled.</p>
         *
         * @param conditions The result of the operation computed by {@link #doInBackground}.
         * @see #onPreExecute
         * @see #doInBackground
         * @see #onCancelled(Object)
         */
        @Override
        protected void onPostExecute(Conditions conditions) {
            if (conditions != null) {
                StringBuilder sb = new StringBuilder();
                // Build title
                sb.append(conditions.getName())
                        .append(", ")
                        .append(conditions.getSys().getCountry())
                        .append(", ")
                        .append(getTime(conditions.getDt()));
                title.setText(sb.toString());
                sb.setLength(0);
                // Build description
                sb.append(conditions.getWeather().get(0).getDescription());
                description.setText(sb.toString());
                sb.setLength(0);
                // Build now temp
                sb.append(Math.round(conditions.getMain().getTemp()))
                        .append("°");
                temp_now.setText(sb.toString());
                sb.setLength(0);
                // Build humidity
                sb.append(conditions.getMain().getHumidity())
                        .append(" %");
                humidity.setText(sb.toString());
                sb.setLength(0);
                // Build pressure
                sb.append(Math.round(conditions.getMain().getPressure()))
                        .append(" hPa");
                pressure.setText(sb.toString());
                sb.setLength(0);
                // Build wind
                sb.append(Math.round(conditions.getWind().getSpeed()))
                        .append(" m/s,  ")
                        .append(Math.round(conditions.getWind().getDeg()))
                        .append(" °");
                wind.setText(sb.toString());
                sb.setLength(0);
                // Build clouds
                sb.append(conditions.getClouds().getAll())
                        .append(" %");
                clouds.setText(sb.toString());
                sb.setLength(0);
                // Build sunrise & sunset
                sb.append(getTime(conditions.getSys().getSunrise()))
                        .append(" - ")
                        .append(getTime(conditions.getSys().getSunset()));
                sun.setText(sb.toString());
                sb.setLength(0);
            }
        }
    }
}

