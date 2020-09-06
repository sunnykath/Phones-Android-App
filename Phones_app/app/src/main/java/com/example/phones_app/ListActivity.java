package com.example.phones_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.phones_app.Adapters.PhoneAdaptor;
import com.example.phones_app.models.Smartphone;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    //an activity for the functionality of the list screen
    //displays an array list of smartphone objects in card view format
    //Toolbar displays a search view, text view with a search message, and navigation icon back arrow
    public static final String PHONE_DETAIL_KEY = "phone";
    SearchView ListSearchView;
    Toolbar ListToolBar;
    ListView lvPhones;
    RelativeLayout rlListToolbar;
    TextView tvEmptyArray, tvListToolbar;
    PhoneAdaptor phoneAdaptor;
    ArrayList<Smartphone> phones;
    ArrayList<Smartphone> ListSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //get intent from mainActivity, determine if the array is a search result or a category
        Intent thisIntent = getIntent();
        String title = thisIntent.getStringExtra("HEADING");
        String sentFrom = thisIntent.getStringExtra("FROM");
        phones =  (ArrayList<Smartphone>) thisIntent.getSerializableExtra("PHONE_LIST");

        //call phone adaptor class to display the array list's  objects as a list view inside a scroll view
        //each object has certain attributes displayed in a card view
        //if search results array is empty, then display "no matches" text view
        phoneAdaptor = new PhoneAdaptor(this, R.layout.item_phone, phones );
        lvPhones = (ListView) findViewById(R.id.listView);
        lvPhones.setAdapter(phoneAdaptor);

        //assign a header to display the name of the subject we are displaying
        //i.e the category, or the search term
        TextView listTitle = findViewById(R.id.list_title);
        listTitle.setText(title);

        //set up toolbar, assign the text view and the search view icons
        ListToolBar = (Toolbar) findViewById(R.id.list_toolbar);
        setSupportActionBar(ListToolBar);
        rlListToolbar = (RelativeLayout) findViewById(R.id.rl_list_toolbar);
        tvListToolbar = (TextView)  rlListToolbar.getChildAt(0);
        ListSearchView = (SearchView) rlListToolbar.getChildAt(1);

        //heading for if the array list is from search results
        if (sentFrom.equals("search")) {
            tvListToolbar.setText("Search Results for:");
        }

        //add back arrow icon and functionality to go back to mainActivity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ListToolBar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        ListToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        setupPhoneSelectedListener();

        //if the array is empty, display "no matches"
        if (phones.size() == 0) {
            tvEmptyArray = (TextView) findViewById(R.id.empty_arrayList_view);
            tvEmptyArray.setText("No Matches");
        }
    }

    //send object and current array list to detailsActivity as intent
    public void setupPhoneSelectedListener() {
        lvPhones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListActivity.this, DetailsActivity.class);
                intent.putExtra(PHONE_DETAIL_KEY, position);
                intent.putExtra("Similar Phones", phones);
                startActivity(intent);
                overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_left);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //if the intent was from a search result, then we don't display the search view icon
        //i.e we don't allow the user to search in the search results
        Intent thisIntent = getIntent();
        String sentFrom = thisIntent.getStringExtra("FROM");
        if (sentFrom.equals("search")){
            ListSearchView.setVisibility(View.GONE);
        }

        //search view functionality
        ListSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    ListSearchView.clearFocus();
                    ListSearchView.setQuery("", false);
                    ListSearchView.setIconified(true);

                    //ListSearch is the arraylist we will send to listActivity to be displayed
                    ListSearch = new ArrayList<>();
                    for (int j = 0; j < phones.size(); j++) {
                        //contains is case sensitive, but people may type "lumia" rather than "Lumia"
                        //we decided that we would use toLowerCase() so that we would allow our search to not be case sensitive
                        //only need on for loop as we only have one array list to compare against
                        //we compare the search term against the current array list
                        if (phones.get(j).getModel().toLowerCase().contains(query.toLowerCase())) {
                            ListSearch.add(phones.get(j));
                        }
                    }
                    Intent listIntent = new Intent(getBaseContext(), ListActivity.class);
                    listIntent.putExtra("HEADING", query);
                    listIntent.putExtra("FROM", "search");
                    listIntent.putExtra("PHONE_LIST", ListSearch);
                    startActivity(listIntent);
                    overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_left);
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    return false;
                }
            });
            return true;
    }

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_right);
    }
}