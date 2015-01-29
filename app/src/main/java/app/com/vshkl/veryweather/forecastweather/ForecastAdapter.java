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
            String tempUnit = prefs.getString(context.getString(R.string.pref_temp_key),
                    context.getString(R.string.pref_temp_default));
            /*Build max temp*/
            if (tempUnit.equals("c")) {
                sb.append(Math.round(lf.getTemp().getMax())).append("°");
            } else if (tempUnit.equals("f")) {
                sb.append(Math.round(Misc.toFahrenheit(lf.getTemp().getMax()))).append("°");
            }
//            sb.append(Math.round(lf.getTemp().getMax())).append("°");
            holder.maxTemp.setText(sb);
            sb.setLength(0);
            /*Build min temp*/
            if (tempUnit.equals("c")) {
                sb.append(Math.round(lf.getTemp().getMin())).append("°");
            } else if (tempUnit.equals("f")) {
                sb.append(Math.round(Misc.toFahrenheit(lf.getTemp().getMax()))).append("°");
            }
//            sb.append(Math.round(lf.getTemp().getMin())).append("°");
            holder.minTemp.setText(sb);
            sb.setLength(0);
            /*Build description*/
            holder.description.setText(lf.getWeather().get(0).getDescription());
            /*Build wind*/
            sb.append(lf.getSpeed()).append(" m/s   ").append(Math.round(lf.getDeg())).append("°");
            holder.wind.setText(sb);
            sb.setLength(0);
            /*Build pressure*/
            sb.append(lf.getPressure()).append(" hPa");
            holder.pressure.setText(sb);
            sb.setLength(0);
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
