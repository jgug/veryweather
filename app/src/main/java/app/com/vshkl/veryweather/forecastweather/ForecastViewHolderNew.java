package app.com.vshkl.veryweather.forecastweather;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app.com.vshkl.veryweather.R;

public class ForecastViewHolderNew extends RecyclerView.ViewHolder {
    protected ImageView icon;
    protected TextView temp;
    protected TextView description;
    protected TextView wind;
    protected TextView pressure;
    protected TextView date;

    public ForecastViewHolderNew(View view) {
        super(view);
        icon = (ImageView) view.findViewById(R.id.forecast_icon);
        temp = (TextView) view.findViewById(R.id.forecast_temp);
        description = (TextView) view.findViewById(R.id.forecast_description);
        wind = (TextView) view.findViewById(R.id.forecast_wind);
        pressure = (TextView) view.findViewById(R.id.forecast_pressure);
        date = (TextView) view.findViewById(R.id.forecast_date);
    }
}
