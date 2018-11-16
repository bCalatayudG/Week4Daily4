package com.example.consultants.week4_daily4.model.data.remote;

import android.util.Log;

import com.example.consultants.week4_daily4.model.venue.DSGResponse;
import com.example.consultants.week4_daily4.model.venue.Venue;
import com.example.consultants.week4_daily4.utility.NetworkHelper;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {

    private static final String TAG = RemoteDataSource.class.getSimpleName() + "_TAG";

    private Retrofit createInstance() {
        Log.d(TAG, "createInstance: ");
        return new Retrofit.Builder()
                .baseUrl(NetworkHelper.DSG_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private RemoteService getRemoteService() {
        Log.d(TAG, "getRemoteService: ");
        return createInstance().create(RemoteService.class);
    }

    //use call object
    public Call<DSGResponse> getRemoteData() {
        Log.d(TAG, "getRemoteData: ");
        return getRemoteService().getVenueData();
    }


}
