package app.com.vshkl.veryweather.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import app.com.vshkl.veryweather.R;

public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.settings);
    }

}
