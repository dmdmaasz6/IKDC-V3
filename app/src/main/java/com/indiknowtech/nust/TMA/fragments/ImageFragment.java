package com.indiknowtech.nust.TMA.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.app.Fragment;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.indiknowtech.nust.TMA.GridView_Src.GridViewAdapter;
import com.indiknowtech.nust.TMA.GridView_Src.ImageItem;
import com.indiknowtech.nust.TMA.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
//import com.google.firebase:firebase-ads:9.0.2;
//import com.google.android.gms.plus.PlusOneButton;

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * {@link ImageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ImageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageFragment extends Fragment {
    /**
     * GridView Variable Declaration Section Starts
     */

    private GridView gridView;
    private GridViewAdapter gridAdapter;

    /**
     * GridView Variable Declaration Section Ends
     */


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // The request code must be 0 or greater.
    private static final int PLUS_ONE_REQUEST_CODE = 0;
    // The URL to +1.  Must be a valid URL.
    private final String PLUS_ONE_URL = "http://developer.android.com";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
 //   private PlusOneButton mPlusOneButton;

    private OnFragmentInteractionListener mListener;

    public ImageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ImageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ImageFragment newInstance(String param1, String param2) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        //gridView = new GridView(getActivity());
        gridView =(GridView) getActivity().findViewById(R.id.image_gallery);
        gridAdapter = new GridViewAdapter(getActivity(), R.layout.grid_item_layout, getData());
        if (getActivity().findViewById(R.id.image_gallery) == null)
        {
            Toast.makeText(getActivity(), "Loaded!", Toast.LENGTH_LONG).show();
        }
        //gridView.setAdapter(gridAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image, container, false);

        //Find the +1 button
 //       mPlusOneButton = (PlusOneButton) view.findViewById(R.id.plus_one_button);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Refresh the state of the +1 button each time the activity receives focus.
   //     mPlusOneButton.initialize(PLUS_ONE_URL, PLUS_ONE_REQUEST_CODE);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    /**
     * The Section Below is responsible for retrieving the images
     */

    // Prepare some dummy data for gridview
    private List<ImageItem> getData() {
        final List<ImageItem> imageItems = new ArrayList<ImageItem>();

        File targetDirector = new File(Environment.getExternalStorageDirectory() + "/IKDC/commonStorage/images/");

        /*if (targetDirector.exists())
        {
            Toast.makeText(getActivity(), targetDirector.getAbsolutePath(), Toast.LENGTH_LONG).show();
            Toast.makeText(getActivity(), "Directory Found", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getActivity(), targetDirector.getAbsolutePath(), Toast.LENGTH_LONG).show();
            Toast.makeText(getActivity(), "No Such Directory", Toast.LENGTH_LONG).show();
        }*/

        File[] files = targetDirector.listFiles();

        //Toast.makeText(getActivity(), files.toString(), Toast.LENGTH_LONG).show();
        try {
            for (File file : files) {

                BitmapFactory.Options bmOptions = new BitmapFactory.Options();
                Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath(), bmOptions);
                bitmap = Bitmap.createScaledBitmap(bitmap, 200, 200, true);

                imageItems.add(new ImageItem(bitmap, file.getName()));

                //storyGallery.addView(layout);

            }
        } catch (Exception e){

        }

        /*for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, "Image#" + i));
        }*/

        return imageItems;
    }


}
