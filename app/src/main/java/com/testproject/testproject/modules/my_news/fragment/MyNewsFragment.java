package com.testproject.testproject.modules.my_news.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.testproject.testproject.R;

/**
 * Created by AlexanderFomich on 21.12.16.
 */

public class MyNewsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_my_news, null);
        if (view != null) {
        }
        return view;
    }
}
