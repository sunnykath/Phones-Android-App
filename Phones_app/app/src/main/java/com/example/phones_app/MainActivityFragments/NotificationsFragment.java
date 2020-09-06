package com.example.phones_app.MainActivityFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.fragment.app.Fragment;

import com.example.phones_app.R;

public class NotificationsFragment extends Fragment {
    //a fragment for the "Home" screen in the drawer navigation menu
    //displays 3 card views with a switch in them
    View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_notifications, container, false);

        //assign the switches, allows for future implementation
        Switch PushNotifications    = (Switch) view.findViewById(R.id.notifications_push_notifications_switch);
        Switch SMSNotifications     = (Switch) view.findViewById(R.id.notifications_sms_notifications_switch);
        Switch EmailNotifications   = (Switch) view.findViewById(R.id.notifications_email_notifications_switch);
        return view;
    }
}
