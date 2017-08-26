package com.example.job.food;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.job.food.model.DataItem;
import com.example.job.food.sample.SampleDataProvider;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    public static final String ITEM_KEY = "ITEM_KEY";

    @BindView(R.id.recyle_list)RecyclerView recyclerView;
    private DataItemAdapter adapter;
    List<DataItem> dataItems;
    private RecyclerView.LayoutManager layoutManager;
    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        dataItems = SampleDataProvider.dataItemList;
        adapter = new DataItemAdapter(dataItems, this);

        layoutManager = new
                GridLayoutManager(this,getResources().getInteger(R.integer.grid_count));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }
    void gridOptionSelect(){
        layoutManager = new
                GridLayoutManager(this,2);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        recyclerView.setLayoutManager(layoutManager);
    }
    void gridOptionUnSelect(){
        layoutManager = new
                GridLayoutManager(this,2);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.sign_in:{
                Intent intent = new Intent(this,SignActivity.class);
                startActivity(intent);
                return true;
            }
            case R.id.settings:{
                Toast.makeText(this,"settings intent",Toast.LENGTH_SHORT).show();
                return true;
            }
            default:{
                return super.onOptionsItemSelected(item);
            }
        }
    }
}
