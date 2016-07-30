package com.indiknowtech.nust.ikdc_v3;

//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.indiknowtech.nust.ikdc_v3.fragments.ImageFragment;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class CreateRequest extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_request);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        //TODO: Determine the indigenous loading symbol

        //***** Load ImageFragment Starts
        View.OnClickListener load_imagefragment = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                ImageFragment fragment = new ImageFragment();
                fragmentTransaction.add(R.id.container, fragment);
                fragmentTransaction.commit();
            }
        };
        ImageButton viewRequestButton = (ImageButton) findViewById(R.id.eye);
        viewRequestButton.setOnClickListener(load_imagefragment);
        //****  Load ImageFragment Ends

        //**** Load Audio Fragment

        //**** Load Audio Fragment

        //**** Load Video Fragment

        //**** Load Video Fragment

        //**** Load Text Fragment

        //**** Load Text Fragment

        //**** Load Drawing Fragment
        
        //**** Load Drawing Fragment

    }


}
