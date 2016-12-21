package com.testproject.testproject.modules.news.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.testproject.testproject.R;
import com.testproject.testproject.modules.registration.activity.RegistrationActivity;

/**
 * Created by AlexanderFomich on 21.12.16.
 */

public class FeedFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_feed, null);
        if (view != null) {
        }
        return view;
    }
}
