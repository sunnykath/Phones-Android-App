package com.example.phones_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.example.phones_app.MainActivityFragments.AboutFragment;
import com.example.phones_app.MainActivityFragments.AccountFragment;
import com.example.phones_app.MainActivityFragments.HelpFragment;
import com.example.phones_app.MainActivityFragments.MainFragment;
import com.example.phones_app.MainActivityFragments.NotificationsFragment;
import com.example.phones_app.MainActivityFragments.PreferencesFragment;
import com.example.phones_app.models.Smartphone;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    //an activity for the functionality of the main screen and all its fragments
    //Toolbar displays a search view, text view with current fragment name, and drawer navigation icon
    //Drawer contains drawer setting menu with 6 options
    Toolbar SettingsToolBar;
    TextView tvMainToolbar;
    RelativeLayout rlMainToolbar;
    ImageView homeImage;
    SearchView searchView;
    DrawerLayout settingsDrawer;
    ArrayList<ArrayList> phones;
    ArrayList<Smartphone> MainSearch, compare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //replace app bar with toolbar, setting toolbar to act like an action bar
        SettingsToolBar = (Toolbar) findViewById(R.id.settings_drawer_toolbar);
        setSupportActionBar(SettingsToolBar);

        //find and assign the search icon and the home icon that are found in the toolbar
        rlMainToolbar   = (RelativeLayout) findViewById(R.id.rl_main_toolbar);
        tvMainToolbar   = (TextView)  rlMainToolbar.getChildAt(0);
        searchView      = (SearchView) rlMainToolbar.getChildAt(1);
        homeImage       = (ImageView) rlMainToolbar.getChildAt(2);

        //if we just opened the app up, then we should display the main fragment view
        if(savedInstanceState== null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MainFragment()).commit();
            tvMainToolbar.setText("Home");
        }

        settingsDrawer = findViewById(R.id.dl_main_activity);
        NavigationView SettingsNavigationView = findViewById(R.id.settings_nav_view);

        //set on click listeners for each of the menu items in the navigation drawer
        //each menu item in the navigation drawer opens it's own fragment, and the related view
        //change text in the toolbar to the name of the fragment view
        //if the main fragment is opened up, we add the 'home' icon to the tool bar
        SettingsNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_account:
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right).replace(R.id.fragment_container, new AccountFragment(), "SETTINGS").commit();
                        tvMainToolbar.setText("Account");
                        homeImage.setVisibility(View.VISIBLE);
                        break;
                    case R.id.action_notifications:
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right).replace(R.id.fragment_container, new NotificationsFragment(), "SETTINGS").commit();
                        tvMainToolbar.setText("Notifications");
                        homeImage.setVisibility(View.VISIBLE);
                        break;
                    case R.id.action_preferences:
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right).replace(R.id.fragment_container, new PreferencesFragment(), "SETTINGS").commit();
                        tvMainToolbar.setText("Preferences");
                        homeImage.setVisibility(View.VISIBLE);
                        break;
                    case R.id.action_help_and_feedback:
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right).replace(R.id.fragment_container, new HelpFragment(), "SETTINGS").commit();
                        tvMainToolbar.setText("Feedback");
                        homeImage.setVisibility(View.VISIBLE);
                        break;
                    case R.id.action_about:
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right).replace(R.id.fragment_container, new AboutFragment(), "SETTINGS").commit();
                        tvMainToolbar.setText("About");
                        homeImage.setVisibility(View.VISIBLE);
                        break;
                    case R.id.action_home:
                        //check whether we are the main fragment, settings fragment, or if the drawer menu is open
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.findFragmentByTag("SETTINGS");
                        if (fragmentManager.findFragmentByTag("SETTINGS") != null) {
                            getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_left).replace(R.id.fragment_container, new MainFragment(), "HOME").commit();
                            //hide 'home' icon on the main fragment view
                            tvMainToolbar.setText("Home");
                            homeImage.setVisibility(View.GONE);
                        }
                        break;
                }
                    settingsDrawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        //assign navigation icon to the burger icon and add animation
        //add opening drawer functionality
        ActionBarDrawerToggle toggleSettings = new ActionBarDrawerToggle(this, settingsDrawer, SettingsToolBar, R.string.settings_drawer_open, R.string.settings_drawer_close);
        settingsDrawer.addDrawerListener(toggleSettings);
        toggleSettings.syncState();

        //generate smartphone objects using data provider class to use in the search function
        phones = PhoneProvider.generateData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_settings_menu, menu);

        //menu items appear in toolbar as well as navigation drawer
        //we make them invisible in the toolbar itself
        menu.setGroupVisible(R.id.overflow_items, false);
        menu.setGroupVisible(R.id.home_icon, false);

        //search view functionality
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                searchView.setQuery("", false);
                searchView.setIconified(true);

                //Main search is the array list we will send to listActivity to be displayed
                MainSearch = new ArrayList<>();
                for (int i = 0; i < phones.size(); i++) {
                    //compare is the array list of objects whose model name we will be comparing the search term to
                    compare = phones.get(i);
                    for (int j = 0; j < compare.size(); j++) {
                        //contains is case sensitive, but people may type "iphone" rather than "iPhone"
                        //we decided that we would use toLowerCase() so that we would allow our search to not be case sensitive
                        //2 for loops as we have an array list containing array lists
                        //we compare the search term against our entire database
                        if (compare.get(j).getModel().toLowerCase().contains(query.toLowerCase())) {
                            MainSearch.add(compare.get(j));
                        }
                    }
                }

                //crete and send intent, along with the search results array list (MainsSearch)
                //also include key to tell the ListActivity what the search term was, and where this list is coming from
                //i.e is this list a search result or a category
                Intent listIntent = new Intent(getBaseContext(), ListActivity.class);
                listIntent.putExtra("HEADING", query);
                listIntent.putExtra("FROM", "search");
                listIntent.putExtra("PHONE_LIST", MainSearch);
                startActivity(listIntent);
                overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_left);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        //home icon functionality
        homeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_left).replace(R.id.fragment_container,new MainFragment()).commit();
                //since home icon sends us to main fragment, and we don't want the home icon in the main fragment itself
                //we make the icon invisible once we tap it
                homeImage.setVisibility(View.GONE);
                tvMainToolbar.setText("Home");
            }
        });
        return true;
    }

    //if we are in a settings fragment, i.e not in the main fragment
    //we decided that the back button should send you back to the main view first, rather than exiting you out of the app
    //if we have the drawer view open, we also want to close it first with the back button before exiting the app
    @Override
    public void onBackPressed() {
        //check whether we are the main fragment, settings fragment, or if the drawer menu is open
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.findFragmentByTag("SETTINGS");
        if (settingsDrawer.isDrawerOpen((GravityCompat.START))) {
            settingsDrawer.closeDrawer((GravityCompat.START));
        } else if (fragmentManager.findFragmentByTag("SETTINGS") != null) {
            getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_left).replace(R.id.fragment_container,new MainFragment()).commit();
            homeImage.setVisibility(View.GONE);
            tvMainToolbar.setText("Home");
        }else {
            super.onBackPressed();
        }
    }

}

