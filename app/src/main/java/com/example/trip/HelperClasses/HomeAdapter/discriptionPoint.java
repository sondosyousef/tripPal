package com.example.trip.HelperClasses.HomeAdapter;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.trip.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class discriptionPoint extends AppCompatActivity {


    private static final String TAG = "discription";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discription_point);
        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("image_Url") && getIntent().hasExtra("image_name")&&getIntent().hasExtra("description")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageUrl = getIntent().getStringExtra("image_Url");
            String imageName = getIntent().getStringExtra("image_name");
            String dec = getIntent().getStringExtra("description");

            setImage(imageUrl, imageName,dec);
        }
    }


    private void setImage(String imageUrl, String imageName,String des){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView name = findViewById(R.id.namePoint);
        name.setText(imageName);

        ImageView image1 = findViewById(R.id.imgPoint);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image1);
        TextView descr=findViewById(R.id.description2);
        descr.setText(des);

    }
}