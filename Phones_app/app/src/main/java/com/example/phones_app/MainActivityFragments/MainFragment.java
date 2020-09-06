package com.example.phones_app.MainActivityFragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phones_app.Adapters.RecyclerViewAdapter;
import com.example.phones_app.DetailsActivity;
import com.example.phones_app.ListActivity;
import com.example.phones_app.PhoneProvider;
import com.example.phones_app.R;
import com.example.phones_app.models.Smartphone;

import java.util.ArrayList;

public class MainFragment extends Fragment implements RecyclerViewAdapter.OnPhoneClickListener {
    View view;
    //a fragment for the "Home" screen in the drawer navigation menu
    //displays 3 card views with a text view in them denoting the category array list they will send
    //also displays a recycler view with 3 'top picks'
    CardView showAppleListActivity, showMicrosoftListActivity, showSamsungListActivity;
    ArrayList<ArrayList> phones;
    ArrayList<Smartphone> highestRatedPhones = new ArrayList<Smartphone>();

    @Override
    @SuppressLint("RestrictedApi")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setHasOptionsMenu(true);

        //generate smartphone objects using data provider class to use when sending category intent to listActivity
        phones = PhoneProvider.generateData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);

        //assign cardViews
        showAppleListActivity = (CardView) view.findViewById(R.id.showAppleListActivity);
        showMicrosoftListActivity = (CardView) view.findViewById(R.id.showMicrosoftListActivity);
        showSamsungListActivity = (CardView) view.findViewById(R.id.showSamsungListActivity);

        //set on click listeners for each card view
        //we tell the ListActivity that this is a category intent, and pass on the array list of the category
        //with the respective smartphone objects in it, and also tell which category it is
        showAppleListActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AppleListIntent = new Intent(getActivity(), ListActivity.class);
                AppleListIntent.putExtra("HEADING", "Apple");
                AppleListIntent.putExtra("FROM", "category");
                AppleListIntent.putExtra("PHONE_LIST", phones.get(0));
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation
                        (getActivity(), showAppleListActivity, ViewCompat.getTransitionName(showAppleListActivity));
                startActivity(AppleListIntent, options.toBundle());
            }
        });
        showMicrosoftListActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listIntent = new Intent(getActivity(), ListActivity.class);
                listIntent.putExtra("HEADING", "Microsoft");
                listIntent.putExtra("FROM", "category");
                listIntent.putExtra("PHONE_LIST", phones.get(1));
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation
                        (getActivity(), showMicrosoftListActivity, ViewCompat.getTransitionName(showMicrosoftListActivity));
                startActivity(listIntent, options.toBundle());
            }
        });
        showSamsungListActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listIntent = new Intent(getActivity(), ListActivity.class);
                listIntent.putExtra("HEADING", "Samsung");
                listIntent.putExtra("FROM", "category");
                listIntent.putExtra("PHONE_LIST", phones.get(2));
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation
                        (getActivity(), showSamsungListActivity, ViewCompat.getTransitionName(showSamsungListActivity));
                startActivity(listIntent, options.toBundle());
            }
        });

        displayTopPicks();

        return view;
    }

    private void displayTopPicks() {
        //Top Picks

        int idx = 0;
        double maxRating = 0.0;
        // Highest Rated phone in each Category
        for(int i = 0; i< phones.size(); i++) {
            for(int j = 0; j < phones.get(i).size(); j++) {
                Smartphone phone = (Smartphone) phones.get(i).get(j);
                if (maxRating < phone.getRating()) {
                    idx = j;
                    maxRating = phone.getRating();
                }
            }
            // Add the phone to the ArrayList being displayed
            highestRatedPhones.add((Smartphone) phones.get(i).get(idx));
            maxRating = 0.0;
        }

        // Initialise the recycler view
        RecyclerView rView = view.findViewById(R.id.highest_rated);
        LinearLayoutManager llm = new LinearLayoutManager
                (getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rView.setLayoutManager(llm);
        // Set the Adapter to display the array
        RecyclerViewAdapter rAdapter = new RecyclerViewAdapter(getActivity(), highestRatedPhones, this);
        rView.setAdapter(rAdapter);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.clear();
        inflater.inflate(R.menu.drawer_settings_menu, menu);

        //hide overflow menu in toolbar, hide home icon
        menu.setGroupVisible(R.id.overflow_items, false);
        menu.setGroupVisible(R.id.home_icon, false);
    }

    @Override
    public void onPhoneClick(int position) {    // Method to be called when a similar phone is selected
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra(ListActivity.PHONE_DETAIL_KEY, position);
        intent.putExtra("Similar Phones", highestRatedPhones);
        startActivity(intent);
        // Transition
        getActivity().overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_left);
    }
}