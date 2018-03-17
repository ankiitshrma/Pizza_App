package com.example.ankiit.navigation;

/**
 * Created by Ankiit on 17-Mar-18.
 */

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import butterknife.ButterKnife;


public class login extends AppCompatActivity {
    Button btn;
    TextView tv;
    EditText ie;
    EditText ip;
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;






    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.bind(this);
        btn = (Button) findViewById(R.id.btn_login);
        tv =(TextView)findViewById(R.id.link_signup) ;
        ie =findViewById(R.id.input_email);
        ip =findViewById(R.id.input_password);
      /*  _loginButton*/ btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), signup.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                overridePendingTransition(R.anim.pushi, R.anim.pusho);
            }
        });
    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        btn.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(login.this,
                R.style.Theme_Design_Light);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email = ie.getText().toString();
        String password = ip.getText().toString();



        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {

                        onLoginSuccess();

                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        btn.setEnabled(true);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        btn.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = ie.getText().toString();
        String password = ip.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            ie.setError("enter a valid email address");
            valid = false;
        } else {
            ie.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            ip.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            ip.setError(null);
        }

        return valid;
    }
}

