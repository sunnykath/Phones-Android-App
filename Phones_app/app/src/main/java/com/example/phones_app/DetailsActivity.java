package com.example.phones_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.phones_app.Adapters.ImageSliderAdapter;
import com.example.phones_app.Adapters.RecyclerViewAdapter;
import com.example.phones_app.models.Smartphone;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity implements RecyclerViewAdapter.OnPhoneClickListener {

    //Toolbar displays a navigation icon back arrow
    Toolbar DetailsToolBar;

    private TextView tvName;
    private TextView tvPrice;
    private TextView tvOS;
    private TextView tvStorage;
    private TextView tvRating;
    private ViewPager vpImages;
    private ArrayList<Smartphone> similarPhones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Initialise views
        vpImages    = (ViewPager) findViewById(R.id.image_slider);
        tvName      = (TextView) findViewById(R.id.phone_name);
        tvPrice     = (TextView) findViewById(R.id.phone_price);
        tvOS        = (TextView) findViewById(R.id.phone_os);
        tvStorage   = (TextView) findViewById(R.id.phone_storage);
        tvRating    = (TextView) findViewById(R.id.phone_rating);


        // Receive intent
        Intent thisIntent = getIntent();
        int position =  (int) thisIntent.getSerializableExtra(ListActivity.PHONE_DETAIL_KEY);
        ArrayList<Smartphone> phones = (ArrayList<Smartphone>) thisIntent.getSerializableExtra("Similar Phones");

        // Display details for the selected phone
        displayPhone(phones.get(position));

        // Remove the phone being displayed from the similar phones array
        similarPhones = new ArrayList<Smartphone>(phones);
        similarPhones.remove(position);

        displaySimilarPhones(similarPhones);

        // Set up the tool bar - back arrow
        DetailsToolBar = (Toolbar) findViewById(R.id.details_toolbar);
        DetailsToolBar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        DetailsToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void displaySimilarPhones(ArrayList<Smartphone> similarPhones) {

        // Initialise the Recycler View
        RecyclerView rView = findViewById(R.id.recycler_similar);
        LinearLayoutManager llm = new LinearLayoutManager
                (this, LinearLayoutManager.HORIZONTAL, false);
        rView.setLayoutManager(llm);
        // Set the adapter
        RecyclerViewAdapter rAdapter = new RecyclerViewAdapter(this, similarPhones, this);
        rView.setAdapter(rAdapter);

    }

    private void displayPhone(Smartphone phone) {

        // Set up all the details in the text views
        tvName.setText(phone.getModel());
        tvPrice.setText(("$" + String.valueOf(phone.getPrice())));
        tvOS.setText(phone.getOS());
        tvStorage.setText((String.valueOf(phone.getMemoryCapacity()) + " GB"));
        tvRating.setText(String.valueOf(phone.getRating()));

        // Initialise the image slider adapter and pass it on the view pager to display the images
        ImageSliderAdapter adapter = new ImageSliderAdapter(this, phone.getImages());
        vpImages.setAdapter(adapter);

    }

    @Override
    public void onPhoneClick(int position) {
        // Recycler view on click method
        Intent intent = new Intent(DetailsActivity.this, DetailsActivity.class);
        intent.putExtra(ListActivity.PHONE_DETAIL_KEY, position);
        intent.putExtra("Similar Phones", similarPhones);
        finish();
        startActivity(intent);
    }
    @Override
    public void finish(){       // Override the transitions when the activity is finished
        super.finish();
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_right);
    }
}
