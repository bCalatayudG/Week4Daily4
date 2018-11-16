package com.example.consultants.week4_daily4.model.data.remote;

import com.example.consultants.week4_daily4.model.venue.DSGResponse;
import com.example.consultants.week4_daily4.model.venue.Venue;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RemoteService {

    //    using the call object
    @GET("venue")
    Call<DSGResponse> getVenueData();


}
