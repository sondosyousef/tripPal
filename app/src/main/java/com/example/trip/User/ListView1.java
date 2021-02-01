package com.example.trip.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.trip.R;

import java.util.ArrayList;

public class ListView1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view1);
        ListView l1 = findViewById(R.id.list_plan);

        String name = getIntent().getStringExtra("Message");
        String date = getIntent().getStringExtra("RemindDate");
        String data = name+"\n"+ date;
        ArrayList<String> A= new ArrayList<>();
         A.add(data);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, A);

        l1.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }
}