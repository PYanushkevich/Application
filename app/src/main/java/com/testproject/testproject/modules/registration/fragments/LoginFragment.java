package com.testproject.testproject.modules.registration.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.testproject.testproject.R;
import com.testproject.testproject.modules.registration.activity.RegistrationActivity;
import com.testproject.testproject.modules.registration.api.RegistrationInteractor;


public class LoginFragment extends Fragment implements Button.OnClickListener {
    private EditText telephoneEt;
    private EditText emailEt;
    private Button nextBtn;
    private TextView errorTxv;
    private RegistrationActivity activity;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_login, null);
        if (view != null) {
            telephoneEt = (EditText) view.findViewById(R.id.telephone_et);
            emailEt = (EditText) view.findViewById(R.id.email_et);
            errorTxv = (TextView) view.findViewById(R.id.error_txv);
            progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
            nextBtn = (Button) view.findViewById(R.id.next_btn);
            nextBtn.setOnClickListener(this);
            activity = (RegistrationActivity) getActivity();
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        errorTxv.setVisibility(View.GONE);
        telephoneEt.setError(null);
        emailEt.setError(null);
        if (telephoneEt.getText().toString().length() > 0) {
            if(isPhoneValid()) {
                sendRegistrationRequest(telephoneEt.getText().toString());
            } else {
                telephoneEt.setError(getString(R.string.telephone_et_error));
            }
        } else if (emailEt.getText().toString().length() > 0) {
            if(isEmailValid()) {
                sendRegistrationRequest(emailEt.getText().toString());
            } else {
                emailEt.setError(getString(R.string.email_et_error));
            }
        } else {
            errorTxv.setVisibility(View.VISIBLE);
        }
    }

    private boolean isPhoneValid() {
        final int phoneDigits = telephoneEt.getText().toString().length();
        return !(phoneDigits < 6 || phoneDigits > 13);
    }

    private boolean isEmailValid() {
        final String email = emailEt.getText().toString();
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void sendRegistrationRequest(final String username) {
        progressBar.setVisibility(View.VISIBLE);
        RegistrationInteractor.sendRegistrationRequest(activity, username, new RegistrationInteractor.Callback() {
            @Override
            public void onSuccess() {
                //Success request, show confirmation code frament
                progressBar.setVisibility(View.GONE);
                openConfirmCodeFragment(username);
            }

            @Override
            public void onError(String error) {
                progressBar.setVisibility(View.GONE);
                //Show error to user

            }
        });

    }
    private void openConfirmCodeFragment(final String username) {
        activity.openConfirmCodeFragment(username);
    }
}
