package com.example.consultants.week4_daily4.ui.venues;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.consultants.week4_daily4.model.data.remote.RemoteDataSource;
import com.example.consultants.week4_daily4.model.venue.DSGResponse;
import com.example.consultants.week4_daily4.model.venue.Venue;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VenuePresenter implements VenueContract.Presenter{
    VenueContract.View view;
    private RemoteDataSource remoteDataSource;
    private RecyclerViewAdapter adapter;

    private static final String TAG = VenuePresenter.class.getSimpleName() + "_TAG";


    @Override
    public void onAttach(VenueContract.View v) {
        this.view=v;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }

    @Override
    public void getVenueData(final RecyclerView recyclerView, final Context context) {
        remoteDataSource = new RemoteDataSource();
        Log.d(TAG, "getVenueData: ");
        remoteDataSource.getRemoteData().enqueue(new Callback<DSGResponse>() {
            @Override
            public void onResponse(Call<DSGResponse> call, Response<DSGResponse> response) {
                Log.d(TAG, "onResponse: "+ response.body().getVenues().size());
                Log.d(TAG, "onResponse: "+response.body().getVenues().get(1).getId());
                List<Venue> venueList = new ArrayList<>();
                for (Venue venue:response.body().getVenues()) {
                    venueList.add(venue);
                }

                adapter = new RecyclerViewAdapter(venueList);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(layoutManager);


            }

            @Override
            public void onFailure(Call<DSGResponse> call, Throwable t) {

            }
        });
    }
}
