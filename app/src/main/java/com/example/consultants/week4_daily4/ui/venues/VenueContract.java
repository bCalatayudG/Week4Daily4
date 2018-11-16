package com.example.consultants.week4_daily4.ui.venues;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.consultants.week4_daily4.ui.base.BasePresenter;
import com.example.consultants.week4_daily4.ui.base.BaseView;

public interface VenueContract {
    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<View> {

        void getVenueData(RecyclerView recyclerView, Context context);
    }

}
