package com.testproject.testproject.modules.main.activity;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.testproject.testproject.R;
import com.testproject.testproject.core.preferences.SharedPreferencesHelper;
import com.testproject.testproject.modules.news.fragment.FeedFragment;
import com.testproject.testproject.modules.my_news.fragment.MyNewsFragment;
import com.testproject.testproject.modules.profile.fragment.ProfileFragment;
import com.testproject.testproject.modules.registration.activity.RegistrationActivity;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout newsBtn;
    private RelativeLayout myNewsBtn;
    private RelativeLayout profileBtn;

    private TextView newsTxv;
    private TextView myNewsTxv;
    private TextView profileTxv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(checkUser()) {
            setupView();

        } else {
            final Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private boolean checkUser() {
        return new SharedPreferencesHelper(this).getData("username") != null;
    }

    private void setupView() {
        newsBtn = (RelativeLayout) findViewById(R.id.feed_btn);
        myNewsBtn = (RelativeLayout) findViewById(R.id.my_news_btn);
        profileBtn = (RelativeLayout) findViewById(R.id.profile_btn);
        newsTxv = (TextView) findViewById(R.id.news_txv);
        myNewsTxv = (TextView) findViewById(R.id.my_news_txv);
        profileTxv = (TextView) findViewById(R.id.profile_txv);
        openFeedFragment();

        newsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFeedFragment();
            }
        });

        myNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMyNewsFragment();
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfileFragment();
            }
        });
    }

    private void openFeedFragment() {
        selectTxv(newsTxv);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new FeedFragment()).commit();
    }

    private void openMyNewsFragment() {
        selectTxv(myNewsTxv);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new MyNewsFragment()).commit();
    }

    private void openProfileFragment() {
        selectTxv(profileTxv);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new ProfileFragment()).commit();
    }

    private void selectTxv(final TextView textView) {
        newsTxv.setTextColor(ContextCompat.getColor(this,R.color.unselected_tab));
        myNewsTxv.setTextColor(ContextCompat.getColor(this,R.color.unselected_tab));
        profileTxv.setTextColor(ContextCompat.getColor(this,R.color.unselected_tab));

        textView.setTextColor(ContextCompat.getColor(this,R.color.selected_tab));


    }

}
