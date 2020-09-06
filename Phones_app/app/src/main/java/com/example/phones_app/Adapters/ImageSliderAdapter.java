package com.example.phones_app.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

public class ImageSliderAdapter extends PagerAdapter {

    private Context iContext;
    private String[] images;

    public ImageSliderAdapter(Context context, String[] imageUrls) {
        iContext = context;
        images = imageUrls;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView iv_img = new ImageView(iContext);     // Create and image view

        // Access the images from the webs using Glide
        Glide
                .with(iContext)
                .load(images[position])     // Load the image depending on the adapter position
                .into(iv_img);              // Load it into the image view

        container.addView(iv_img);          // Add the image view to the view pager

        return iv_img;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }
}
