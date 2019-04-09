package com.ajaymourya.agoravote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

public class SignupActivity extends AppCompatActivity {

    private TextInputEditText mUserNameEditText;
    private TextInputEditText mFirstNameEditText;
    private TextInputEditText mLastNameEditText;
    private TextInputEditText mEmailEditText;
    private TextInputEditText mPasswordEditText;
    private Button mSignUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        mUserNameEditText = findViewById(R.id.signup_username_edittext);
        mFirstNameEditText = findViewById(R.id.firstname_edittext);
        mLastNameEditText = findViewById(R.id.lastname_edittext);
        mEmailEditText = findViewById(R.id.email_edittext);
        mPasswordEditText = findViewById(R.id.signup_password_edittext);
        mSignUpButton = findViewById(R.id.signup_button);

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUserNameEditText.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), "please enter username", Toast.LENGTH_SHORT).show();
                else if (mFirstNameEditText.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), "please enter username", Toast.LENGTH_SHORT).show();
                else if (mLastNameEditText.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), "please enter username", Toast.LENGTH_SHORT).show();
                else if (mEmailEditText.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), "please enter username", Toast.LENGTH_SHORT).show();
                else if (mPasswordEditText.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), "please enter username", Toast.LENGTH_SHORT).show();
                else
                    performSignUpOperation();
            }
        });


    }

    private void performSignUpOperation() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("firstName", mFirstNameEditText.getText().toString());
            jsonObject.put("lastName", mLastNameEditText.getText().toString());
            jsonObject.put("email", mEmailEditText.getText().toString());
            jsonObject.put("password", mPasswordEditText.getText().toString());
            jsonObject.put("identifier", mUserNameEditText.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post("https://agora-rest-api.herokuapp.com/api/v1/auth/signup")
                .addJSONObjectBody(jsonObject)// posting json
                .addHeaders("Content-Type", "application/json")
                .addHeaders("accept", "application/json")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        // do anything with response
                        Log.d("response", "" + response);
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));

                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        Log.d("errorb", "" + error.getErrorBody());
                        Log.d("errorr", "" + error.getResponse());
                        Log.d("errord", "" + error.getErrorDetail());
                        Log.d("errorc", "" + error.getErrorCode());
                        Log.d("errorm", "" + error.getMessage());
                        Toast.makeText(getApplicationContext(), "" + error.getErrorBody(), Toast.LENGTH_SHORT).show();
                    }
                });
    }


    public void login(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
