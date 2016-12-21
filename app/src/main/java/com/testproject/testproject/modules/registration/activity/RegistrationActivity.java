package com.testproject.testproject.modules.registration.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.testproject.testproject.R;
import com.testproject.testproject.core.preferences.SharedPreferencesHelper;
import com.testproject.testproject.modules.main.activity.MainActivity;
import com.testproject.testproject.modules.registration.fragments.ConfirmationFragment;
import com.testproject.testproject.modules.registration.fragments.LoginFragment;

public class RegistrationActivity extends AppCompatActivity {
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new LoginFragment()).commit();
    }


    public void openConfirmCodeFragment(final String username) {
        this.username = username;
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new ConfirmationFragment()).commit();
    }

    public void openMainActivity() {
        new SharedPreferencesHelper(this).saveData("username", username);
        final Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
