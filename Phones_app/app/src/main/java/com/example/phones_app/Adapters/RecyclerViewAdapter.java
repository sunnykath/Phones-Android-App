package com.example.phones_app.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.phones_app.R;
import com.example.phones_app.models.Smartphone;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context rContext;
    ArrayList<Smartphone> rPhones;
    OnPhoneClickListener mOnPhoneClickListener;

    public RecyclerViewAdapter(Context context, ArrayList<Smartphone> phones, OnPhoneClickListener onPhoneClickListener) {
        rContext = context;
        rPhones = phones;
        mOnPhoneClickListener = onPhoneClickListener;       // The on click listener for the interface
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView rImage;
        TextView rPhoneName, rPhonePrice;
        OnPhoneClickListener rOnPhoneClickListener;

        public ViewHolder(View itemView, OnPhoneClickListener onPhoneClickListener) {
            super(itemView);

            // Initialise the views and the on click listener
            rImage      = itemView.findViewById(R.id.recycler_phone_image);
            rPhoneName  = itemView.findViewById(R.id.recycler_phone_name);
            rPhonePrice = itemView.findViewById(R.id.recycler_phone_price);
            rOnPhoneClickListener = onPhoneClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        // Determine the position of the click
        public void onClick(View v) {
            rOnPhoneClickListener.onPhoneClick(getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Inflate the recycler item view and assign it to the view holder alongside the on click listener
        View view = LayoutInflater.from(rContext).inflate(R.layout.item_phone_recycler, parent, false);
        ViewHolder holder = new ViewHolder(view, mOnPhoneClickListener);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // Set the values for the views
        holder.rPhoneName.setText(rPhones.get(position).getModel());
        holder.rPhonePrice.setText('$' + String.valueOf(rPhones.get(position).getPrice()));

        Glide
                .with(rContext)
                .load(rPhones.get(position).getImages()[0]) // Get the first image
                .into(holder.rImage);                       // Load it into the image view

    }

    @Override
    public int getItemCount() {
        return rPhones.size();
    }

    public interface OnPhoneClickListener {
        // Interface to detect any user input
        void onPhoneClick(int position);
    }

}
