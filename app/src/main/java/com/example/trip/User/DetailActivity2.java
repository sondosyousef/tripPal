package com.example.trip.User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.trip.R;

public class DetailActivity2 extends AppCompatActivity {
TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);
        title = findViewById(R.id.title);

        String t = getIntent().getStringExtra("title");
        title.setText(t);
    }
}