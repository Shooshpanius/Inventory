package ru.logasoft.zaal.inventory;

import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.List;

public class SettingsActivity extends PreferenceActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Add a button to the header list.
        if (hasHeaders()) {
            Button button = new Button(this);
            button.setText("Some action");
            setListFooter(button);
        }
    }


    /**
     * Populate the activity with the top-level headers.
     */
    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.preference_headers, target);
    }



    /**
     * This fragment shows the preferences for the first header.
     */
    public static class Prefs1Fragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Make sure default values are applied.  In a real app, you would
            // want this in a shared function that is used to retrieve the
            // SharedPreferences wherever they are needed.
//            PreferenceManager.setDefaultValues(getActivity(),
//                    R.xml.advanced_preferences, false);

            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.fragmented_preferences);
        }
    }


    private final String[] FRAGMENTS = {
            "ru.logasoft.zaal.inventory.SettingsActivity$Prefs1Fragment"
    };

    @Override
    protected boolean isValidFragment(String fragmentName) {

        for (String FRAGMENT : FRAGMENTS) {
            if (FRAGMENT.equals(fragmentName)) {
                return true;
            }
        }
        return super.isValidFragment(fragmentName);
    }

}
