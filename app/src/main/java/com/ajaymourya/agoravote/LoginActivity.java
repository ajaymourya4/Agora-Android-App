package com.ajaymourya.agoravote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

    }


    public void login(View view) {
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }

    public void signup(View view) {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }
}
