package com.testproject.testproject.modules.registration.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.testproject.testproject.R;
import com.testproject.testproject.modules.registration.activity.RegistrationActivity;


public class ConfirmationFragment extends Fragment implements Button.OnClickListener{
    private EditText codeEt;
    private Button signInBtn;
    private RegistrationActivity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_confirmation, null);
        if (view != null) {
            codeEt = (EditText) view.findViewById(R.id.code_et);
            signInBtn = (Button) view.findViewById(R.id.login_btn);
            signInBtn.setOnClickListener(this);

            activity = (RegistrationActivity) getActivity();
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        codeEt.setError(null);
        if(codeEt.getText().toString().equals("1111")) {
            activity.openMainActivity();
        } else {
            codeEt.setError(getString(R.string.incorrect_code));
        }

    }
}
