package com.indiknowtech.nust.TMA;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        OnClickListener viewRequest = new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewRequestActivity = new Intent(getApplicationContext(), ViewRequest.class);
                startActivity(viewRequestActivity);
            }
        };
        ImageButton viewRequestButton = (ImageButton) findViewById(R.id.ViewRequest);
        viewRequestButton.setOnClickListener(viewRequest);
        //****  View request Intent ends

        //****  Create request Intent starts
        OnClickListener createRequest = new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent createRequestActivity = new Intent(getApplicationContext(), CreateRequest.class);
                startActivity(createRequestActivity);
            }
        };
        ImageButton createRequestButton = (ImageButton) findViewById(R.id.CreateRequest);
        createRequestButton.setOnClickListener(createRequest);
        //****  Create request Intent starts

        //****  Modify request Intent starts
        OnClickListener modifyRequest = new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent modifyRequestActivity = new Intent(getApplicationContext(), ModifyRequest.class);
                startActivity(modifyRequestActivity);
            }
        };
        ImageButton modifyRequestButton = (ImageButton) findViewById(R.id.ModifyRequest);
        modifyRequestButton.setOnClickListener(modifyRequest);
        //****  Modify request Intent ends

        //****  Send request Intent starts
        OnClickListener sendRequest = new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendRequestActivity = new Intent(getApplicationContext(), ModifyRequest.class);
                startActivity(sendRequestActivity);
            }
        };
        ImageButton sendRequestButton = (ImageButton) findViewById(R.id.SendRequest);
        sendRequestButton.setOnClickListener(sendRequest);
        //****  Send request Intent ends

        //****  View completed request Intent starts
        OnClickListener completedRequest = new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent completedRequestActivity = new Intent(getApplicationContext(), ViewCompletedRequest.class);
                startActivity(completedRequestActivity);
            }
        };
        ImageButton completedRequestButton = (ImageButton) findViewById(R.id.ViewRequest);
        completedRequestButton.setOnClickListener(completedRequest);
        //****  View completed request Intent ends

    }

}
