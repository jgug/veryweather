package app.com.vshkl.veryweather.settings;

import android.app.Activity;
import android.os.Bundle;
import android.preference.Preference;

public class SettingsActivity extends Activity implements Preference.OnPreferenceChangeListener {
//    private void bindPrefSummaryToValue(Preference preference) {
//        preference.setOnPreferenceChangeListener(this);
//
//        onPreferenceChange(preference,
//                PreferenceManager
//                        .getDefaultSharedPreferences(preference.getContext())
//                        .getString(preference.getKey(), ""));
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        return false;
    }


}
