package app.com.vshkl.veryweather.forecastweather;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import app.com.vshkl.veryweather.R;

public class ForecastViewHolder extends RecyclerView.ViewHolder {
    protected FrameLayout container;
    protected CardView card;
    protected ImageView icon;
    protected TextView temp;
    protected TextView description;
    protected TextView wind;
    protected TextView pressure;
    protected TextView date;

    public ForecastViewHolder(View view) {
        super(view);
        container = (FrameLayout) view.findViewById(R.id.list_container);
        card = (CardView) view.findViewById(R.id.cardList);
        icon = (ImageView) view.findViewById(R.id.forecast_icon);
        temp = (TextView) view.findViewById(R.id.forecast_temp);
        description = (TextView) view.findViewById(R.id.forecast_description);
        wind = (TextView) view.findViewById(R.id.forecast_wind);
        pressure = (TextView) view.findViewById(R.id.forecast_pressure);
        date = (TextView) view.findViewById(R.id.forecast_date);
    }
}
