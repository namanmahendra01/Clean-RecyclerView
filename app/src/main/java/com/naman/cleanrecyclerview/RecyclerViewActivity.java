package com.naman.cleanrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.naman.cleanrecyclerview.Adapters.NumberAdapter;
import com.naman.cleanrecyclerview.interfaces.onItemClickListener;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView numberRv;
    NumberAdapter numberAdapter;
    ArrayList<Integer> integerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindData();
        initData();
        setUpRecyclerView();
    }

    private void bindData() {
        integerList = new ArrayList<>();
        numberRv = findViewById(R.id.Rv);
    }

    private void initData() {
        for (int x = 0; x < 100; x++) {
            integerList.add(x);
        }
    }

    private void setUpRecyclerView() {

//        setup layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RecyclerViewActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

//        set up interface for click listener
        onItemClickListener onItemClickListener = new onItemClickListener() {
            @Override
            public void onClick(View v, int position, String data) {
                Log.d(TAG, "onClick: TextView is clicked");
                Log.d(TAG, "onClick: " + v);
                Log.d(TAG, "onClick: " + position);
                Log.d(TAG, "onClick: " + data);


            }

            @Override
            public void onImageClicked() {
                Log.d(TAG, "onImageClicked: ImageView is Clicked");
            }
        };

//        set up adapter
        numberAdapter = new NumberAdapter(integerList, this, onItemClickListener);


//        setRecyclerView with layout manager and adapter
        numberRv.setLayoutManager(linearLayoutManager);
        numberRv.setAdapter(numberAdapter);
    }


}