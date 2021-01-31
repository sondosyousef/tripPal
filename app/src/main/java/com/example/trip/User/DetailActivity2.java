package com.example.trip.User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.trip.R;

public class DetailActivity2 extends AppCompatActivity {
TextView title,descript;
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);
        title = findViewById(R.id.title);
        descript=findViewById(R.id.des_location);
        img =findViewById(R.id.Img_location);


        String t = getIntent().getStringExtra("title");
        String dis = getIntent().getStringExtra("ds");
        String url = getIntent().getStringExtra("url");

        Glide.with(this)
                .asBitmap()
                .load(url)
                .into(img);


        title.setText(t);
        descript.setText(dis);
    }
}