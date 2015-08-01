package app.com.vshkl.veryweather.forecastweather;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import app.com.vshkl.veryweather.R;
import app.com.vshkl.veryweather.forecastweather.forecast.ListForecast;
import app.com.vshkl.veryweather.misc.Misc;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastViewHolder> {

    private List<ListForecast> forecastList;
    private Context context;

    public ForecastAdapter(List<ListForecast> forecastList, Context context) {
        this.forecastList = forecastList;
        this.context = context;
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_forecast_item, parent, false);

        return new ForecastViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {
        ListForecast lf = forecastList.get(position);

        if (lf != null) {
            StringBuilder sb = new StringBuilder();

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

            /*Build temp*/
            String unit = prefs.getString(context.getString(R.string.pref_temp_key),
                    context.getString(R.string.pref_temp_default));
            switch (unit) {
                case "c":
                    sb.append(Math.round(lf.getTemp().getMax())).append("°")
                            .append("/").append(Math.round(lf.getTemp().getMin())).append("°");
                    break;
                case "f":
                    sb.append(Math.round(Misc.toFahrenheit(lf.getTemp().getMax()))).append("°")
                            .append("/")
                            .append(Math.round(Misc.toFahrenheit(lf.getTemp().getMin()))).append("°");
                    break;
            }
            holder.temp.setText(sb.toString());
            sb.setLength(0);

            /*Build description*/
            holder.description.setText(lf.getWeather().get(0).getDescription());

            /*Build wind*/
            unit = prefs.getString(context.getString(R.string.pref_wind_key),
                    context.getString(R.string.pref_wind_default));
            switch (unit) {
                case "ms":
                    sb.append(Math.round(lf.getSpeed()))
                            .append(" ms,  ");
                    break;
                case "kph":
                    sb.append(Math.round(Misc.kph(lf.getSpeed())))
                            .append(" kph,  ");
                    break;
                case "mph":
                    sb.append(Math.round(Misc.mph(lf.getSpeed())))
                            .append(" mph,  ");
                    break;
            }
            sb.append(Misc.degToCompass(lf.getDeg()));
            holder.wind.setText(sb);
            sb.setLength(0);

            /*Build pressure*/
            unit = prefs.getString(context.getString(R.string.pref_pressure_key),
                    context.getString(R.string.pref_pressure_default));
            switch (unit) {
                case "mb":
                    sb.append(Math.round(lf.getPressure()))
                            .append(" mb");
                    break;
                case "mm":
                    sb.append(Math.round(Misc.mmHg(lf.getPressure())))
                            .append(" mmHg");
                    break;
                case "atm":
                    sb.append(Math.round(Misc.atm(lf.getPressure())))
                            .append(" atm");
                    break;
                case "kPa":
                    sb.append(Math.round(Misc.kPa(lf.getPressure())))
                            .append(" kPa");
                    break;
            }
            holder.pressure.setText(sb);
            sb.setLength(0);

            /*Build date*/
            holder.date.setText(Misc.date(lf.getDt()));

            /*Build weather icon*/
            String iconStr = lf.getWeather().get(0).getIcon();
            holder.icon.setImageResource(Misc.setWeatherImage(iconStr));
        }
    }

    @Override
    public int getItemCount() {
        if (forecastList == null) {
            return 0;
        } else {
            return forecastList.size();
        }
    }
}

