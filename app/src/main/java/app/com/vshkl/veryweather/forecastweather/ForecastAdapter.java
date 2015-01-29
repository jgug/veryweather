package app.com.vshkl.veryweather.forecastweather;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import app.com.vshkl.veryweather.R;
import app.com.vshkl.veryweather.forecastweather.forecast.ListForecast;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastViewHolder> {

    private List<ListForecast> forecastList;

    public ForecastAdapter(List<ListForecast> forecastList) {
        this.forecastList = forecastList;
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
            /*Build max temp*/
            sb.append(Math.round(lf.getTemp().getMax())).append("°");
            holder.maxTemp.setText(sb);
            sb.setLength(0);
            /*Build min temp*/
            sb.append(Math.round(lf.getTemp().getMin())).append("°");
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
