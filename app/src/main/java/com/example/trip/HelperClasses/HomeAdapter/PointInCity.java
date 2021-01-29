package com.example.trip.HelperClasses.HomeAdapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.trip.R;

public class PointInCity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_in_city);
        getIncomingIntent();

    }

    private void getIncomingIntent() {
        if(getIntent().hasExtra("point1") && getIntent().hasExtra("img_point1")
                &&getIntent().hasExtra("point2") && getIntent().hasExtra("img_point2")
                &&getIntent().hasExtra("point3") && getIntent().hasExtra("img_point3")
                &&getIntent().hasExtra("point4") && getIntent().hasExtra("img_point4")){


            String imageUrl = getIntent().getStringExtra("img_point1");
            String imageName = getIntent().getStringExtra("point1");
            String imageUrl2 = getIntent().getStringExtra("img_point2");
            String imageName2 = getIntent().getStringExtra("point2");
            String imageUrl3 = getIntent().getStringExtra("img_point3");
            String imageName3 = getIntent().getStringExtra("point3");
            String imageUrl4 = getIntent().getStringExtra("img_point4");
            String imageName4 = getIntent().getStringExtra("point4");


            setImage(imageUrl, imageName,imageName2,imageUrl2,imageName3,imageUrl3,imageName4,imageUrl4);
        }
    }

    private void setImage(String imageUrl, String imageName,String imageName2,String imageUrl2,String imageName3,String imageUrl3,String imageName4,String imageUrl4 ) {
        TextView name = findViewById(R.id.point1);
        name.setText(imageName);

        ImageView image = findViewById(R.id.img_point1);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
        TextView name2 = findViewById(R.id.point2);
        name2.setText(imageName2);

        ImageView image2 = findViewById(R.id.img_point2);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl2)
                .into(image2);
        TextView name3 = findViewById(R.id.point3);
        name3.setText(imageName3);

        ImageView image3 = findViewById(R.id.img_point3);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl3)
                .into(image3);
        TextView name4 = findViewById(R.id.point4);
        name4.setText(imageName4);

        ImageView image4 = findViewById(R.id.img_point4);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl4)
                .into(image4);
    }
}