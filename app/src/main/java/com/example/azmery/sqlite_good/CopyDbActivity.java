package com.example.azmery.sqlite_good;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class CopyDbActivity extends AppCompatActivity {

    Spinner spinner;
    String[] SPINNERVALUES = {"A","B","C","D","E","F"};


    SQLiteDatabase db;
    Cursor cursor;
    EditText _txtEmail, _txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copy_db);


        _txtEmail=(EditText)findViewById(R.id.editText2);

        spinner =(Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(CopyDbActivity.this, android.R.layout.simple_list_item_1, SPINNERVALUES);
        spinner.setAdapter(adapter);

        //Adding setOnItemSelectedListener method on spinner.
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                TextView textView_selected_unit=(TextView)findViewById(R.id.selected_unit);

                textView_selected_unit.setText(spinner.getSelectedItem().toString());


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

        ((Button) findViewById(R.id.button01)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper myDbHelper = new DatabaseHelper(CopyDbActivity.this);

                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                try {
                    myDbHelper.openDataBase();
                } catch (SQLException sqle) {
                    throw sqle;
                }
               /* Toast.makeText(CopyDbActivity.this, "Successfully Imported", Toast.LENGTH_SHORT).show();*/


                db = myDbHelper.getReadableDatabase();

                String roll = _txtEmail.getText().toString();
                String message_spinner = spinner.getSelectedItem().toString();

                cursor = db.rawQuery("SELECT *FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_1 + "=? AND " + DatabaseHelper.COL_2 + "<=? AND " + DatabaseHelper.COL_3 + ">=?", new String[]{message_spinner, roll, roll});
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                       /* Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();*/
                        cursor.moveToNext();
                        String vall = cursor.getString(cursor.getColumnIndex("building_name"));
                        String vall2 = cursor.getString(cursor.getColumnIndex("unit"));
                        String vall3 = cursor.getString(cursor.getColumnIndex("exam_centre"));
                        String vall4 = cursor.getString(cursor.getColumnIndex("room_no"));
                        String vall5 = cursor.getString(cursor.getColumnIndex("floor_venue"));
                       /* Toast.makeText(getApplicationContext(), "your submitted answer is "+vall, Toast.LENGTH_LONG).show();*/

                        Intent intent=new Intent(CopyDbActivity.this,Second_Activity.class);
                        intent.putExtra("android", vall);
                        intent.putExtra("android_secound", vall2);
                        intent.putExtra("android_spinner", vall3);
                        intent.putExtra("android_room", vall4);
                        intent.putExtra("android_floor", vall5);
                        intent.putExtra("android_roll", roll);
                        startActivity(intent);


                    } else {
                        Toast.makeText(getApplicationContext(), "Not Found", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}

