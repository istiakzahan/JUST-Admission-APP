package com.example.azmery.sqlite_good;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Second_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);


        Intent intent=getIntent();
        String txt=intent.getStringExtra("android");
        String txt_secound=intent.getStringExtra("android_secound");
        String txt_spinner=intent.getStringExtra("android_spinner");
        String txt_room=intent.getStringExtra("android_room");
        String txt_floor=intent.getStringExtra("android_floor");
        String txt_roll=intent.getStringExtra("android_roll");

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

    }
}