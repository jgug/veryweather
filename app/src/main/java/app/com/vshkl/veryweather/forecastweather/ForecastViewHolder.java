package app.com.vshkl.veryweather.forecastweather;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app.com.vshkl.veryweather.R;

public class ForecastViewHolder extends RecyclerView.ViewHolder {
    protected ImageView icon;
    protected TextView maxTemp;
    protected TextView minTemp;
    protected TextView description;
    protected TextView wind;
    protected TextView pressure;

    public ForecastViewHolder(View view) {
        super(view);
        icon = (ImageView) view.findViewById(R.id.forecast_icon);
        maxTemp = (TextView) view.findViewById(R.id.forecast_max_temp);
        minTemp = (TextView) view.findViewById(R.id.forecast_min_temp);
        description = (TextView) view.findViewById(R.id.forecast_description);
        wind = (TextView) view.findViewById(R.id.forecast_wind);
        pressure = (TextView) view.findViewById(R.id.forecast_pressure);
    }
}
