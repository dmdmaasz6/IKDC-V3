package com.indiknowtech.nust.ikdc_v3;

//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.indiknowtech.nust.ikdc_v3.fragments.AudioFragment;
import com.indiknowtech.nust.ikdc_v3.fragments.DrawingFragment;
import com.indiknowtech.nust.ikdc_v3.fragments.ImageFragment;
import com.indiknowtech.nust.ikdc_v3.fragments.TextFragment;
import com.indiknowtech.nust.ikdc_v3.fragments.VideoFragment;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class CreateRequest extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    ImageFragment imageFragment;
    VideoFragment videoFragment;
    AudioFragment audioFragment;
    TextFragment textFragment;
    DrawingFragment drawingFragment;

    int tab_flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_request);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        //TODO: Determine the indigenous loading symbol

        fragmentManager = getFragmentManager();
        imageFragment = new ImageFragment();
        videoFragment = new VideoFragment();
        audioFragment = new AudioFragment();
        textFragment = new TextFragment();
        drawingFragment = new DrawingFragment();

        //***** Load ImageFragment [Flag = 1] Starts
        View.OnClickListener load_imagefragment = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (tab_flag) {
                    case 0:
                        fragmentTransaction = fragmentManager.beginTransaction();

                        fragmentTransaction.add(R.id.container, imageFragment);
                        fragmentTransaction.commit();

                        tab_flag = 1;
                        break;
                    case 2:
                        showHideFragment(imageFragment, audioFragment);
                        break;
                    case 3:
                        showHideFragment(imageFragment, videoFragment);
                        break;
                    case 4:
                        showHideFragment(imageFragment, textFragment);
                        break;
                    case 5:
                        showHideFragment(imageFragment, drawingFragment);
                        break;
                }
            }
        };
        ImageButton imageFragmentButton = (ImageButton) findViewById(R.id.eye);
        imageFragmentButton.setOnClickListener(load_imagefragment);
        //****  Load ImageFragment Ends

        //==========================================================================================

        //**** Load Audio Fragment [Flag = 2] Starts
        View.OnClickListener load_audiofragment = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (tab_flag) {
                    case 0:
                        fragmentTransaction = fragmentManager.beginTransaction();

                        fragmentTransaction.add(R.id.container, audioFragment);
                        fragmentTransaction.commit();

                        tab_flag = 2;
                        break;
                }

            }
        };
        final ImageButton audioFragmentButton = (ImageButton) findViewById(R.id.mouth);
        audioFragmentButton.setOnClickListener(load_audiofragment);
        //**** Load Audio Fragment Ends

        //==========================================================================================

        //**** Load Video Fragment [Flag = 3] Starts
        View.OnClickListener load_videofragment = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (tab_flag) {
                    case 0:
                        fragmentTransaction = fragmentManager.beginTransaction();

                        fragmentTransaction.add(R.id.container, videoFragment);
                        fragmentTransaction.commit();

                        tab_flag = 3;
                        break;
                    case 1:
                        fragmentTransaction.hide(audioFragment);
                }

            }
        };
        ImageButton videoFragmentButton = (ImageButton) findViewById(R.id.feet);
        videoFragmentButton.setOnClickListener(load_videofragment);
        //**** Load Video Fragment

        //==========================================================================================

        //**** Load Text Fragment

        //**** Load Text Fragment

        //==========================================================================================

        //**** Load Drawing Fragment

        //**** Load Drawing Fragment

        //==========================================================================================
    }

    private boolean showHideFragment (Fragment hiddenFragment, Fragment shownFragment){

        try {

            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.hide(shownFragment);
            fragmentTransaction.commit();

            if(!hiddenFragment.isAdded()){

                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.container, hiddenFragment);
                fragmentTransaction.commit();

            }else
            {

                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.show(hiddenFragment);
                fragmentTransaction.commit();

            }

            return true;

        } catch (Exception e){

            return false;

        }
    }

}
