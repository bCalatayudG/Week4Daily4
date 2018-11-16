package com.example.consultants.week4_daily4.ui.base;

import android.view.View;

public interface BasePresenter<V extends BaseView> {

    void onAttach(V view);

    void onDetach();

}
