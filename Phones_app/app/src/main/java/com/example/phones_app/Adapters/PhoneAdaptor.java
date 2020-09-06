package com.example.phones_app.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.phones_app.R;
import com.example.phones_app.models.Smartphone;

import java.util.ArrayList;

public class PhoneAdaptor extends ArrayAdapter<Smartphone> {
    //This class takes the object and its related card view and displays certain attributes
    //of the object  inside the card view using multiple other views
    Context context;
    int resource;
    ArrayList<Smartphone> aPhones;

    public static class ViewHolder{
        //view holder for all the views that will be displayed in the card view in the ListActivity
        public ImageView ivPhone;
        public TextView  tvPhoneName;
        public TextView tvPhoneStorage;
        public TextView tvPhonePrice;
        public RatingBar rbPhoneRating;

    }
    public PhoneAdaptor(Context context, int resource,  ArrayList<Smartphone> aPhones){
        super(context, resource, aPhones);
        this.context = context;
        this.resource = resource;
        this.aPhones = aPhones;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final Smartphone phone = getItem(position);
        ViewHolder viewHolder;

        //assign views: one image view, 3 text views, and one rating bar
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_phone,parent,false);
            viewHolder.ivPhone          = (ImageView)convertView.findViewById(R.id.phone_image_view);
            viewHolder.tvPhoneName      = (TextView)convertView.findViewById(R.id.phone_name_text_view);
            viewHolder.tvPhoneStorage   = (TextView)convertView.findViewById(R.id.phone_storage_text_view);
            viewHolder.tvPhonePrice     = (TextView)convertView.findViewById(R.id.phone_price_text_view);
            viewHolder.rbPhoneRating    = (RatingBar)convertView.findViewById(R.id.phone_rating_view);
            convertView.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //use object's getters to set information in the card view
        //add extra prefix/suffix
        viewHolder.tvPhoneName.setText(phone.getModel());
        viewHolder.tvPhoneStorage.setText(String.valueOf(phone.getMemoryCapacity()) + " GB");
        viewHolder.tvPhonePrice.setText("$" + String.valueOf(phone.getPrice()));
        viewHolder.rbPhoneRating.setRating((float) phone.getRating());

        // Use glide to access the images from the web
        Glide
                .with(context)
                .load(phone.getImages()[0])         // Load the very first image
                .into(viewHolder.ivPhone);          // Set it into the image view

        return convertView;
    }
}
