package app.com.vshkl.veryweather.forecastweather;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import app.com.vshkl.veryweather.R;
import app.com.vshkl.veryweather.forecastweather.forecast.Forecast;
import app.com.vshkl.veryweather.forecastweather.forecast.ListForecast;

/**
 * Created by jgug on 27.1.15.
 */
public class ForecastFragment extends ListFragment {

    String[] fakeData = new String[]{"Pogoda! Khorosho!", "Pogoda! Khorosho!", "Pogoda! Khorosho!",
            "Pogoda! Khorosho!", "Pogoda! Khorosho!", "Pogoda! Khorosho!", "Pogoda! Khorosho!",};

    SwipeRefreshLayout refreshLayout;

    TextView text;
    ArrayAdapter<String> adapter;

    public void updateForecast() {
        GetForecast forecast = new GetForecast();
        forecast.execute("625144");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        refreshLayout = (SwipeRefreshLayout)getActivity().findViewById(R.id.activity_main_swipe_refresh_layout);
//        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//
//            }
//        });

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                getActivity(), android.R.layout.simple_list_item_1, fakeData);
//        setListAdapter(adapter);

        text = (TextView) getActivity().findViewById(R.id.foreast_text);
    }

    @Override
    public void onStart() {
        updateForecast();
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private class GetForecast extends AsyncTask<String, Void, Forecast> {

        @Override
        protected Forecast doInBackground(String... params) {
            HttpURLConnection urlConnection = null;
            BufferedReader bufferedReader = null;

            String format = "json";
            String units = "metric";
            String days = "7";

            Forecast forecast = null;

            try {
                final String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?i";
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
                List<ListForecast> list1 = new ArrayList<>();
                List<String> list2 = new ArrayList<>();
                list1 = forecast.getList();
                for (ListForecast i : list1) {
                    StringBuilder sb = new StringBuilder();
                    list2.add(
                            sb.append(i.getTemp().getMax().toString())
                                    .append("°")
                                    .append("  -  ")
                                    .append(i.getTemp().getMin().toString())
                                    .append("°").toString());
                }
                String[] str = list2.toArray(new String[list2.size()]);
                adapter = new ArrayAdapter<String>(
                        getActivity(), android.R.layout.simple_list_item_1, str);
                setListAdapter(adapter);
            }
        }
    }
}
