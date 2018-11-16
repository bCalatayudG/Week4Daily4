package com.example.consultants.week4_daily4.ui.venues;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.consultants.week4_daily4.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VenueActivity extends AppCompatActivity implements VenueContract.View {

    VenuePresenter presenter;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new VenuePresenter();

        presenter.getVenueData(recyclerView,this);
    }

    @Override
    public void showError(String error) {

    }
}
