package com.example.phones_app.MainActivityFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.fragment.app.Fragment;

import com.example.phones_app.R;

public class PreferencesFragment extends Fragment {
    //a fragment for the "Preferences" screen in the drawer navigation menu
    //displays 4 card views with a switch in them
    View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_preferences, container, false);

        //assign switches, allows for future implementation
        Switch Darkmode         = (Switch) view.findViewById(R.id.settings_main_darkmode_switch);
        Switch BlueLightFilter  = (Switch) view.findViewById(R.id.settings_main_blue_light_switch);
        Switch Sound            = (Switch) view.findViewById(R.id.preferences_sound_switch);
        Switch DisplayUSD       = (Switch) view.findViewById(R.id.preferences_display_usd_switch);

        return view;
    }

}