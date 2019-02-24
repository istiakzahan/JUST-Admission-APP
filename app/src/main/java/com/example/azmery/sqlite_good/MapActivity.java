package com.example.azmery.sqlite_good;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class MapActivity extends AppCompatActivity {

    ImageView image;
    PhotoViewAttacher photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        image=findViewById(R.id.image);
        photo=new PhotoViewAttacher(image);
    }
}
