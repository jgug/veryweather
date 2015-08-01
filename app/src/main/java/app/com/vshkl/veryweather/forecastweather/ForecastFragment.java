package app.com.vshkl.veryweather.forecastweather;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import app.com.vshkl.veryweather.R;
import app.com.vshkl.veryweather.forecastweather.forecast.Forecast;
import app.com.vshkl.veryweather.misc.WeatherStorage;
import uk.co.imallan.jellyrefresh.JellyRefreshLayout;

public class ForecastFragment extends Fragment {

    private RecyclerView recyclerView;
    private ForecastAdapter adapter;
    private LinearLayoutManager layoutManager;
    private JellyRefreshLayout jellyRefreshLayout;

    private Forecast forecast;

    public void updateForecast() {
        GetForecast forecast = new GetForecast();

        // Load SharedPreference for location
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String location = prefs.getString(getString(R.string.pref_location_key),
                getString(R.string.pref_location_default));

        forecast.execute(location);
    }

    public void fillForecast(Forecast forecast) {
        adapter = new ForecastAdapter(forecast.getList(), getActivity());
        recyclerView.setAdapter(adapter);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        StringBuilder sb = new StringBuilder();
        DateFormat format = new SimpleDateFormat("HH:mm");
        sb.append(forecast.getCity().getName()).append(", ")
                .append(forecast.getCity().getCountry()).append(", ")
                .append(format.format(new Date()));
        actionBar.setSubtitle(sb.toString());
    }

    @Override
    public void onStart() {
        super.onStart();

        if (WeatherStorage.hasFile(getActivity(), "forecast_weather")) {
            Gson gson = new Gson();
            String json = WeatherStorage.readWeather(getActivity(), "forecast_weather");
            forecast = gson.fromJson(json, Forecast.class);
            fillForecast(forecast);
        } else {
            updateForecast();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();

        Gson gson = new Gson();
        String json = gson.toJson(forecast);
        Log.v("TO JSON", json);
        WeatherStorage.storeWeather(getActivity(), "forecast_weather", json);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_forecast, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.cardList);

        jellyRefreshLayout = (JellyRefreshLayout) rootView.findViewById(R.id.swipe_refresh);
        jellyRefreshLayout.setRefreshListener(new JellyRefreshLayout.JellyRefreshListener() {
            @Override
            public void onRefresh(JellyRefreshLayout jellyRefreshLayout) {
                updateForecast();
            }
        });

        return rootView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    private class GetForecast extends AsyncTask<String, Void, Forecast> {

        @Override
        protected Forecast doInBackground(String... params) {
            HttpURLConnection urlConnection = null;
            BufferedReader bufferedReader = null;

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
            String location = prefs.getString(getString(R.string.pref_location_key),
                    getString(R.string.pref_location_default));
            String days = prefs.getString(getString(R.string.pref_forecast_key),
                    getString(R.string.pref_forecast_default));

            String format = "json";
            String units = "metric";

            try {
                final String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?";
                final String QUERY_PARAM = "id";
                final String FORMAT_PARAM = "mode";
                final String UNITS_PARAM = "units";
                final String DAYS_PARAM = "cnt";

                Uri buirdUri = Uri.parse(BASE_URL).buildUpon()
                        .appendQueryParameter(QUERY_PARAM, params[0])
                        .appendQueryParameter(FORMAT_PARAM, format)
                        .appendQueryParameter(UNITS_PARAM, units)
                        .appendQueryParameter(DAYS_PARAM, days)
                        .build();

                URL url = new URL(buirdUri.toString());
                Log.v("Forecast URL", url.toString());

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                if (inputStream == null) {
                    return null;
                }
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                Gson gson = new Gson();
                forecast = gson.fromJson(bufferedReader, Forecast.class);

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

            return forecast;
        }

        @Override
        protected void onPostExecute(Forecast forecast) {
            if (forecast != null) {
                fillForecast(forecast);
                jellyRefreshLayout.finishRefreshing();
            }
        }
    }
}
