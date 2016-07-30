package com.indiknowtech.nust.ikdc_v3;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import  android.content.Intent;
import android.widget.ImageButton;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        //***** View request Intent starts
        OnClickListener ondjatuOpen = new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ondatuOpenActivity = new Intent(getApplicationContext(), OndjatuOpen.class);
                startActivity(ondatuOpenActivity);
            }
        };
        ImageButton ondjatuOpenButton = (ImageButton) findViewById(R.id.ViewRequest);
        ondjatuOpenButton.setOnClickListener(ondjatuOpen);
        //****  View request Intent ends

        //****  Create request Intent starts
        OnClickListener ondjatuClosed = new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ondatuClosedActivity = new Intent(getApplicationContext(), OndjatuClosed.class);
                startActivity(ondatuClosedActivity);
            }
        };
        ImageButton ondjatuCloseButton = (ImageButton) findViewById(R.id.CreateRequest);
        ondjatuCloseButton.setOnClickListener(ondjatuClosed);
        //****  Create request Intent starts

        //****  Modify request Intent starts
        OnClickListener oruvio = new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oruvioActivity = new Intent(getApplicationContext(), Oruvio.class);
                startActivity(oruvioActivity);
            }
        };
        ImageButton oruvioButton = (ImageButton) findViewById(R.id.ModifyRequest);
        oruvioButton.setOnClickListener(oruvio);
        //****  Modify request Intent ends

        //****  Send request Intent starts
        OnClickListener ondjupa = new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ondjupaActivity = new Intent(getApplicationContext(), Oruvio.class);
                startActivity(ondjupaActivity);
            }
        };
        ImageButton ondjupaButton = (ImageButton) findViewById(R.id.SendRequest);
        ondjupaButton.setOnClickListener(ondjupa);
        //****  Send request Intent ends

        //****  View completed request Intent starts
        OnClickListener oserekazi = new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oserekaziActivity = new Intent(getApplicationContext(), Oserekazi.class);
                startActivity(oserekaziActivity);
            }
        };
        ImageButton oserekaziButton = (ImageButton) findViewById(R.id.ViewRequest);
        ondjupaButton.setOnClickListener(oserekazi);
        //****  View completed request Intent ends

    }

}
