package com.example.consultants.week4_daily4.ui.venues;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.example.consultants.week4_daily4.R;
import com.example.consultants.week4_daily4.model.venue.Venue;

import java.util.List;

import butterknife.ButterKnife;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<Venue> venueList;
    private static final String TAG = RecyclerViewAdapter.class.getSimpleName() + "_TAG";

    public RecyclerViewAdapter(List<Venue> venueList) {
        this.venueList = venueList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item, viewGroup, false);



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int i) {

        Venue venue = venueList.get(i);

        viewHolder.tvDsgName.setText(venue.getName());
        viewHolder.tvDsgId.setText(venue.getId());
        viewHolder.tvDsgRating.setText(String.valueOf(venue.getRating()));
        if (venue.getLocation() != null) {
            viewHolder.tvDdsAddress.setText(venue.getLocation().getAddress());
            viewHolder.tvDsgCity.setText(venue.getLocation().getCity());
            viewHolder.tvDsgState.setText(venue.getLocation().getState());
        }

    }

    @Override
    public int getItemCount() {
        return venueList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvDsgName;
        TextView tvDsgId;
        TextView tvDsgRating;
        TextView tvDdsAddress;
        TextView tvDsgCity;
        TextView tvDsgState;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDsgName = itemView.findViewById(R.id.tvDsgName);
            tvDsgId = itemView.findViewById(R.id.tvDsgId);
            tvDsgRating = itemView.findViewById(R.id.tvDsgRating);
            tvDdsAddress = itemView.findViewById(R.id.tvDdsAddress);
            tvDsgCity = itemView.findViewById(R.id.tvDsgCity);
            tvDsgState = itemView.findViewById(R.id.tvDsgState);


        }

    }
}
