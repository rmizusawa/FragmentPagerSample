package com.example.fragmentpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SampleFragment extends Fragment {

    public static final String ARGS_RESOURCE = "resource";
    public static final String ARGS_INDEX = "index";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Bundle args = getArguments();

        ResourceDto resource;
        if (args != null) {
            resource = (ResourceDto)args.getSerializable(ARGS_RESOURCE);
            int index = args.getInt(ARGS_INDEX);

            try {
                TextView textv = (TextView)rootView.findViewById(R.id.disptext);
                textv.setText(resource.text);

            } catch (Exception e) {
                Log.e("error", e.getMessage());
            }
        }


        return rootView;
    }


}
