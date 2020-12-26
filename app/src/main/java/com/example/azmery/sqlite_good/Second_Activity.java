package com.example.azmery.sqlite_good;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Second_Activity extends AppCompatActivity {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);




        Intent intent=getIntent();
        String txt=intent.getStringExtra("android");
        String txt_secound=intent.getStringExtra("android_secound");
        final String txt_spinner=intent.getStringExtra("android_spinner");
        String txt_room=intent.getStringExtra("android_room");
        String txt_floor=intent.getStringExtra("android_floor");
        String txt_roll=intent.getStringExtra("android_roll");
        String latLng=intent.getStringExtra("lat_lng");

        TextView textView=(TextView)findViewById(R.id.textViewBuilding);
        TextView textView_secound=(TextView)findViewById(R.id.textViewUnit);
        TextView textView_spinner=(TextView)findViewById(R.id.textViewCenter);
        TextView textView_room=(TextView)findViewById(R.id.textViewRoom);
        TextView textView_roll=(TextView)findViewById(R.id.textViewRoll);
        TextView textView_floor=(TextView)findViewById(R.id.textViewFloor);


        textView.setText(txt);
        textView_secound.setText(txt_secound);
        textView_spinner.setText(txt_spinner);
        textView_room.setText(txt_room);
        textView_floor.setText(txt_floor);
        textView_roll.setText(txt_roll);

        //convert string into latlng
        String[] Latlng = latLng.split(",");
        final double latitude = Double.parseDouble(Latlng[0]);
        final double longitude = Double.parseDouble(Latlng[1]);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;

                // Add a marker in Sydney and move the camera
                LatLng sydney = new LatLng(latitude, longitude);
                mMap.addMarker(new MarkerOptions().position(sydney).title(txt_spinner));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,16));
            }
        });
    }
}