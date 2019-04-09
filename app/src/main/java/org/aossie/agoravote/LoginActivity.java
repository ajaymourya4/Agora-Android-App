package org.aossie.agoravote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private Button mLoginButton;
    private TextInputEditText mUserNameEditText;
    private TextInputEditText mPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        mLoginButton = findViewById(R.id.login_button);
        mUserNameEditText = findViewById(R.id.username_edittext);
        mPasswordEditText = findViewById(R.id.password_edittext);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUserNameEditText.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), "enter your username", Toast.LENGTH_SHORT).show();
                else if (mPasswordEditText.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), "enter your password", Toast.LENGTH_LONG).show();
                else
                    performLoginOperation();
            }
        });


    }

    private void performLoginOperation() {
        Toast.makeText(getApplicationContext(), "Please Wait", Toast.LENGTH_SHORT).show();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("password", mPasswordEditText.getText().toString());
            jsonObject.put("identifier", mUserNameEditText.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post("https://agora-rest-api.herokuapp.com/api/v1/auth/login")
                .addJSONObjectBody(jsonObject)// posting json
                .addHeaders("Content-Type", "application/json")
                .addHeaders("accept", "application/json")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("response", "" + response);
                        try {
                            JSONObject token = response.getJSONObject("token");
                            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        //loadToast.error();
                        Toast.makeText(getApplicationContext(), "wrong username or password", Toast.LENGTH_SHORT).show();
                        // handle error
                        Log.d("errorb", "" + error.getErrorBody());
                        Log.d("errorr", "" + error.getResponse());
                        Log.d("errord", "" + error.getErrorDetail());
                        Log.d("errorc", "" + error.getErrorCode());
                        Log.d("errorm", "" + error.getMessage());
                    }
                });
    }

    public void signup(View view) {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }


}
