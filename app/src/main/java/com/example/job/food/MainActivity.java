package com.example.job.food;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.job.food.model.DataItem;
import com.example.job.food.sample.SampleDataProvider;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyle_list)RecyclerView recyclerView;
    private DataItemAdapter adapter;
    List<DataItem> dataItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        dataItems = SampleDataProvider.dataItemList;
        adapter = new DataItemAdapter(dataItems, this);

        RecyclerView.LayoutManager layoutManager = new
                GridLayoutManager(this,getResources().getInteger(R.integer.grid_count));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
